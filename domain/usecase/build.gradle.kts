import extensions.EntityModule
import extensions.RepositoryModule
import extensions.addHiltDependencies
import extensions.implementation

addHiltDependencies()

dependencies {
    EntityModule
    RepositoryModule

    implementation(libs.kotlin.coroutines.core)
}

android {
    namespace = "io.github.captainwonjong.usecase"
}