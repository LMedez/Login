object TestDeps {
    object JUnit {
        private const val VERSION = "4.12"
        const val JUNIT = "junit:junit:$VERSION"
    }

    object Kotlinx {
        private const val VERSION = Deps.Kotlinx.Coroutines.VERSION
        const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$VERSION"
    }

    object AndroidX {
        object Arch {
            private const val VERSION = "2.1.0"
            const val CORE_TESTING = "androidx.arch.core:core-testing:${VERSION}"
        }
    }

    object Truth {
        private const val VERSION = "1.1.3"
        const val TRUTH = "com.google.truth:truth:$VERSION"
    }
}