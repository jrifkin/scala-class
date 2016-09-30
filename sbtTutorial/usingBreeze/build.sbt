
// Read here for dependencies
// https://github.com/scalanlp/breeze#sbt

// Set sub-project on SBT start: http://stackoverflow.com/a/22240142/1007926
onLoad in Global := { Command.process("project distributions", _: State) } compose (onLoad in Global).value

// formatting of dependencies
// http://www.scala-sbt.org/0.13/docs/Library-Dependencies.html#The++key
// Task 4d
lazy val commonSettings =  Seq(
  	scalaVersion := "2.11.8",
  	version := "0.1.0",
	libraryDependencies ++= Seq(
		"org.scalanlp" %% "breeze" % "0.12",
		"org.scalanlp" %% "breeze-natives" % "0.12"
		),
	resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)

// Task 4c
lazy val root = (project in file(".")).
  settings(
    name := "hello",
    version := "1.0"
	).aggregate(distributions,plotting)

// Task 4a
lazy val distributions = (project in file("distributions")).
  	settings(
    	name := "distributions"
  	).settings(commonSettings:_*)

// Task 4b
lazy val plotting = (project in file("plotting")).
	settings(
		name := "plotting",
	    libraryDependencies ++= Seq(
	  		"org.scalanlp" %% "breeze-viz" % "0.12"
	  	)
	).settings(commonSettings:_*).dependsOn(distributions)


