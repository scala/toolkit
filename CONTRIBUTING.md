# Contributing Guide

## Running the tests

1. Update to latest scala-cli:
```
$ scala-cli update
```
or, if installed with Coursier:
```
$ cs update scala-cli
```
2. Run the tests:
```
$ scala-cli test tests/CrossPlatform.test.sscala
```

## Updating dependencies

1. You can update the Toolkit dependencies in `Toolkit.scala`, `Toolkit.js.scala` and `ToolkitTest.scala`. The versions in `Toolkit.scala` and `Toolkit.js.scala` should be the same.

2. After changing the dependencies, you must generate the changelog:

- Check that the config in `changelog/Config.scala` is up-to-date: `releaseVersion` should contain the latest released version and `developmentVersion` should contain the next version to release.
- Run `scala-cli run changelog -- --overwrite` to generate the changelog
- If the generation fails because of illegal version bumps, you can add the development version in `exceptions.txt` and run `scala-cli run changelog -- --overwrite` again. (This won't be permitted anymore after 1.0.0 which will be the first stable version)
- Commit and push the changes in the changelog

## Releasing the Toolkit

1. [Create a new release](https://github.com/scala/toolkit/releases/new) in the Github repo

2. Create a new `0.x.y` tag in the `Choose a tag` dropdown list

3. Copy, paste the release description below, and update the versions:

```md
## Changes to direct dependencies for toolkit
 - Updated `com.lihaoyi:os-lib` from `0.10.0` to `0.10.3`
 - Updated `com.lihaoyi:upickle` from `3.3.0` to `3.3.1`
 - Updated `com.softwaremill.sttp.client4:core` from `4.0.0-M14` to `4.0.0-M16`
 - Updated `com.softwaremill.sttp.client4:upickle` from `4.0.0-M14` to `4.0.0-M16`

## Changes to direct dependencies for toolkit-test
 - Updated `org.scalameta:munit` from `1.0.0-M11` to `1.0.0`
```

4. Validate by clicking the `Publish release` button.

5. Check that the `Publish toolkit` action starts, and runs successfully. The new version should appear on [Maven Central](https://repo1.maven.org/maven2/org/scala-lang/toolkit-test_3/) after some time.
