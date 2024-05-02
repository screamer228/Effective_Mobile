plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
//    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

//    implementation(project(":app"))
//    implementation(project(":data"))
//
//    //module
//    project(path = ":data")

    //dagger
    val daggerVersion = "2.50"
    implementation ("com.google.dagger:dagger:$daggerVersion")
    kapt ("com.google.dagger:dagger-compiler:$daggerVersion")

    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.23")
}