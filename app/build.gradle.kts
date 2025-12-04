
plugins {
    id("com.android.application") version "8.13.2"
    id("org.jetbrains.kotlin.android") version "2.3.0"
}
kotlin {
    compilerOptions {
        optIn.add("kotlin.RequiresOptIn")
    }
}

android {
    compileSdk = 36
    defaultConfig {
        applicationId = "ua.pp.sanderzet.sanderdict"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        javaCompileOptions {
            annotationProcessorOptions {
            }
        }
    }
    buildFeatures {
        viewBinding = true
        // or for data binding:
        // dataBinding = true
    }
    buildTypes {
        release {

            productFlavors {
            }
            buildToolsVersion = "31.0.0"
            namespace = "ua.pp.sanderzet.sanderdict"
        }

        dependencies {
            implementation("androidx.appcompat:appcompat:1.7.1")
            implementation("androidx.constraintlayout:constraintlayout:2.2.1")
            androidTestImplementation("androidx.test.ext:junit:1.3.0")
            androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
            implementation("com.google.android.material:material:1.13.0")
            implementation("io.reactivex.rxjava2:rxjava:2.2.21")
            implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
            implementation("androidx.lifecycle:lifecycle-livedata-core:2.10.0")
            implementation("androidx.lifecycle:lifecycle-runtime:2.10.0")
            annotationProcessor("androidx.lifecycle:lifecycle-common:2.10.0")
            implementation("androidx.room:room-runtime:2.8.4")
            annotationProcessor("androidx.room:room-compiler:2.8.4")
            androidTestImplementation("androidx.room:room-testing:2.8.4")
            implementation("androidx.cardview:cardview:1.0.0")
            implementation("androidx.recyclerview:recyclerview:1.4.0")
            implementation("com.github.humazed:RoomAsset:v1.0")
            implementation("androidx.appcompat:appcompat:1.7.1")
            implementation("com.squareup.retrofit2:retrofit:3.0.0")
            implementation("com.squareup.retrofit2:converter-gson:3.0.0")
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        buildToolsVersion = "35.0.0"
        buildToolsVersion = "36.1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildToolsVersion = "36.1.0"


}