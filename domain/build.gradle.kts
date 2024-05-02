plugins {
    id("java-library")
    id("kotlin")
//    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.22")
}