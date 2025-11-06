plugins {
  java
  id ("nl.littlerobots.version-catalog-update" ) version "1.0.1"
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
