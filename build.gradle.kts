import java.io.ByteArrayOutputStream

plugins {
  java
  `maven-publish`
  id("nl.littlerobots.version-catalog-update") version "1.0.1"
}

sourceSets {
  main {
    java {
      setSrcDirs(listOf("library/src"))
    }
  }
  test {
    java {
      setSrcDirs(listOf("tests/tests"))
    }
  }
}

group = "hpe"

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.jsinterop)
  implementation(libs.guava)
  implementation(libs.fastutil)
  testImplementation(libs.junit)
  testImplementation(libs.truth)
}

version = findProperty("gitVersion") ?: "0.0.0-SNAPSHOT"

publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      from(components["java"])
      groupId = project.group.toString()
      artifactId = "s2"
      version = project.version.toString()
    }
  }

  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/EricEdens/s2-geometry-library-java")
      credentials {
        username = findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
        password = findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
      }
    }
  }
}