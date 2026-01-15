# Changelog for toolkit

## Changes to direct dependencies
 - Updated `com.lihaoyi:os-lib_3:0.11.3` from `0.11.3` to `0.11.6` under `org.scala-lang:toolkit_3:0.8.0`
 - Updated `com.lihaoyi:upickle_3:4.1.0` from `4.1.0` to `4.4.2` under `org.scala-lang:toolkit_3:0.8.0`
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.13` under `org.scala-lang:toolkit_3:0.8.0`
 - Updated `com.softwaremill.sttp.client4:upickle_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.13` under `org.scala-lang:toolkit_3:0.8.0`

## Changes to transitive dependencies
 - Added `com.lihaoyi:os-zip:0.11.6` under `com.lihaoyi:os-lib_3:0.11.6`
 - Updated `com.lihaoyi:ujson_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upickle_3:4.4.0`
 - Updated `com.lihaoyi:ujson_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upickle_3:4.4.2`
 - Updated `com.lihaoyi:upack_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upickle_3:4.4.0`
 - Updated `com.lihaoyi:upack_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upickle_3:4.4.2`
 - Updated `com.lihaoyi:upickle-core_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:ujson_3:4.4.2`
 - Updated `com.lihaoyi:upickle-core_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upack_3:4.4.2`
 - Updated `com.lihaoyi:upickle-core_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upickle-implicits_3:4.4.2`
 - Updated `com.lihaoyi:upickle-implicits_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upickle_3:4.4.0`
 - Updated `com.lihaoyi:upickle-implicits_3:4.1.0` from `4.1.0` to `4.4.2` under `com.lihaoyi:upickle_3:4.4.2`
 - Updated `com.lihaoyi:upickle_3:4.1.0` from `4.1.0` to `4.4.0` under `com.softwaremill.sttp.client4:upickle_3:4.0.13`
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.13` under `com.softwaremill.sttp.client4:json-common_3:4.0.13`
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.13` under `com.softwaremill.sttp.client4:upickle_3:4.0.13`
 - Updated `com.softwaremill.sttp.client4:json-common_3:4.0.0-RC1` from `4.0.0-RC1` to `4.0.13` under `com.softwaremill.sttp.client4:upickle_3:4.0.13`
 - Updated `com.softwaremill.sttp.model:core_3:1.7.11` from `1.7.11` to `1.7.12` under `com.softwaremill.sttp.shared:ws_3:1.5.0`
 - Updated `com.softwaremill.sttp.model:core_3:1.7.11` from `1.7.11` to `1.7.17` under `com.softwaremill.sttp.client4:core_3:4.0.13`
 - Updated `com.softwaremill.sttp.shared:core_3:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.client4:core_3:4.0.13`
 - Updated `com.softwaremill.sttp.shared:core_3:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.shared:ws_3:1.5.0`
 - Updated `com.softwaremill.sttp.shared:ws_3:1.4.2` from `1.4.2` to `1.5.0` under `com.softwaremill.sttp.client4:core_3:4.0.13`

## Full dependency tree

 - org.scala-lang:toolkit_3:0.8.0
   - com.lihaoyi:os-lib_3:0.11.6
     - com.lihaoyi:geny_3:1.1.1
     - com.lihaoyi:os-zip:0.11.6
   - com.lihaoyi:upickle_3:4.4.2
     - com.lihaoyi:ujson_3:4.4.2
       - com.lihaoyi:upickle-core_3:4.4.2
         - com.lihaoyi:geny_3:1.1.1 (already listed)
     - com.lihaoyi:upack_3:4.4.2
       - com.lihaoyi:upickle-core_3:4.4.2 (already listed)
     - com.lihaoyi:upickle-implicits_3:4.4.2
       - com.lihaoyi:upickle-core_3:4.4.2 (already listed)
   - com.softwaremill.sttp.client4:core_3:4.0.13
     - com.softwaremill.sttp.model:core_3:1.7.17
     - com.softwaremill.sttp.shared:core_3:1.5.0
     - com.softwaremill.sttp.shared:ws_3:1.5.0
       - com.softwaremill.sttp.model:core_3:1.7.12
       - com.softwaremill.sttp.shared:core_3:1.5.0 (already listed)
   - com.softwaremill.sttp.client4:upickle_3:4.0.13
     - com.lihaoyi:upickle_3:4.4.0
       - com.lihaoyi:ujson_3:4.4.2 (already listed)
       - com.lihaoyi:upack_3:4.4.2 (already listed)
       - com.lihaoyi:upickle-implicits_3:4.4.2 (already listed)
     - com.softwaremill.sttp.client4:core_3:4.0.13 (already listed)
     - com.softwaremill.sttp.client4:json-common_3:4.0.13
       - com.softwaremill.sttp.client4:core_3:4.0.13 (already listed)
