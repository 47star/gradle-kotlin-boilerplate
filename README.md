# Boilerplate for Gradle Kotlin DSL

## Features
- Dependency boilerplate for common libraries and frameworks.
  - Kotlinx
  - Ktor
  - Spring Boot
  - AWS(awssdk, awscdk)

## Getting started
```kotlin
// ./buildSrc/build.gradle.kts
dependencies {
    implementation("com.donghoonyoo.boilerplate:gradle-kotlin-boilerplate:latest.release")
}
```

## Usage
```kotlin
dependencies {
    // ...
    implementation(kotlinx("coroutines-core"))
    implementation(kotlinx("serialization-json"))
    
    implementation(ktor("client-core"))
    
    implementation(springBoot("starter"))
    
    implementation(awsSdk("core"))
    implementation(awsSdk("ec2"))
    
    implementation(awsCdk("cloudwatch"))
}
```