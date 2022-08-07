plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = NewsAppConfigs.compileSDKVersion

    defaultConfig {
        applicationId = NewsAppConfigs.applicationID
        minSdk = NewsAppConfigs.minSDKVersion
        targetSdk = NewsAppConfigs.targetSDKVersion
        versionCode = NewsAppConfigs.versionCode
        versionName = NewsAppConfigs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures.viewBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    kapt {
        arguments {
            arg("room.schemaLocation", "$projectDir/schemas".toString())
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Library.kotlinSDK)
    implementation(Library.appCompat)
    implementation(Library.coreKtx)
    implementation(Library.constraintLayout)

//    Hilt
    implementation(Library.hiltAndroid)
    kapt(Library.hiltCompiler)

    // ViewModel dependencies
    implementation(Library.lifecycleViewModel)

    // jetpack navigation component
    implementation(Library.navigationFragment)
    implementation(Library.navigationUI)
    implementation(Library.navigationDynamic)

    // Room
    implementation(Library.roomKtx)
    implementation(Library.roomRuntime)
    kapt(Library.roomCompiler)

    // livedate
    implementation(Library.lifecycleLivedata)

    // retrofit and Gson
    implementation(Library.retrofit)
    implementation(Library.loggingInterceptor)
    implementation(Library.moshi)
    implementation(Library.moshiConverter)
    kapt(Library.moshiCodegen)

    // coil
    implementation(Library.coil)

//    datastore
    implementation(Library.dataStore)

    testImplementation(Library.testJunit)
    androidTestImplementation(Library.testExtJunit)
    androidTestImplementation(Library.testEspressoCore)
}
