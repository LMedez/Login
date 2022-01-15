import com.android.build.gradle.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryPlugin

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.ANDROID)
        classpath(BuildPlugins.GMS)
        classpath(BuildPlugins.SAFE_ARGS)
        classpath(kotlin(module = BuildPlugins.Kotlin.ID, version = BuildPlugins.Kotlin.VERSION))

    }
}

val projectJvmTarget = JavaVersion.VERSION_1_8

subprojects {
    project.plugins.configureAppAndModules(subProject = project)
}

fun PluginContainer.configureAppAndModules(subProject: Project) = apply {
    whenPluginAdded {
        when (this) {
            is AppPlugin -> {
                subProject.extensions
                    .getByType<AppExtension>()
                    .applyAppCommons()
            }
            is LibraryPlugin -> {
                subProject.extensions
                    .getByType<LibraryExtension>()
                    .applyLibraryCommons()
            }
        }
    }
}

fun Project.disableVariants() {
    val extension = project.extensions
        .getByName("androidComponents") as LibraryAndroidComponentsExtension
    extension.beforeVariants(extension.selector().withBuildType("debug")) {
        it.enabled = false
    }
}

fun AppExtension.applyAppCommons() = apply {
    applyBaseCommons()
    defaultConfig {
        applicationId = "com.luc.basicstartmodularappandroid"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
    }
}

fun LibraryExtension.applyLibraryCommons() = apply {
    applyBaseCommons()
}

fun BaseExtension.applyBaseCommons() = apply {
    compileSdkVersion(Android.Sdk.COMPILE)
    defaultConfig.apply {
        minSdk = Android.Sdk.MIN
        targetSdk = Android.Sdk.TARGET
    }

    compileOptions.apply {
        sourceCompatibility = projectJvmTarget
        targetCompatibility = projectJvmTarget
    }

    flavorDimensions("type")

    productFlavors {

        create("dev") {
            dimension = "type"
            resourceConfigurations.addAll(listOf("en", "xxhdpi"))
        }

        create("prod") {
            dimension = "type"
        }
    }
}

fun DependencyHandler.s() = apply {
}