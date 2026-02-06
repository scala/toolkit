# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_sjs1_3:0.8.1` from `0.8.1` to `0.9.0` under `org.scala-lang:toolkit-test_sjs1_3:0.9.0`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upickle_sjs1_3:4.4.1`
 - Updated `com.lihaoyi:ujson_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upickle_sjs1_3:4.4.2`
 - Updated `com.lihaoyi:upack_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upickle_sjs1_3:4.4.1`
 - Updated `com.lihaoyi:upack_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upickle_sjs1_3:4.4.2`
 - Updated `com.lihaoyi:upickle-core_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:ujson_sjs1_3:4.4.2`
 - Updated `com.lihaoyi:upickle-core_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upack_sjs1_3:4.4.2`
 - Updated `com.lihaoyi:upickle-core_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upickle-implicits_sjs1_3:4.4.2`
 - Updated `com.lihaoyi:upickle-implicits_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upickle_sjs1_3:4.4.1`
 - Updated `com.lihaoyi:upickle-implicits_sjs1_3:4.4.0` from `4.4.0` to `4.4.2` under `com.lihaoyi:upickle_sjs1_3:4.4.2`
 - Updated `com.lihaoyi:upickle_sjs1_3:4.1.0` from `4.1.0` to `4.4.2` under `org.scala-lang:toolkit_sjs1_3:0.9.0`
 - Updated `com.lihaoyi:upickle_sjs1_3:4.4.0` from `4.4.0` to `4.4.1` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.15`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_3:4.0.13` from `4.0.13` to `4.0.15` under `com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.15`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_3:4.0.13` from `4.0.13` to `4.0.15` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.15`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_3:4.0.13` from `4.0.13` to `4.0.15` under `org.scala-lang:toolkit_sjs1_3:0.9.0`
 - Updated `com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.13` from `4.0.13` to `4.0.15` under `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.15`
 - Updated `com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.13` from `4.0.13` to `4.0.15` under `org.scala-lang:toolkit_sjs1_3:0.9.0`

## Full dependency tree

 - org.scala-lang:toolkit-test_sjs1_3:0.9.0
   - org.scala-lang:toolkit_sjs1_3:0.9.0
     - com.lihaoyi:upickle_sjs1_3:4.4.2
       - com.lihaoyi:ujson_sjs1_3:4.4.2
         - com.lihaoyi:upickle-core_sjs1_3:4.4.2
           - com.lihaoyi:geny_sjs1_3:1.1.1
       - com.lihaoyi:upack_sjs1_3:4.4.2
         - com.lihaoyi:upickle-core_sjs1_3:4.4.2 (already listed)
       - com.lihaoyi:upickle-implicits_sjs1_3:4.4.2
         - com.lihaoyi:upickle-core_sjs1_3:4.4.2 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_3:4.0.15
       - com.softwaremill.sttp.model:core_sjs1_3:1.7.17
         - io.github.cquiroz:scala-java-time_sjs1_3:2.6.0
           - io.github.cquiroz:scala-java-locales_sjs1_3:1.5.4
             - io.github.cquiroz:cldr-api_sjs1_3:4.5.0
               - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.3
           - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.3 (already listed)
       - com.softwaremill.sttp.shared:core_sjs1_3:1.5.0
       - com.softwaremill.sttp.shared:ws_sjs1_3:1.5.0
         - com.softwaremill.sttp.model:core_sjs1_3:1.7.12
           - io.github.cquiroz:scala-java-time_sjs1_3:2.6.0 (already listed)
         - com.softwaremill.sttp.shared:core_sjs1_3:1.5.0 (already listed)
     - com.softwaremill.sttp.client4:upickle_sjs1_3:4.0.15
       - com.lihaoyi:upickle_sjs1_3:4.4.1
         - com.lihaoyi:ujson_sjs1_3:4.4.2 (already listed)
         - com.lihaoyi:upack_sjs1_3:4.4.2 (already listed)
         - com.lihaoyi:upickle-implicits_sjs1_3:4.4.2 (already listed)
       - com.softwaremill.sttp.client4:core_sjs1_3:4.0.15 (already listed)
       - com.softwaremill.sttp.client4:json-common_sjs1_3:4.0.15
         - com.softwaremill.sttp.client4:core_sjs1_3:4.0.15 (already listed)
   - org.scalameta:munit_sjs1_3:1.2.1
     - org.scalameta:munit-diff_sjs1_3:1.2.1
