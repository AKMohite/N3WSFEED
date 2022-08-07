//https://blog.kotlin-academy.com/kotlin-dsl-buildsrc-product-flavors-flavor-icon-and-more-abf30c65e8fd
object Library {

    const val classPathGradle = "com.android.tools.build:gradle:${Version.gradle}"
    const val classPathKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val classPathHilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.hilt}"
    const val classPathKtlint = "org.jlleitschuh.gradle:ktlint-gradle:${Version.ktlint}"
    const val classPathDetekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Version.detekt}"
    const val classPathVersionUpdates = "com.github.ben-manes:gradle-versions-plugin:${Version.versionUpdates}"
    const val kotlinSDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val navigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Version.navigation}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.loggingInterceptor}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Version.moshi}"
    const val coil = "io.coil-kt:coil:${Version.coil}"
    const val dataStore = "androidx.datastore:datastore-preferences:${Version.dataStore}"
    const val testJunit = "junit:junit:${Version.junit}"
    const val testExtJunit = "androidx.test.ext:junit:${Version.extJunit}"
    const val testEspressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
}