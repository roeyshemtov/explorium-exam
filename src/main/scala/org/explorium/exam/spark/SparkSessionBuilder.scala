package org.explorium.exam.spark

import org.apache.spark.sql.SparkSession
import org.datasyslab.geosparksql.utils.GeoSparkSQLRegistrator

object SparkSessionBuilder {
  private var sparkSession: SparkSession = _

  def getSparkSession: SparkSession = {
    if (sparkSession != null) {
      return sparkSession
    }
    sparkSession = SparkSession.builder.master("local[*]").appName("Explorium").getOrCreate()
    GeoSparkSQLRegistrator.registerAll(sparkSession)

    sparkSession
  }

}
