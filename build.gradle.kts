import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    idea
    eclipse
    id("com.diffplug.spotless") version "5.10.2"
    id("com.github.ben-manes.versions") version "0.36.0"
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")

    testImplementation("org.assertj:assertj-core:3.19.0")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

val test by tasks.getting(Test::class) {
    jvmArgs("--enable-preview")
    useJUnitPlatform()
    testLogging {
        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}
