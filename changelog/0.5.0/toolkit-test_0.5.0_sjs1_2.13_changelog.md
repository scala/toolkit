# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_sjs1_2.13:0.4.0` from `0.4.0` to `0.5.0` under `org.scala-lang:toolkit-test_sjs1_2.13:0.5.0`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upack_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:ujson_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upack_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `org.scala-lang:toolkit_sjs1_2.13:0.5.0`

## Full dependency tree

 - org.scala-lang:toolkit-test_sjs1_2.13:0.5.0
   - org.scala-lang:toolkit_sjs1_2.13:0.5.0
     - com.lihaoyi:upickle_sjs1_2.13:3.3.1
       - com.lihaoyi:ujson_sjs1_2.13:3.3.1
         - com.lihaoyi:upickle-core_sjs1_2.13:3.3.1
           - com.lihaoyi:geny_sjs1_2.13:1.1.0
       - com.lihaoyi:upack_sjs1_2.13:3.3.1
         - com.lihaoyi:upickle-core_sjs1_2.13:3.3.1 (already listed)
       - com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.1
         - com.lihaoyi:upickle-core_sjs1_2.13:3.3.1 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M14
       - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.10
         - io.github.cquiroz:scala-java-time_sjs1_2.13:2.5.0
           - io.github.cquiroz:scala-java-locales_sjs1_2.13:1.5.1
             - io.github.cquiroz:cldr-api_sjs1_2.13:4.0.0
               - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2
           - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2 (already listed)
       - com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.18
       - com.softwaremill.sttp.shared:ws_sjs1_2.13:1.3.18
         - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.10 (already listed)
         - com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.18 (already listed)
     - com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M14
       - com.lihaoyi:upickle_sjs1_2.13:3.3.0
         - com.lihaoyi:ujson_sjs1_2.13:3.3.1 (already listed)
         - com.lihaoyi:upack_sjs1_2.13:3.3.1 (already listed)
         - com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.1 (already listed)
       - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M14 (already listed)
       - com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-M14
         - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M14 (already listed)
   - org.scalameta:munit_sjs1_2.13:1.0.0-RC1
     - org.scalameta:munit-diff_sjs1_2.13:1.0.0-RC1
