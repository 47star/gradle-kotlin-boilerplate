import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("org.jetbrains.dokka") version "1.7.10"
    id("io.github.gradle-nexus.publish-plugin") version "latest.release"
    `maven-publish`
    signing
}

group = "com.donghoonyoo.boilerplate"
version = "1.0.0"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val sourceJar = tasks.create<Jar>("sourceJar") {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

val javadocJar = tasks.create<Jar>("javadocJar") {
    from(tasks["dokkaJavadoc"].outputs)
    archiveClassifier.set("javadoc")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = project.name
            artifact(tasks.jar.get())
            artifact(sourceJar) {
                classifier = "sources"
            }
            artifact(javadocJar) {
                classifier = "javadoc"
            }

            pom {
                name.set("gradle-kotlin-boilerplate")
                description.set("Boilerplate for Gradle Kotlin DSL")
                url.set("https://github.com/donghoon-yoo/gradle-kotlin-boilerplate")
                packaging = "jar"

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opernsource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        name.set("DongHoon Yoo")
                        email.set("nano@kakao.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/donghoon-yoo/gradle-kotlin-boilerplate.git")
                    developerConnection.set("scm:git:git://github.com/donghoon-yoo/gradle-kotlin-boilerplate.git")
                    url.set("https://github.com/donghoon-yoo/gradle-kotlin-boilerplate")
                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https:///s01.oss.sonatype.org/content/repositories/snapshots/"))

            username.set(properties["nexus.username"] as String)
            password.set(properties["nexus.password"] as String)
        }
    }
}

signing {
    sign(publishing.publications.findByName("maven"))
}