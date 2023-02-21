import extensions.*

addHiltDependencies()

dependencies {
    ModelModule
    RemoteModule
    EntityModule
    RepositoryModule
}

android {
    namespace = "io.github.captainwonjong.repositoryImpl"
}