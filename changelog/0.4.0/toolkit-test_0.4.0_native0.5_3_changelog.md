# Changelog for toolkit-test

## Changes to transitive dependencies
 - Added `com.lihaoyi:geny_native0.5_3:1.1.0` under `com.lihaoyi:os-lib_native0.5_3:0.10.0`
 - Added `com.lihaoyi:geny_native0.5_3:1.1.0` under `com.lihaoyi:upickle-core_native0.5_3:3.3.0`
 - Added `com.lihaoyi:os-lib_native0.5_3:0.10.0` under `org.scala-lang:toolkit_native0.5_3:0.4.0`
 - Added `com.lihaoyi:ujson_native0.5_3:3.3.0` under `com.lihaoyi:upickle_native0.5_3:3.3.0`
 - Added `com.lihaoyi:upack_native0.5_3:3.3.0` under `com.lihaoyi:upickle_native0.5_3:3.3.0`
 - Added `com.lihaoyi:upickle-core_native0.5_3:3.3.0` under `com.lihaoyi:ujson_native0.5_3:3.3.0`
 - Added `com.lihaoyi:upickle-core_native0.5_3:3.3.0` under `com.lihaoyi:upack_native0.5_3:3.3.0`
 - Added `com.lihaoyi:upickle-core_native0.5_3:3.3.0` under `com.lihaoyi:upickle-implicits_native0.5_3:3.3.0`
 - Added `com.lihaoyi:upickle-implicits_native0.5_3:3.3.0` under `com.lihaoyi:upickle_native0.5_3:3.3.0`
 - Added `com.lihaoyi:upickle_native0.5_3:3.3.0` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-M14`
 - Added `com.lihaoyi:upickle_native0.5_3:3.3.0` under `org.scala-lang:toolkit_native0.5_3:0.4.0`
 - Added `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14` under `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.0-M14`
 - Added `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-M14`
 - Added `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14` under `org.scala-lang:toolkit_native0.5_3:0.4.0`
 - Added `com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.0-M14` under `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-M14`
 - Added `com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-M14` under `org.scala-lang:toolkit_native0.5_3:0.4.0`
 - Added `com.softwaremill.sttp.model:core_native0.5_3:1.7.10` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14`
 - Added `com.softwaremill.sttp.model:core_native0.5_3:1.7.10` under `com.softwaremill.sttp.shared:ws_native0.5_3:1.3.18`
 - Added `com.softwaremill.sttp.shared:core_native0.5_3:1.3.18` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14`
 - Added `com.softwaremill.sttp.shared:core_native0.5_3:1.3.18` under `com.softwaremill.sttp.shared:ws_native0.5_3:1.3.18`
 - Added `com.softwaremill.sttp.shared:ws_native0.5_3:1.3.18` under `com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14`
 - Added `org.scala-lang:toolkit_native0.5_3:0.4.0` under `org.scala-lang:toolkit-test_native0.5_3:0.4.0`
 - Added `org.scalameta:munit-diff_native0.5_3:1.0.0-RC1` under `org.scalameta:munit_native0.5_3:1.0.0-RC1`
 - Added `org.scalameta:munit_native0.5_3:1.0.0-RC1` under `org.scala-lang:toolkit-test_native0.5_3:0.4.0`

## Full dependency tree

 - org.scala-lang:toolkit-test_native0.5_3:0.4.0
   - org.scala-lang:toolkit_native0.5_3:0.4.0
     - com.lihaoyi:os-lib_native0.5_3:0.10.0
       - com.lihaoyi:geny_native0.5_3:1.1.0
     - com.lihaoyi:upickle_native0.5_3:3.3.0
       - com.lihaoyi:ujson_native0.5_3:3.3.0
         - com.lihaoyi:upickle-core_native0.5_3:3.3.0
           - com.lihaoyi:geny_native0.5_3:1.1.0 (already listed)
       - com.lihaoyi:upack_native0.5_3:3.3.0
         - com.lihaoyi:upickle-core_native0.5_3:3.3.0 (already listed)
       - com.lihaoyi:upickle-implicits_native0.5_3:3.3.0
         - com.lihaoyi:upickle-core_native0.5_3:3.3.0 (already listed)
     - com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14
       - com.softwaremill.sttp.model:core_native0.5_3:1.7.10
       - com.softwaremill.sttp.shared:core_native0.5_3:1.3.18
       - com.softwaremill.sttp.shared:ws_native0.5_3:1.3.18
         - com.softwaremill.sttp.model:core_native0.5_3:1.7.10 (already listed)
         - com.softwaremill.sttp.shared:core_native0.5_3:1.3.18 (already listed)
     - com.softwaremill.sttp.client4:upickle_native0.5_3:4.0.0-M14
       - com.lihaoyi:upickle_native0.5_3:3.3.0 (already listed)
       - com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14 (already listed)
       - com.softwaremill.sttp.client4:json-common_native0.5_3:4.0.0-M14
         - com.softwaremill.sttp.client4:core_native0.5_3:4.0.0-M14 (already listed)
   - org.scalameta:munit_native0.5_3:1.0.0-RC1
     - org.scalameta:munit-diff_native0.5_3:1.0.0-RC1
