plugins {
    id(ModulePlugins.ANDROID_LIBRARY)
    id(ModulePlugins.GOOGLE_SERVICES)
    kotlin("android")
    kotlin("kapt")
}

android {
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(platform(Deps.Firebase.BOM))
    implementation(Deps.Firebase.FIRESTORE)
    implementation(Deps.Firebase.COROUTINES)
    implementation(Deps.Koin.ANDROID)
    implementation(Deps.AndroidX.Room.ROOM_KTX)
    kapt(Deps.AndroidX.Room.COMPILER)
}