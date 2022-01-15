plugins {
    id(ModulePlugins.ANDROID_APPLICATION)
    kotlin("android")
    kotlin("kapt")
}

android {

}

dependencies {
    implementation(project(":domain"))
    implementation(project(":presentation"))
    implementation(project(":data"))
    implementation(project(":common"))

    implementation(kotlin("stdlib"))
    implementation(Deps.AndroidX.AppCompat.APPCOMPAT)
    implementation(Deps.Google.Material.MATERIAL)
    implementation(Deps.AndroidX.ConstraintLayout.CL)
    implementation(Deps.Koin.ANDROID)
}