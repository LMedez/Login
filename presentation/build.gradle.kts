plugins {
    id(ModulePlugins.ANDROID_LIBRARY)
    kotlin("android")
}

android {

}

dependencies {
    implementation(project(":domain"))
    implementation(Deps.Koin.ANDROID)
    implementation(Deps.Kotlinx.Coroutines.CORE)
    implementation(Deps.AndroidX.Lifecycle.VIEWMODEL_KTX)
    implementation(Deps.AndroidX.Lifecycle.LIVEDATA_KTX)
}