name := "Explorium"

version := "0.1"

scalaVersion := "2.11.8"

resolvers += "GeoMajas" at "http://maven.geomajas.org/"

val sparkVersion = "2.4.4"
val hadoopVersion = "2.7.3"
val geoSparkVersion = "1.3.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.hadoop" % "hadoop-aws" % hadoopVersion,
  "org.datasyslab" % "geospark" % geoSparkVersion,
  "org.datasyslab" % "geospark-sql_2.3" % geoSparkVersion,
  "com.wolt.osm" %% "spark-osm-datasource" % "0.3.0",
  "com.github.pureconfig" %% "pureconfig" % "0.13.0"
)

