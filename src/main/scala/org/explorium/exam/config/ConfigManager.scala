package org.explorium.exam.config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

object ConfigManager {

  def getAppConfig: AppConfig = {
    val config = ConfigSource.default.load[AppConfig]
    config match {
      case Left(a) => throw new IllegalArgumentException(s"Error parsing AppConfig - ${config.left.get.toString}")
      case Right(b) => b
    }
  }

}
