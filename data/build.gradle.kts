plugins {
    id(ModulePlugins.ANDROID_LIBRARY)
    kotlin("android")
    kotlin("kapt")
    id(ModulePlugins.GOOGLE_SERVICES)
}

android {
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(platform(Deps.Firebase.BOM))
    implementation(Deps.Firebase.FIRESTORE)
    implementation(Deps.Firebase.AUTH)
    implementation(Deps.Firebase.COROUTINES)
    implementation(Deps.Koin.ANDROID)
    implementation(Deps.AndroidX.Room.ROOM_KTX)
    kapt(Deps.AndroidX.Room.COMPILER)
}