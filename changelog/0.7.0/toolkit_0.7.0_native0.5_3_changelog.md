# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:upickle_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `org.scala-lang:toolkit_native0.5_3:0.7.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `org.scala-lang:toolkit_native0.5_3:0.7.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `org.scala-lang:toolkit_native0.5_3:0.7.0` ILLEGAL CHANGE (required at least: MajorUpdate)

## Changes to transitive dependencies
 - Updated `com.lihaoyi:geny_native0.5_3:1.1.0` from `1.1.0` to `1.1.1` under `com.lihaoyi:upickle-core_native0.5_3:4.1.0`
 - Updated `com.lihaoyi:ujson_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle_native0.5_3:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upack_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle_native0.5_3:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-core_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:ujson_native0.5_3:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-core_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upack_native0.5_3:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-core_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle-implicits_native0.5_3:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle-implicits_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `com.lihaoyi:upickle_native0.5_3:4.1.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.lihaoyi:upickle_native0.5_3:3.3.1` from `3.3.1` to `4.1.0` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.0-M19` from `4.0.0-M19` to `4.0.0-RC1` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.shared:core_native0.5_3:1.3.22` from `1.3.22` to `1.4.2` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1`
 - Updated `com.softwaremill.sttp.shared:core_native0.5_3:1.3.22` from `1.3.22` to `1.4.2` under `com.softwaremill.sttp.shared:ws_native0.5_3:1.4.2`
 - Updated `com.softwaremill.sttp.shared:ws_native0.5_3:1.3.22` from `1.3.22` to `1.4.2` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1`

## Full dependency tree

 - org.scala-lang:toolkit_native0.5_3:0.7.0
   - com.lihaoyi:os-lib_native0.5_3:0.11.3
     - com.lihaoyi:geny_native0.5_3:1.1.1
   - com.lihaoyi:upickle_native0.5_3:4.1.0
     - com.lihaoyi:ujson_native0.5_3:4.1.0
       - com.lihaoyi:upickle-core_native0.5_3:4.1.0
         - com.lihaoyi:geny_native0.5_3:1.1.1 (already listed)
     - com.lihaoyi:upack_native0.5_3:4.1.0
       - com.lihaoyi:upickle-core_native0.5_3:4.1.0 (already listed)
     - com.lihaoyi:upickle-implicits_native0.5_3:4.1.0
       - com.lihaoyi:upickle-core_native0.5_3:4.1.0 (already listed)
   - com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1
     - com.softwaremill.sttp.model:core_native0.5_3:1.7.11
     - com.softwaremill.sttp.shared:core_native0.5_3:1.4.2
     - com.softwaremill.sttp.shared:ws_native0.5_3:1.4.2
       - com.softwaremill.sttp.model:core_native0.5_3:1.7.11 (already listed)
       - com.softwaremill.sttp.shared:core_native0.5_3:1.4.2 (already listed)
   - com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-RC1
     - com.lihaoyi:upickle_native0.5_3:4.1.0 (already listed)
     - com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1 (already listed)
     - com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.0-RC1
       - com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-RC1 (already listed)
