# Versioning and compatibility of Scala Toolkit

## Versioning

Scala Toolkit will comprise a set of libraries, each versioned with semantic versioning. The toolkit will also follow semantic versioning. The library's public API will be the Scala Toolkit's public API. Updates in Toolkit will be in the form of bumps in the versions of the libraries. Therefore,

* when a backward-compatible patch is introduced in a library, the toolkit should bump the patch version
* when a backward-compatible functionality is introduced in a library, the toolkit should bump the minor version
* when backward-incompatible changes are made in a library, the toolkit should bump the major version.

Given that all underlying libraries follow the semantic versioning rules, these rules are equivalent to always bumping the highest-level version part that is bumped in updated libraries. 


## Relation to the Scala version

The toolkit will be compiled and guaranteed to work with the current Scala LTS and versions above it. Toolkit supporting the Scala LTS will be released as Toolkit 1.0. Before the LTS, we will release Toolkit 0.1, which will work with a lower version. We may also release Toolkit for Scala 2.x, but it will be a separate release process. Toolkit’s latest major for the LTS will be supported as long as this LTS is supported. We will make the best effort to release Toolkit majors with Scala LTS version bumps. 


## Releasing the Scala Toolkit

The toolkit's release will be similar to releasing any other library. A new artifact, with the proper version, according to semver, will be uploaded to the maven repository. Even after a new major of the Toolkit is released, the older supported one will receive patches and minor releases.


### Patch Release

Patches will be released when:

* Patches were introduced in the toolkit libraries


### Minor Release

Minors should be released when:

* there was a minor version released in at least one of the libraries, and
* the feature in the released minor is important, requested, or a couple of minor releases were released for the libraries and awaiting the toolkit’s minor release.


### Major Release

Majors should be planned when: 

* New Scala LTS is released, and 
* There are pending major releases of the Toolkit's libraries, or
* A library is removed from the Scala Toolkit

Regardless of the reason for the major release, it will be planned and announced beforehand. 

## Release scenarios

### Relation between Scala version and library version

The standard library and the compiler should be treated as a regular dependency. When the version of Scala in a library is bumped, one will be expected to update the Scala version in his project. The same scenario would happen with any other transitive dependency. LTS is meant to guarantee additional stability and sustained support of LTS versions, and Toolkit will be published for the LTS to give similar guarantees.


### Scenario - Release of LTS

![image](https://user-images.githubusercontent.com/4761866/214641399-bb6bcabc-6104-4c9d-a8b3-f435fe47d761.png)

Version 1.0.0 of Toolkit will be released after the LTS 1 release of Scala. It will contain the recent versions of libraries, but they will not be required to be compiled with Scala LTS 1. That would certainly be a good decision for the maintainers, and we will be encouraging it, but from a compatibility standpoint, it is not required.


### Scenario - Release of Toolkit minor
![image](https://user-images.githubusercontent.com/4761866/214641631-fb98a548-850a-46ee-ba49-c4ee8d4904a0.png)

Toolkit minors will be released when a Toolkit’s library has a newly released minor. It will contain the latest versions of the libraries. Except for when there was a new major released for some of the libraries, then, in the current Toolkit major, there will be the latest patch release of the library’s major that is included in the Toolkit.


### Scenario - Release of major under new LTS

![image](https://user-images.githubusercontent.com/4761866/214641468-f1acf38b-8e2c-455b-b75a-a7cfadcf8783.png)


The current plan for the Toolkit 2.0.0 is to be released with the Scala LTS 2. There is no guarantee for that, and deviation from this plan may occur if there are major releases published for Toolkit libraries significantly before the LTS 2 release. 
However, most probably, the anticipated scenario will occur. In this scenario, the plan is to wait for the libraries to release with the new Scala library and then release Toolkit 2.0.0. Some libraries in 2.0.0 may still be compiled with the previous LTS. 


### Scenario - Maintaining the old major

![image](https://user-images.githubusercontent.com/4761866/214641546-786aa639-7a45-412e-b3f8-da554e592753.png)

Toolkit major released for any given LTS is guaranteed to be supported as long as this LTS stays supported. This will require releasing new minors and patches for the older major. The library that is released with the new LTS will have its patches backported to the minor that was released with the previous LTS. A library compiled with the previous LTS on the newest versions will be released both in the new and the old major, as seen in the example above. 


## How Scala Toolkit may help address the  compatibility and support issues in ecosystem

### Support guarantees

If, for any reason, the project maintainers cannot migrate to the new LTS, some of the libraries being dependent upon may stop backporting patches to the older releases. That will not be the case with the Toolkit, as it extends Scala’s new LTS compatibility guarantees to the ecosystem. The libraries will stay supported as long as the LTS is supported.

### Simplified dependency management

One must spend a lot of time thinking about relations between dependencies in libraries. Given a scenario where we have libraries A and B that depend on C, and C releases a new major, the end-user may end up in a complicated situation. If he uses all three libraries, he must wait until both A and B update to the new C, and until then, he cannot use the new C’s major or any version of A or B libraries that started using the new C. With many intertwined dependencies, this issue grows to be exponentially more complex. With Toolkit, the end-user won’t be concerned about all that, saving time and effort. All that effort will be made by the maintainers cooperating and the team maintaining the Toolkit. They will make sure that within one Toolkit release, everything is working together. Additionally, the Toolkit maintainers will cooperate to release libraries with updated dependencies as fast as possible.

### Avoiding the ecosystem split

When a new major is released for a popular library, it may create hard-to-address issues for maintainers of libraries and their users. Libraries that depend on the newer major will be effectively incompatible with the ones that didn’t manage to migrate yet. This issue is not entirely avoidable, but Toolkit will make this issue more manageable. 

* The major releases of libraries will be batched together in Toolkit’s major release, leading to an easily navigable ecosystem - one will easily distinguish between libraries released for Toolkit 2, and those yet to catch up. 
* Even if one does depend on libraries, that will be behind for some time, he will be in a better situation than before. Without Toolkit, the support of the old major of a library could be dropped, and backport fixes wouldn’t be provided. Now, when one finds himself in this situation, his stack will still be supported, and he won’t need to worry about lagging in crucial patches. He will use the older LTS for the time being.
* Thirdly, updating the Toolkit’s major version in one’s project can be strictly coordinated with upgrading the Scala version while avoiding pressure from libraries. First, one can bump the Scala version in his project and use the older Toolkit major. Then, he can upgrade the Toolkit and use the features in libraries that utilize the new Scala release.
