plugins {
//    alias(libs.plugins.androidLibrary)
    id ("com.android.library")
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "PREFS_NAME", "\"sharedPreferences\"")
            buildConfigField("String", "PREFS_TITLE_KEY", "\"prefsStringKey\"")
            buildConfigField("String", "PREFS_DEFAULT_VALUE", "\"\"")
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "PREFS_NAME", "\"sharedPreferences\"")
            buildConfigField("String", "PREFS_TITLE_KEY", "\"prefsStringKey\"")
            buildConfigField("String", "PREFS_DEFAULT_VALUE", "\"\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(project(":domain"))
    //module
    project(path = ":domain")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")

    //dagger
    val daggerVersion = "2.50"
    implementation ("com.google.dagger:dagger:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

    //kotlin
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.23")

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}