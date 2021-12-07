plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(project(":"))


    implementation("com.egovn:vpbase:1.0-SNAPSHOT")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")

    // For custom interceptors on defaultOkHttpClientProvider
    implementation("com.squareup.okhttp3:okhttp:4.7.2")

    // For custom CIO engine on defaultJvmHttpClientProvider
    implementation("io.ktor:ktor-client-cio:1.3.1")

    // For pretty printing data classes
    implementation("com.tylerthrailkill.helpers:pretty-print:2.0.2")
}

task(name = "javaSample", type = JavaExec::class) {
    group = "samples"
    description = "Sample usage of the polygon client from Java"
    main = "io.polygon.kotlin.sdk.sample.JavaUsageSample"
    classpath = sourceSets["main"].runtimeClasspath
}

task(name = "kotlinSample", type = JavaExec::class) {
    group = "samples"
    description = "Sample usage of the polygon client from Kotlin"
    main = "io.polygon.kotlin.sdk.sample.KotlinUsageSampleKt"
    classpath = sourceSets["main"].runtimeClasspath
}
