import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    val openWeatherKey = gradleLocalProperties(rootDir).getProperty("openWeatherKey")
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
        debug {
            buildConfigField("String", "openWeatherKey", openWeatherKey)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.ardidong.weatherornot.core"



}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Hilt
    implementation("${rootProject.extra["daggerHilt"]}")
    kapt("${rootProject.extra["hiltKapt"]}")


    implementation("${rootProject.extra["retrofit"]}")

    implementation("com.google.code.gson:gson:${rootProject.extra["gson_version"]}")
    implementation(project(":domain"))
    implementation(project(":data:library"))
}

kapt {
    correctErrorTypes = true
}
