object Libs {
    //Kotlin
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val androidCoreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

    //AppCompat
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"

    //Koin
    const val insertKoinCore = "io.insert-koin:koin-core:${Versions.koinVersion}"
    const val insertKoinAndroid = "io.insert-koin:koin-android:${Versions.koinVersion}"
    const val insertKoinAndroidCompose = "io.insert-koin:koin-androidx-compose:${Versions.koinVersion}"

    //Compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivityVersion}"

    //Coil
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilVersion}"

    //Api things
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"

    //Test
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExtVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"

}