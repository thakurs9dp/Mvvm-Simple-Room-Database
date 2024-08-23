plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.s9dp.mvvm_room_database_simple"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.s9dp.mvvm_room_database_simple"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // LiveData
    implementation (libs.androidx.lifecycle.livedata.ktx)

    // Lifecycle
    implementation (libs.androidx.lifecycle.runtime.ktx)

    // If you need SavedStateViewModelFactory
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    // Optional - Annotation processor
    /*ksp(libs.androidx.lifecycle.compiler) // For Kotlin projects*/

    // Room runtime
    implementation(libs.androidx.room.runtime)

    // Room Compiler (Use KAPT for Kotlin)
    ksp(libs.androidx.room.compiler)

    // Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}