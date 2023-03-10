plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("com.squareup:javapoet:1.13.0")

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
