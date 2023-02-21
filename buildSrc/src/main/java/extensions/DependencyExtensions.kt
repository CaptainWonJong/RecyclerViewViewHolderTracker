package extensions

import ModulePath
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

fun Project.addHiltDependencies() {
    project.dependencies {
        implementation(libs.hilt.android)
        kapt(libs.hilt.compiler)
    }
}

fun Project.addRemoteDependencies() {
    project.dependencies {
        implementation(libs.okhttp)
        implementation(libs.logging.interceptor)
        implementation(libs.converter.gson)
        implementation(libs.retrofit)
    }
}

private val Project.libs get() = the<LibrariesForLibs>()

val DependencyHandler.ModelModule
    get() = implementation(project(mapOf("path" to ModulePath.Model)))

val DependencyHandler.RemoteModule
    get() = implementation(project(mapOf("path" to ModulePath.Remote)))
