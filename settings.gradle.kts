pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/13508935/artifacts/repository")
        }
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev") {
            content {
                includeGroupByRegex("org\\.jetbrains\\.compose.*")
            }
        }
        // Only include the androidx plugin portal in the gradlePluginPortal repository
        gradlePluginPortal() {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/13508935/artifacts/repository")
        }

    }
}

rootProject.name = "NewInAndroid"
include(":app")
 