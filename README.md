# spring-util

[![build](https://github.com/pine/spring-util/actions/workflows/build.yml/badge.svg)](https://github.com/pine/spring-util/actions/workflows/build.yml)
[![codecov](https://codecov.io/gh/pine/spring-util/branch/main/graph/badge.svg?token=lDSh4VoVqE)](https://codecov.io/gh/pine/spring-util)
[![Maven Central](https://img.shields.io/maven-central/v/moe.pine/spring-util)](https://mvnrepository.com/artifact/moe.pine/spring-util)
[![javadoc](https://javadoc.io/badge2/moe.pine/spring-util/javadoc.svg)](https://javadoc.io/doc/moe.pine/spring-util)

:herb: Micro utilities for Spring Framework

![](images/resized.jpg)<br>
<sup><sup>&copy; Pongnathee Kluaythong/123RF.COM</sup></sup>
<br>
<br>


## Requirements

|Java versions|Spring Framework versions|Spring Boot versions|This library version|
|-------------|-------------------------|--------------------|--------------------|
|8 or later   |5.3                      |2.4, 2.5, 2.6, 2.7  |0.1.1               |

## Getting started
The library is published to Maven Central.

```gradle
repositories {
    mavenCentral()
}

depepdencies {
    implementation "moe.pine:spring-util:$latestVersion"
}
```

## Development
### Test

```
$ ./gradlew clean check
```

### Upload Maven Central

```
$ ./gradlew clean publish
```

## License
MIT &copy; [Pine Mizune](https://pine.moe/)
