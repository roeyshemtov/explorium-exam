package org.explorium.exam

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{count, explode, lower, split, sum}
import org.explorium.exam.spark.SparkSessionBuilder

object OSMProcessor {

  def process(df: DataFrame): DataFrame = {
    val spark = SparkSessionBuilder.getSparkSession
    import spark.implicits._

    df
      .drop("INFO", "WAY", "RELATION", "LAT", "LON", "TYPE")
      .withColumn("street", $"TAG".getItem("addr:street"))
      .withColumn("amenity", $"TAG".getItem("amenity"))
      .drop($"TAG")
      .where($"street".isNotNull)
      .where($"amenity".isNotNull)
      .withColumn("amenity", split($"amenity", ";"))
      .withColumn("amenity", explode($"amenity"))
      .groupBy("street", "amenity")
      .agg(count("*").as("cnt"))
      .groupBy("street")
      .pivot(lower($"amenity"))
      .agg(sum("cnt").as("numOfPlaces"))
      .na
      .fill(0)
  }

}
