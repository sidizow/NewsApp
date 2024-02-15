pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            version("coroutines","1.7.1")
            version("androidx.activity","1.8.2")
            version("androidx.fragment","1.6.2")
            version("androidx.recyclerview","1.3.2")
            version("androidx.navigation","2.7.6")
            version("hilt","2.50")
            version("okhttp","4.12.0")
            version("retrofit2","2.9.0")

            library("androidx.core", "androidx.core:core-ktx:1.12.0")
            library("androidx.appcompat", "com.google.android.material:material:1.11.0")
            library("android.material", "com.google.android.material:material:1.11.0")
            library("androidx.constraintlayout", "androidx.constraintlayout:constraintlayout:2.1.4")
            library("junit", "junit:junit:4.13.2")
            library("androidx.test.ext", "androidx.test.ext:junit:1.1.5")
            library("androidx.test.espresso", "androidx.test.espresso:espresso-core:3.5.1")
            version("glide","4.16.0")

            library("coroutines", "org.jetbrains.kotlinx","kotlinx-coroutines-android").versionRef("coroutines")
            library("androidx.activity", "androidx.activity","activity-ktx").versionRef("androidx.activity")
            library("androidx.fragment", "androidx.fragment","fragment-ktx").versionRef("androidx.fragment")
            library("androidx.recyclerview", "androidx.recyclerview","recyclerview").versionRef("androidx.recyclerview")
            library("androidx.navigation.fragment", "androidx.navigation","navigation-fragment-ktx").versionRef("androidx.navigation")
            library("androidx.navigation.ui", "androidx.navigation","navigation-ui-ktx").versionRef("androidx.navigation")
            library("hilt.android", "com.google.dagger","hilt-android").versionRef("hilt")
            library("hilt.compiler", "com.google.dagger","hilt-android-compiler").versionRef("hilt")
            library("okhttp3", "com.squareup.okhttp3","okhttp").versionRef("okhttp")
            library("okhttp3.interceptor", "com.squareup.okhttp3","logging-interceptor").versionRef("okhttp")
            library("retrofit2", "com.squareup.retrofit2","retrofit").versionRef("retrofit2")
            library("moshi", "com.squareup.retrofit2","converter-moshi").versionRef("retrofit2")
            library("glide", "com.github.bumptech.glide","glide").versionRef("glide")

            bundle("activity.fragment", listOf("androidx.fragment","androidx.activity"))
            bundle("navigation", listOf("androidx.navigation.fragment","androidx.navigation.ui"))
            bundle("okhttp3", listOf("okhttp3","okhttp3.interceptor"))
            bundle("retrofit2", listOf("retrofit2","moshi"))
        }
    }
}

rootProject.name = "NewsApp"
include(":app")
 