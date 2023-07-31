# Changelog for toolkit-test 0.2.0

## Changes to direct dependencies
 - Added `org.scala-lang:toolkit_sjs1_3:0.2.0` under `org.scala-lang:toolkit-test_sjs1_3:0.2.0`

## Changes to transitive dependencies
 - Added `com.lihaoyi:geny_sjs1_3:1.0.0` under `com.lihaoyi:upickle-core_sjs1_3:3.1.0`
 - Added `com.lihaoyi:ujson_sjs1_3:3.1.0` under `com.lihaoyi:upickle_sjs1_3:3.0.0`
 - Added `com.lihaoyi:ujson_sjs1_3:3.1.0` under `com.lihaoyi:upickle_sjs1_3:3.1.0`
 - Added `com.lihaoyi:upack_sjs1_3:3.1.0` under `com.lihaoyi:upickle_sjs1_3:3.0.0`
 - Added `com.lihaoyi:upack_sjs1_3:3.1.0` under `com.lihaoyi:upickle_sjs1_3:3.1.0`
 - Added `com.lihaoyi:upickle-core_sjs1_3:3.1.0` under `com.lihaoyi:ujson_sjs1_3:3.1.0`
 - Added `com.lihaoyi:upickle-core_sjs1_3:3.1.0` under `com.lihaoyi:upack_sjs1_3:3.1.0`
 - Added `com.lihaoyi:upickle-core_sjs1_3:3.1.0` under `com.lihaoyi:upickle-implicits_sjs1_3:3.1.0`
 - Added `com.lihaoyi:upickle-implicits_sjs1_3:3.1.0` under `com.lihaoyi:upickle_sjs1_3:3.0.0`
 - Added `com.lihaoyi:upickle-implicits_sjs1_3:3.1.0` under `com.lihaoyi:upickle_sjs1_3:3.1.0`
 - Added `com.lihaoyi:upickle_sjs1_3:3.0.0` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M1`
 - Added `com.lihaoyi:upickle_sjs1_3:3.1.0` under `org.scala-lang:toolkit_sjs1_3:0.2.0`
 - Added `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1` under `com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.0-M1`
 - Added `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M1`
 - Added `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1` under `org.scala-lang:toolkit_sjs1_3:0.2.0`
 - Added `com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.0-M1` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M1`
 - Added `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M1` under `org.scala-lang:toolkit_sjs1_3:0.2.0`
 - Added `com.softwaremill.sttp.model:core_sjs1_3:1.5.5` under `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1`
 - Added `com.softwaremill.sttp.model:core_sjs1_3:1.5.5` under `com.softwaremill.sttp.shared:ws_sjs1_3:1.3.13`
 - Added `com.softwaremill.sttp.shared:core_sjs1_3:1.3.13` under `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1`
 - Added `com.softwaremill.sttp.shared:core_sjs1_3:1.3.13` under `com.softwaremill.sttp.shared:ws_sjs1_3:1.3.13`
 - Added `com.softwaremill.sttp.shared:ws_sjs1_3:1.3.13` under `com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1`
 - Added `io.github.cquiroz:cldr-api_sjs1_3:3.1.0` under `io.github.cquiroz:scala-java-locales_sjs1_3:1.4.0`
 - Added `io.github.cquiroz:scala-java-locales_sjs1_3:1.4.0` under `io.github.cquiroz:scala-java-time_sjs1_3:2.4.0`
 - Added `io.github.cquiroz:scala-java-time_sjs1_3:2.4.0` under `com.softwaremill.sttp.model:core_sjs1_3:1.5.5`
 - Added `org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.1` under `io.github.cquiroz:cldr-api_sjs1_3:3.1.0`
 - Added `org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2` under `io.github.cquiroz:scala-java-time_sjs1_3:2.4.0`

## Full dependency tree

 - org.scala-lang:toolkit-test_sjs1_3:0.2.0
   - org.scala-lang:toolkit_sjs1_3:0.2.0
     - com.lihaoyi:upickle_sjs1_3:3.1.0
       - com.lihaoyi:ujson_sjs1_3:3.1.0
         - com.lihaoyi:upickle-core_sjs1_3:3.1.0
           - com.lihaoyi:geny_sjs1_3:1.0.0
       - com.lihaoyi:upack_sjs1_3:3.1.0
         - com.lihaoyi:upickle-core_sjs1_3:3.1.0 (already listed)
       - com.lihaoyi:upickle-implicits_sjs1_3:3.1.0
         - com.lihaoyi:upickle-core_sjs1_3:3.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1
       - com.softwaremill.sttp.model:core_sjs1_3:1.5.5
         - io.github.cquiroz:scala-java-time_sjs1_3:2.4.0
           - io.github.cquiroz:scala-java-locales_sjs1_3:1.4.0
             - io.github.cquiroz:cldr-api_sjs1_3:3.1.0
               - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.1
           - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2
       - com.softwaremill.sttp.shared:core_sjs1_3:1.3.13
       - com.softwaremill.sttp.shared:ws_sjs1_3:1.3.13
         - com.softwaremill.sttp.model:core_sjs1_3:1.5.5 (already listed)
         - com.softwaremill.sttp.shared:core_sjs1_3:1.3.13 (already listed)
     - com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.0-M1
       - com.lihaoyi:upickle_sjs1_3:3.0.0
         - com.lihaoyi:ujson_sjs1_3:3.1.0 (already listed)
         - com.lihaoyi:upack_sjs1_3:3.1.0 (already listed)
         - com.lihaoyi:upickle-implicits_sjs1_3:3.1.0 (already listed)
       - com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1 (already listed)
       - com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.0-M1
         - com.softwaremill.sttp.client4:core_sjs1_3:4.0.0-M1 (already listed)
   - org.scalameta:munit_sjs1_3:1.0.0-M7
