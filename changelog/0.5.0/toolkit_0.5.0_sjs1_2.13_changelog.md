# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:upickle_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `org.scala-lang:toolkit_sjs1_2.13:0.5.0`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M14` from `4.0.0-M14` to `4.0.0-M16` under `org.scala-lang:toolkit_sjs1_2.13:0.5.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M14` from `4.0.0-M14` to `4.0.0-M16` under `org.scala-lang:toolkit_sjs1_2.13:0.5.0` ILLEGAL CHANGE (required at least: MajorUpdate)

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upack_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:ujson_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upack_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-core_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.lihaoyi:upickle_sjs1_2.13:3.3.1`
 - Updated `com.lihaoyi:upickle_sjs1_2.13:3.3.0` from `3.3.0` to `3.3.1` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M16`
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M14` from `4.0.0-M14` to `4.0.0-M16` under `com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-M16` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M14` from `4.0.0-M14` to `4.0.0-M16` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M16` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-M14` from `4.0.0-M14` to `4.0.0-M16` under `com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M16` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.18` from `1.3.18` to `1.3.19` under `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M16`
 - Updated `com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.18` from `1.3.18` to `1.3.19` under `com.softwaremill.sttp.shared:ws_sjs1_2.13:1.3.19`
 - Updated `com.softwaremill.sttp.shared:ws_sjs1_2.13:1.3.18` from `1.3.18` to `1.3.19` under `com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M16`

## Full dependency tree

 - org.scala-lang:toolkit_sjs1_2.13:0.5.0
   - com.lihaoyi:upickle_sjs1_2.13:3.3.1
     - com.lihaoyi:ujson_sjs1_2.13:3.3.1
       - com.lihaoyi:upickle-core_sjs1_2.13:3.3.1
         - com.lihaoyi:geny_sjs1_2.13:1.1.0
     - com.lihaoyi:upack_sjs1_2.13:3.3.1
       - com.lihaoyi:upickle-core_sjs1_2.13:3.3.1 (already listed)
     - com.lihaoyi:upickle-implicits_sjs1_2.13:3.3.1
       - com.lihaoyi:upickle-core_sjs1_2.13:3.3.1 (already listed)
   - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M16
     - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.10
       - io.github.cquiroz:scala-java-time_sjs1_2.13:2.5.0
         - io.github.cquiroz:scala-java-locales_sjs1_2.13:1.5.1
           - io.github.cquiroz:cldr-api_sjs1_2.13:4.0.0
             - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2
         - org.portable-scala:portable-scala-reflect_sjs1_2.13:1.1.2 (already listed)
     - com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.19
     - com.softwaremill.sttp.shared:ws_sjs1_2.13:1.3.19
       - com.softwaremill.sttp.model:core_sjs1_2.13:1.7.10 (already listed)
       - com.softwaremill.sttp.shared:core_sjs1_2.13:1.3.19 (already listed)
   - com.softwaremill.sttp.client4:upickle_sjs1_2.13:4.0.0-M16
     - com.lihaoyi:upickle_sjs1_2.13:3.3.1 (already listed)
     - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M16 (already listed)
     - com.softwaremill.sttp.client4:json-common_sjs1_2.13:4.0.0-M16
       - com.softwaremill.sttp.client4:core_sjs1_2.13:4.0.0-M16 (already listed)
