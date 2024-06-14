plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.daggerHiltAndroidPlugin)
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.shopapptestproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.shopapptestproject"
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
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.lifecycle.livedata.ktx)
        implementation(libs.androidx.lifecycle.viewmodel.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.retrofit)
        implementation(libs.retrofit.converter.gson)
        implementation(libs.okhttp)
        implementation(libs.okhttp.logging.interceptor)
        implementation(libs.hilt.android)
        kapt(libs.hilt.compiler)
        implementation(libs.hilt.androidx)
        kapt(libs.hilt.androidx.compiler)
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
}