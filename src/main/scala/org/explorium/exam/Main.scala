package org.explorium.exam

import org.explorium.exam.config.ConfigManager
import org.explorium.exam.reader.OSMReader
import org.explorium.exam.writer.CSVWriter


object Main extends App {
  val config = ConfigManager.getAppConfig
  val osmDF = OSMReader
    .read(config.inputConfig)
  val processedDF = OSMProcessor.process(osmDF)
  CSVWriter.write(processedDF, config.outputConfig)
}
