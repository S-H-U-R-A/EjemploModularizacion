@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {

    namespace = "com.sergio.rodriguez.examplemodules"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sergio.rodriguez.examplemodules"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //ARCHITECTURE CLEAN
    implementation(project(":domain"))
    implementation(project(":data"))

    //KOTLIN
    implementation(libs.core.ktx)

    //LIFECYCLE
    implementation(libs.lifecycle.runtime.ktx)

    //ACTIVITY COMPOSE
    implementation(libs.activity.compose)

    //COMPOSE, COMPOSE BOM
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    //JUNIT
    testImplementation(libs.junit)

    //TEST INSTRUMENTATION
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //COMPOSE BOM FOR TEST UI
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)

    //BUILD TYPE DEBUG
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}