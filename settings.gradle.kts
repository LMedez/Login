dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Basic start modular app android"

//Include all the existent modules in the project
rootDir.walk()
        .maxDepth(1)
        .filter {
            it.name != "buildSrc" && it.isDirectory &&
                    file("${it.absolutePath}/build.gradle.kts").exists()
        }
        .forEach {
            include(":${it.name}")
        }
