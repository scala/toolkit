# Changelog for toolkit-test

## Changes to direct dependencies
 - Updated `org.scala-lang:toolkit_3:0.3.0` from `0.3.0` to `0.4.0` under `org.scala-lang:toolkit-test_3:0.4.0`
 - Updated `org.scalameta:munit_3:1.0.0-M11` from `1.0.0-M11` to `1.0.0-RC1` under `org.scala-lang:toolkit-test_3:0.4.0` ILLEGAL CHANGE (required at least: MajorUpdate)

## Changes to transitive dependencies
 - Added `org.scalameta:munit-diff_3:1.0.0-RC1` under `org.scalameta:munit_3:1.0.0-RC1`
 - Updated `com.lihaoyi:geny_3:1.0.0` from `1.0.0` to `1.1.0` under `com.lihaoyi:os-lib_3:0.10.0`
 - Updated `com.lihaoyi:geny_3:1.0.0` from `1.0.0` to `1.1.0` under `com.lihaoyi:upickle-core_3:3.3.0`
 - Updated `com.lihaoyi:os-lib_3:0.9.3` from `0.9.3` to `0.10.0` under `org.scala-lang:toolkit_3:0.4.0`
 - Updated `com.lihaoyi:ujson_3:3.2.0` from `3.2.0` to `3.3.0` under `com.lihaoyi:upickle_3:3.3.0`
 - Updated `com.lihaoyi:upack_3:3.2.0` from `3.2.0` to `3.3.0` under `com.lihaoyi:upickle_3:3.3.0`
 - Updated `com.lihaoyi:upickle-core_3:3.2.0` from `3.2.0` to `3.3.0` under `com.lihaoyi:ujson_3:3.3.0`
 - Updated `com.lihaoyi:upickle-core_3:3.2.0` from `3.2.0` to `3.3.0` under `com.lihaoyi:upack_3:3.3.0`
 - Updated `com.lihaoyi:upickle-core_3:3.2.0` from `3.2.0` to `3.3.0` under `com.lihaoyi:upickle-implicits_3:3.3.0`
 - Updated `com.lihaoyi:upickle-implicits_3:3.2.0` from `3.2.0` to `3.3.0` under `com.lihaoyi:upickle_3:3.3.0`
 - Updated `com.lihaoyi:upickle_3:3.1.4` from `3.1.4` to `3.3.0` under `com.softwaremill.sttp.client4:upickle_3:4.0.0-M14`
 - Updated `com.lihaoyi:upickle_3:3.2.0` from `3.2.0` to `3.3.0` under `org.scala-lang:toolkit_3:0.4.0`
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-M12` from `4.0.0-M12` to `4.0.0-M14` under `com.softwaremill.sttp.client4:json-common_3:4.0.0-M14` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-M12` from `4.0.0-M12` to `4.0.0-M14` under `com.softwaremill.sttp.client4:upickle_3:4.0.0-M14` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:core_3:4.0.0-M12` from `4.0.0-M12` to `4.0.0-M14` under `org.scala-lang:toolkit_3:0.4.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:json-common_3:4.0.0-M12` from `4.0.0-M12` to `4.0.0-M14` under `com.softwaremill.sttp.client4:upickle_3:4.0.0-M14` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.client4:upickle_3:4.0.0-M12` from `4.0.0-M12` to `4.0.0-M14` under `org.scala-lang:toolkit_3:0.4.0` ILLEGAL CHANGE (required at least: MajorUpdate)
 - Updated `com.softwaremill.sttp.model:core_3:1.6.0` from `1.6.0` to `1.7.10` under `com.softwaremill.sttp.shared:ws_3:1.3.18`
 - Updated `com.softwaremill.sttp.model:core_3:1.7.9` from `1.7.9` to `1.7.10` under `com.softwaremill.sttp.client4:core_3:4.0.0-M14`
 - Updated `com.softwaremill.sttp.shared:core_3:1.3.17` from `1.3.17` to `1.3.18` under `com.softwaremill.sttp.client4:core_3:4.0.0-M14`
 - Updated `com.softwaremill.sttp.shared:core_3:1.3.17` from `1.3.17` to `1.3.18` under `com.softwaremill.sttp.shared:ws_3:1.3.18`
 - Updated `com.softwaremill.sttp.shared:ws_3:1.3.17` from `1.3.17` to `1.3.18` under `com.softwaremill.sttp.client4:core_3:4.0.0-M14`
 - Updated `org.scalameta:junit-interface:1.0.0-M11` from `1.0.0-M11` to `1.0.0-RC1` under `org.scalameta:munit_3:1.0.0-RC1` ILLEGAL CHANGE (required at least: MajorUpdate)

## Full dependency tree

 - org.scala-lang:toolkit-test_3:0.4.0
   - org.scala-lang:toolkit_3:0.4.0
     - com.lihaoyi:os-lib_3:0.10.0
       - com.lihaoyi:geny_3:1.1.0
     - com.lihaoyi:upickle_3:3.3.0
       - com.lihaoyi:ujson_3:3.3.0
         - com.lihaoyi:upickle-core_3:3.3.0
           - com.lihaoyi:geny_3:1.1.0 (already listed)
       - com.lihaoyi:upack_3:3.3.0
         - com.lihaoyi:upickle-core_3:3.3.0 (already listed)
       - com.lihaoyi:upickle-implicits_3:3.3.0
         - com.lihaoyi:upickle-core_3:3.3.0 (already listed)
     - com.softwaremill.sttp.client4:core_3:4.0.0-M14
       - com.softwaremill.sttp.model:core_3:1.7.10
       - com.softwaremill.sttp.shared:core_3:1.3.18
       - com.softwaremill.sttp.shared:ws_3:1.3.18
         - com.softwaremill.sttp.model:core_3:1.7.10 (already listed)
         - com.softwaremill.sttp.shared:core_3:1.3.18 (already listed)
     - com.softwaremill.sttp.client4:upickle_3:4.0.0-M14
       - com.lihaoyi:upickle_3:3.3.0 (already listed)
       - com.softwaremill.sttp.client4:core_3:4.0.0-M14 (already listed)
       - com.softwaremill.sttp.client4:json-common_3:4.0.0-M14
         - com.softwaremill.sttp.client4:core_3:4.0.0-M14 (already listed)
   - org.scalameta:munit_3:1.0.0-RC1
     - junit:junit:4.13.2
       - org.hamcrest:hamcrest-core:1.3.0
     - org.scalameta:junit-interface:1.0.0-RC1
       - junit:junit:4.13.2 (already listed)
       - org.scala-sbt:test-interface:1.0.0
     - org.scalameta:munit-diff_3:1.0.0-RC1
