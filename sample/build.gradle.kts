plugins {
    kotlin("jvm")
}

group = "com.donghoonyoo"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))


    implementation(kotlinx("coroutines-core"))
    implementation(kotlinx("serialization-json"))
    implementation(kotlinx("datetime"))

    implementation(ktor("client-core"))


    awsSdkVersion = "2.17.276"
    implementation(awsSdk("core"))
    implementation(awsSdk("ec2"))

    awsCdkVersion = "1.173.0"
    implementation(awsCdk("cloudwatch"))


    implementation(springBoot("starter", "2.7.3"))
}