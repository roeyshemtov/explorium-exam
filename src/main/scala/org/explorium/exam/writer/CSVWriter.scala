package org.explorium.exam.writer

import org.apache.spark.sql.DataFrame
import org.explorium.exam.config.OutputConfig

object CSVWriter {

  def write(df: DataFrame, outputConfig: OutputConfig) = {
    df
      .coalesce(outputConfig.numFiles)
      .write
      .option("header", true)
      .csv(outputConfig.path)
  }
}
