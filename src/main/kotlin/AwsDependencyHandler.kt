var awsSdkVersion = "latest.release"

fun awsSdk(name: String, version: String = awsSdkVersion) =
    "software.amazon.awssdk:$name:$version"


var awsCdkVersion = "latest.release"

fun awsCdk(name: String, version: String = awsCdkVersion) =
    "software.amazon.awscdk:$name:$version"