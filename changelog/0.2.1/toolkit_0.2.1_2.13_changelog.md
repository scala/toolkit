# Changelog for toolkit 0.2.1

## Changes to direct dependencies
 - Updated `com.lihaoyi:upickle_2.13:3.1.0` from `3.1.0` to `3.1.3` under `org.scala-lang:toolkit_2.13:0.2.1`
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1` from `4.0.0-M1` to `4.0.0-M6` under `org.scala-lang:toolkit_2.13:0.2.1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M1` from `4.0.0-M1` to `4.0.0-M6` under `org.scala-lang:toolkit_2.13:0.2.1` ILLEGAL CHANGE (required at least: MajorUpdate)

## Changes to transitive dependencies
 - Updated `com.lihaoyi:ujson_2.13:3.1.0` from `3.1.0` to `3.1.3` under `com.lihaoyi:upickle_2.13:3.1.3`
 - Updated `com.lihaoyi:upack_2.13:3.1.0` from `3.1.0` to `3.1.3` under `com.lihaoyi:upickle_2.13:3.1.3`
 - Updated `com.lihaoyi:upickle-core_2.13:3.1.0` from `3.1.0` to `3.1.3` under `com.lihaoyi:ujson_2.13:3.1.3`
 - Updated `com.lihaoyi:upickle-core_2.13:3.1.0` from `3.1.0` to `3.1.3` under `com.lihaoyi:upack_2.13:3.1.3`
 - Updated `com.lihaoyi:upickle-core_2.13:3.1.0` from `3.1.0` to `3.1.3` under `com.lihaoyi:upickle-implicits_2.13:3.1.3`
 - Updated `com.lihaoyi:upickle-implicits_2.13:3.1.0` from `3.1.0` to `3.1.3` under `com.lihaoyi:upickle_2.13:3.1.3`
 - Updated `com.lihaoyi:upickle_2.13:3.0.0` from `3.0.0` to `3.1.3` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M6` ILLEGAL CHANGE (required at least: MinorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1` from `4.0.0-M1` to `4.0.0-M6` under `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M6` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_2.13:4.0.0-M1` from `4.0.0-M1` to `4.0.0-M6` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M6` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M1` from `4.0.0-M1` to `4.0.0-M6` under `com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M6` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.model:core_2.13:1.5.5` from `1.5.5` to `1.6.0` under `com.softwaremill.sttp.shared:ws_2.13:1.3.16` ILLEGAL CHANGE (required at least: MinorUpdate)
 - Updated `com.softwaremill.sttp.model:core_2.13:1.5.5` from `1.5.5` to `1.7.2` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M6` ILLEGAL CHANGE (required at least: MinorUpdate)
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.3.13` from `1.3.13` to `1.3.16` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M6`
 - Updated `com.softwaremill.sttp.shared:core_2.13:1.3.13` from `1.3.13` to `1.3.16` under `com.softwaremill.sttp.shared:ws_2.13:1.3.16`
 - Updated `com.softwaremill.sttp.shared:ws_2.13:1.3.13` from `1.3.13` to `1.3.16` under `com.softwaremill.sttp.client4:core_2.13:4.0.0-M6`

## Full dependency tree

 - org.scala-lang:toolkit_2.13:0.2.1
   - com.lihaoyi:os-lib_2.13:0.9.1
     - com.lihaoyi:geny_2.13:1.0.0
   - com.lihaoyi:upickle_2.13:3.1.3
     - com.lihaoyi:ujson_2.13:3.1.3
       - com.lihaoyi:upickle-core_2.13:3.1.3
         - com.lihaoyi:geny_2.13:1.0.0 (already listed)
     - com.lihaoyi:upack_2.13:3.1.3
       - com.lihaoyi:upickle-core_2.13:3.1.3 (already listed)
     - com.lihaoyi:upickle-implicits_2.13:3.1.3
       - com.lihaoyi:upickle-core_2.13:3.1.3 (already listed)
   - com.softwaremill.sttp.client4:core_2.13:4.0.0-M6
     - com.softwaremill.sttp.model:core_2.13:1.7.2
     - com.softwaremill.sttp.shared:core_2.13:1.3.16
     - com.softwaremill.sttp.shared:ws_2.13:1.3.16
       - com.softwaremill.sttp.model:core_2.13:1.6.0
       - com.softwaremill.sttp.shared:core_2.13:1.3.16 (already listed)
   - com.softwaremill.sttp.client4:upickle_2.13:4.0.0-M6
     - com.lihaoyi:upickle_2.13:3.1.3 (already listed)
     - com.softwaremill.sttp.client4:core_2.13:4.0.0-M6 (already listed)
     - com.softwaremill.sttp.client4:json-common_2.13:4.0.0-M6
       - com.softwaremill.sttp.client4:core_2.13:4.0.0-M6 (already listed)
