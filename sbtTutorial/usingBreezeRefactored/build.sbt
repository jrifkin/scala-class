

// emulate this: https://github.com/TrueCar/mleap/blob/master/build.sbt

// Set sub-project on SBT start: http://stackoverflow.com/a/22240142/1007926
// onLoad in Global := {
//   Command.process("project distributions", _: State)
// } compose (onLoad in Global).value

// Task 5h

lazy val root = (project in file(".")).
  settings(name := "hello",
    version := Common.commonSettings.version
	).aggregate(distributions,plotting)

lazy val distributions = (project in file("distributions")).
  	settings(
    	name := "distributions"
  	).settings(Common.commonSettings:_*)

lazy val plotting = (project in file("plotting")).
	settings(
		name := "plotting",
	    libraryDependencies ++= Dependencies.plottingDependencies
	).settings(Common.commonSettings:_*).dependsOn(distributions)



