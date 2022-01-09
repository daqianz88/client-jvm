val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

buildscript {
    repositories {
        mavenLocal()
        google()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.6.0")
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

plugins {
    application
    kotlin("jvm") version "1.6.0"
    `java-library`
    kotlin("plugin.serialization") version "1.6.0"
    kotlin("kapt") version "1.6.0"
    `maven-publish`
}

group = "com.egovn"
version = "1.0-SNAPSHOT"

dependencies {
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-jdk8
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.0")

    implementation("com.egovn:vpbase:1.0-SNAPSHOT")

    val ktorVersion = "1.6.0"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-websockets:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")

    // Annotation processor that generates Java builders for data classes
    val ktBuilderVersion = "1.2.1"
    implementation("com.thinkinglogic.builder:kotlin-builder-annotation:$ktBuilderVersion")
    kapt("com.thinkinglogic.builder:kotlin-builder-processor:$ktBuilderVersion")

    testImplementation("junit:junit:4.12")
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    val sourcesJar by creating(Jar::class) {
        dependsOn(JavaPlugin.CLASSES_TASK_NAME)
        classifier = "sources"
        from(sourceSets["main"].allSource)
    }

    artifacts {
        add("archives", sourcesJar)
        add("archives", jar)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.egovn"
            artifactId = "polygon_client"
            version = "1.0-SNAPSHOT"

            from(components["java"])
        }
    }
}