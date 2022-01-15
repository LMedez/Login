object Deps {
    object AndroidX {
        object Room {
            private const val VERSION = "2.4.0"
            const val COMPILER = "androidx.room:room-compiler:$VERSION"
            const val RUNTIME = "androidx.room:room-runtime:$VERSION"
            const val COMMON = "androidx.room:room-common:$VERSION"
            const val ROOM_KTX = "androidx.room:room-ktx:$VERSION"
        }

        object Navigation {
            private const val VERSION = "2.3.5"
            const val FRAGMENT = "androidx.navigation:navigation-fragment:$VERSION"
            const val UI = "androidx.navigation:navigation-ui:$VERSION"
            const val UI_KTX = "androidx.navigation:navigation-ui-ktx:$VERSION"
            const val RUNTIME = "androidx.navigation:navigation-runtime:$VERSION"
            const val RUNTIME_KTX = "androidx.navigation:navigation-runtime-ktx:$VERSION"
        }

        object Lifecycle {
            private const val VERSION = "2.4.0-alpha01"
            const val COMMON = "androidx.lifecycle:lifecycle-common:$VERSION"
            const val RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:$VERSION"
            const val COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:$VERSION"
            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel:$VERSION"
            const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
            const val LIVEDATA_CORE = "androidx.lifecycle:lifecycle-livedata-core:$VERSION"
            const val LIVEDATA_CORE_KTX = "androidx.lifecycle:lifecycle-livedata-core-ktx:$VERSION"
            const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:$VERSION"
        }

        object RecyclerView {
            private const val VERSION = "1.2.0"
            const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:$VERSION"
        }

        object Fragment {
            private const val VERSION = "1.3.3"
            const val FRAGMENT = "androidx.fragment:fragment:$VERSION"
        }

        object AppCompat {
            private const val VERSION = "1.3.0-rc01"
            const val APPCOMPAT = "androidx.appcompat:appcompat:$VERSION"
        }

        object ConstraintLayout {
            private const val VERSION = "2.1.2"
            const val CL = "androidx.constraintlayout:constraintlayout:$VERSION"

        }
    }

    object Google {
        object Material {
            private const val VERSION = "1.4.0-beta01"
            const val MATERIAL = "com.google.android.material:material:$VERSION"
        }
    }

    object Kotlinx {
        object Coroutines {
            private const val VERSION = "1.5.0"
            const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
            const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
        }
    }

    object Koin {
        private const val VERSION = "3.0.1"
        const val CORE = "io.insert-koin:koin-core-jvm:$VERSION"
        const val ANDROID = "io.insert-koin:koin-android:$VERSION"
    }

    object Firebase {
        private const val VERSION = "29.0.3"
        const val BOM = "com.google.firebase:firebase-bom:$VERSION"
        const val MESSAGING = "com.google.firebase:firebase-messaging-ktx"
        const val ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
        const val FIRESTORE = "com.google.firebase:firebase-firestore-ktx"
        const val AUTH = "com.google.firebase:firebase-auth-ktx"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1"
    }
}