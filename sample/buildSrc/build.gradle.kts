plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    implementation("com.donghoonyoo.boilerplate:gradle-kotlin-boilerplate:latest.integration")
}