
plugins_(
  "com.geirsson"       % "sbt-ci-release"           % "1.2.1",
  "org.scala-sbt"      % "sbt-contraband"           % "0.4.3",
  "io.get-coursier"    % "sbt-coursier"             % sbtCoursierVersion,
  "com.typesafe"       % "sbt-mima-plugin"          % "0.3.0",
  "com.jsuereth"       % "sbt-pgp"                  % "1.1.2",
  "io.get-coursier"    % "sbt-shading"              % sbtCoursierVersion
)

libs ++= Seq(
  "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value,
  compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full), // for shapeless / auto type class derivations
  "com.github.alexarchambault" %% "argonaut-shapeless_6.2" % "1.2.0-M9"
)

// required for just released things
resolvers += Resolver.sonatypeRepo("releases")


def plugins_(modules: ModuleID*) = modules.map(addSbtPlugin)
def libs = libraryDependencies
