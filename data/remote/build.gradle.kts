import extensions.ModelModule
import extensions.addHiltDependencies
import extensions.addRemoteDependencies

addHiltDependencies()
addRemoteDependencies()

dependencies {
    ModelModule
}

android {
    namespace = "io.github.captainwonjong.remote"
}