// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.4.0"  apply false
    id("com.android.library") version "7.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

ext{
    extra["gson_version"] = "2.9.1"
    extra["lifecycle_version"] = "2.6.0"
    extra["hilt_version"] = "2.44"
    extra["retrofit_version"] = "2.9.0"
    extra["logging_interceptor_version"] = "4.10.0"
    extra["nav_version"] = "2.6.0"

    extra["daggerHilt"] = "com.google.dagger:hilt-android:${extra["hilt_version"]}"
    extra["hiltKapt"] = "com.google.dagger:hilt-compiler:${extra["hilt_version"]}"
    extra["retrofit"] = "com.squareup.retrofit2:retrofit:${extra["retrofit_version"]}"
    extra["gsonConverter"] = "com.squareup.retrofit2:converter-gson:${extra["retrofit_version"]}"
    extra["loggingInterceptor"] = "com.squareup.okhttp3:logging-interceptor:${extra["logging_interceptor_version"]}"

}

