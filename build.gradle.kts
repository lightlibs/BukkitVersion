plugins {
    java
    `maven-publish`
}

group = "com.tcoded.lightlibs"
version = "0.0.15"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJavaLocal") {
            from(components["java"])
        }
    }
}

val enablePublishing: Boolean = project.findProperty("enableUploadPublish")?.toString()?.toBoolean() == true

if (enablePublishing) {
    publishing {
        repositories {
            maven {
                name = "reposilite"
                url = uri("https://repo.tcoded.com/releases")

                credentials {
                    username = project.findProperty("REPOSILITE_USER")?.toString()
                            ?: System.getenv("REPOSILITE_USER")
                            ?: error("REPOSILITE_USER property or environment variable is not set")
                    password = project.findProperty("REPOSILITE_PASS")?.toString()
                            ?: System.getenv("REPOSILITE_PASS")
                            ?: error("REPOSILITE_PASS property or environment variable is not set")
                }

                authentication {
                    register<BasicAuthentication>("basic")
                }
            }
        }
    }

    tasks.named("publishMavenJavaLocalPublicationToReposiliteRepository") {
        dependsOn(tasks.jar)
    }

}