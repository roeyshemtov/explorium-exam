package org.explorium.exam.reader

import com.wolt.osm.spark.OsmSource.OsmSource
import org.apache.spark.sql.DataFrame
import org.explorium.exam.config.InputConfig
import org.explorium.exam.spark.SparkSessionBuilder

object OSMReader {

  def read(config: InputConfig): DataFrame = {
    val spark = SparkSessionBuilder.getSparkSession

    spark
      .read
      .option("partitions", config.parallelism)
      .option("threads", config.threads)
      .format(OsmSource.OSM_SOURCE_NAME)
      .load(config.path)
  }

}
