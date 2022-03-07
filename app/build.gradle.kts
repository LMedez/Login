plugins {
    id(ModulePlugins.ANDROID_APPLICATION)
    kotlin("android")
    kotlin("kapt")
}

android {
    viewBinding {
        isEnabled = true
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":presentation"))
    implementation(project(":data"))
    implementation(project(":common"))
    implementation(project(":ui:home"))
    implementation(project(":ui:login"))

    implementation(kotlin("stdlib"))
    implementation(Deps.AndroidX.Navigation.FRAGMENT_KTX)
    implementation(Deps.AndroidX.Navigation.UI_KTX)
    implementation(Deps.AndroidX.AppCompat.APPCOMPAT)
    implementation(Deps.Google.Material.MATERIAL)
    implementation(Deps.AndroidX.ConstraintLayout.CL)
    implementation(Deps.Koin.ANDROID)

    implementation(Deps.Glide.GLIDE)
    kapt(Deps.Glide.PROCESSOR)

}