plugins {
    id(ModulePlugins.ANDROID_LIBRARY)
    kotlin("android")
}

android {
}

dependencies {
    implementation(project(":domain"))
    implementation(Deps.Koin.ANDROID)
}