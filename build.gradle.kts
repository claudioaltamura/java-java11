import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
    idea
    eclipse
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.guava:guava:28.2-jre")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")

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

