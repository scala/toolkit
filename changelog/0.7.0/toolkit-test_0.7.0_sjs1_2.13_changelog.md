# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_sjs1_2.13:0.6.0` from `0.6.0` to `0.7.0` under `org.scala-lang:toolkit-test_sjs1_2.13:0.7.0`
 - Updated `org.scalameta:munit_sjs1_2.13:1.0.2` from `1.0.2` to `1.1.0` under `org.scala-lang:toolkit-test_sjs1_2.13:0.7.0`

## Changes to transitive dependencies
 - Updated `com.lihaoyi:geny_sjs1_2.13:1.1.0` from `1.1.0` to `1.1.1` under `com.lihaoyi:upickle-core_sjs1_2.13:4.1.0`
 - Updated `com.lihaoyi:ujson_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle_sjs1_2.13:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upack_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle_sjs1_2.13:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:ujson_sjs1_2.13:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upack_sjs1_2.13:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle-implicits_sjs1_2.13:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle_sjs1_2.13:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle_sjs1_2.13:3.3.1` from `3.3.1` to `4.1.0` under `org.scala-lang:toolkit_sjs1_2.13:0.7.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `org.scala-lang:toolkit_sjs1_2.13:0.7.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `org.scala-lang:toolkit_sjs1_2.13:0.7.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.22` from `1.3.22` to `1.4.2` under `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-RC1`
 - Updated `com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.22` from `1.3.22` to `1.4.2` under `com.softwaremill.sttp.shared:ws_sjs1_2.13:1.4.2`
 - Updated `com.softwaremill.sttp.shared:ws_sjs1_2.13:1.3.22` from `1.3.22` to `1.4.2` under `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-RC1`
 - Updated `org.scalameta:munit-diff_sjs1_2.13:1.0.2` from `1.0.2` to `1.1.0` under `org.scalameta:munit_sjs1_2.13:1.1.0`

## Full dependency tree

 - org.scala-lang:toolkit-test_sjs1_2.13:0.7.0
   - org.scala-lang:toolkit_sjs1_2.13:0.7.0
     - com.lihaoyi:upickle_sjs1_2.13:4.1.0
       - com.lihaoyi:ujson_sjs1_2.13:4.1.0
         - com.lihaoyi:upickle-core_sjs1_2.13:4.1.0
           - com.lihaoyi:geny_sjs1_2.13:1.1.1
       - com.lihaoyi:upack_sjs1_2.13:4.1.0
         - com.lihaoyi:upickle-core_sjs1_2.13:4.1.0 (already listed)
       - com.lihaoyi:upickle-implicits_sjs1_2.13:4.1.0
         - com.lihaoyi:upickle-core_sjs1_2.13:4.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-RC1
       - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.11
         - io.github.cquiroz:scala-java-time_sjs1_2.13:2.5.0
           - io.github.cquiroz:scala-java-locales_sjs1_2.13:1.5.1
             - io.github.cquiroz:cldr-api_sjs1_2.13:4.0.0
               - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2
           - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2 (already listed)
       - com.softwaremill.sttp.shared:core_sjs1_2.13:1.4.2
       - com.softwaremill.sttp.shared:ws_sjs1_2.13:1.4.2
         - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.11 (already listed)
         - com.softwaremill.sttp.shared:core_sjs1_2.13:1.4.2 (already listed)
     - com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-RC1
       - com.lihaoyi:upickle_sjs1_2.13:4.1.0 (already listed)
       - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-RC1 (already listed)
       - com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-RC1
         - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-RC1 (already listed)
   - org.scalameta:munit_sjs1_2.13:1.1.0
     - org.scalameta:munit-diff_sjs1_2.13:1.1.0
