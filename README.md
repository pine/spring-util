# spring-util

[![Build Status](https://app.travis-ci.com/pine/spring-util.svg?branch=main)](https://app.travis-ci.com/pine/spring-util)
[![codecov](https://codecov.io/gh/pine/spring-util/branch/main/graph/badge.svg?token=lDSh4VoVqE)](https://codecov.io/gh/pine/spring-util)

:herb: Micro utilities for Spring Framework

![](images/resized.jpg)<br>
<sup><sup>&copy; Pongnathee Kluaythong/123RF.COM</sup></sup>
<br>
<br>


## Requirements

- Java 8 or later
- Spring Framework

### Supported Spring Framework versions

|Spring Framework versions|Spring Boot versions|This library version|
|-------------------------|--------------------|--------------------|
|5.3                      |2.4, 2.5, 2.6       |0.1.0               |

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
