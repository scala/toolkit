# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:os-lib_3:0.10.3` from `0.10.3` to `0.11.3` under `org.scala-lang:toolkit_3:0.6.0`
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `org.scala-lang:toolkit_3:0.6.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_3:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `org.scala-lang:toolkit_3:0.6.0` ILLEGAL CHANGE (required at least: MajorUpdate)

## Changes to transitive dependencies
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `com.softwaremill.sttp.client4:json-common_3:4.0.0-M19` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `com.softwaremill.sttp.client4:upickle_3:4.0.0-M19` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_3:4.0.0-M16` from `4.0.0-M16` to `4.0.0-M19` under `com.softwaremill.sttp.client4:upickle_3:4.0.0-M19` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.model:core_3:1.7.10` from `1.7.10` to `1.7.11` under `com.softwaremill.sttp.client4:core_3:4.0.0-M19`
 - Updated `com.softwaremill.sttp.model:core_3:1.7.10` from `1.7.10` to `1.7.11` under `com.softwaremill.sttp.shared:ws_3:1.3.22`
 - Updated `com.softwaremill.sttp.shared:core_3:1.3.19` from `1.3.19` to `1.3.22` under `com.softwaremill.sttp.client4:core_3:4.0.0-M19`
 - Updated `com.softwaremill.sttp.shared:core_3:1.3.19` from `1.3.19` to `1.3.22` under `com.softwaremill.sttp.shared:ws_3:1.3.22`
 - Updated `com.softwaremill.sttp.shared:ws_3:1.3.19` from `1.3.19` to `1.3.22` under `com.softwaremill.sttp.client4:core_3:4.0.0-M19`

## Full dependency tree

 - org.scala-lang:toolkit_3:0.6.0
   - com.lihaoyi:os-lib_3:0.11.3
     - com.lihaoyi:geny_3:1.1.1
   - com.lihaoyi:upickle_3:3.3.1
     - com.lihaoyi:ujson_3:3.3.1
       - com.lihaoyi:upickle-core_3:3.3.1
         - com.lihaoyi:geny_3:1.1.0
     - com.lihaoyi:upack_3:3.3.1
       - com.lihaoyi:upickle-core_3:3.3.1 (already listed)
     - com.lihaoyi:upickle-implicits_3:3.3.1
       - com.lihaoyi:upickle-core_3:3.3.1 (already listed)
   - com.softwaremill.sttp.client4:core_3:4.0.0-M19
     - com.softwaremill.sttp.model:core_3:1.7.11
     - com.softwaremill.sttp.shared:core_3:1.3.22
     - com.softwaremill.sttp.shared:ws_3:1.3.22
       - com.softwaremill.sttp.model:core_3:1.7.11 (already listed)
       - com.softwaremill.sttp.shared:core_3:1.3.22 (already listed)
   - com.softwaremill.sttp.client4:upickle_3:4.0.0-M19
     - com.lihaoyi:upickle_3:3.3.1 (already listed)
     - com.softwaremill.sttp.client4:core_3:4.0.0-M19 (already listed)
     - com.softwaremill.sttp.client4:json-common_3:4.0.0-M19
       - com.softwaremill.sttp.client4:core_3:4.0.0-M19 (already listed)
