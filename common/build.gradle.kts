plugins {
    id(ModulePlugins.ANDROID_LIBRARY)
    kotlin("android")
}

android {
}

dependencies {
    implementation(Deps.AndroidX.Room.COMMON)
    implementation(Deps.Koin.ANDROID)
}