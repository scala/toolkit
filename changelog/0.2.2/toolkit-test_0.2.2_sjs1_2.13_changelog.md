# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_sjs1_2.13:0.2.1` from `0.2.1` to `0.2.2` under `org.scala-lang:toolkit-test_sjs1_2.13:0.2.2`

## Full dependency tree

 - org.scala-lang:toolkit-test_sjs1_2.13:0.2.2
   - org.scala-lang:toolkit_sjs1_2.13:0.2.2
     - com.lihaoyi:upickle_sjs1_2.13:3.1.3
       - com.lihaoyi:ujson_sjs1_2.13:3.1.3
         - com.lihaoyi:upickle-core_sjs1_2.13:3.1.3
           - com.lihaoyi:geny_sjs1_2.13:1.0.0
       - com.lihaoyi:upack_sjs1_2.13:3.1.3
         - com.lihaoyi:upickle-core_sjs1_2.13:3.1.3 (already listed)
       - com.lihaoyi:upickle-implicits_sjs1_2.13:3.1.3
         - com.lihaoyi:upickle-core_sjs1_2.13:3.1.3 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M6
       - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.2
         - io.github.cquiroz:scala-java-time_sjs1_2.13:2.5.0
           - io.github.cquiroz:scala-java-locales_sjs1_2.13:1.5.1
             - io.github.cquiroz:cldr-api_sjs1_2.13:4.0.0
               - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2
           - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2 (already listed)
       - com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.16
       - com.softwaremill.sttp.shared:ws_sjs1_2.13:1.3.16
         - com.softwaremill.sttp.model:core_sjs1_2.13:1.6.0
           - io.github.cquiroz:scala-java-time_sjs1_2.13:2.5.0 (already listed)
         - com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.16 (already listed)
     - com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M6
       - com.lihaoyi:upickle_sjs1_2.13:3.1.3 (already listed)
       - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M6 (already listed)
       - com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-M6
         - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M6 (already listed)
   - org.scalameta:munit_sjs1_2.13:1.0.0-M10
