import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.google.services)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            export(libs.kmp.notifier)
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.splash.screen)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtimeCompose)

//            implementation(libs.firebase.common.ktx)

            implementation(libs.auth.kmp)
            implementation(libs.firebase.app)

            implementation(libs.koin.compose)

            api(libs.kmp.notifier)

            implementation(project(path = ":navigation"))
            implementation(project(path = ":shared"))
            implementation(project(path = ":di"))
            implementation(project(path = ":data"))
        }
    }
}

android {
    namespace = "org.goiaba.boot.shop"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.goiaba.boot.shop"
        minSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

//dependencies {
//    implementation(project(":feature:home"))
//    implementation(project(":data"))
//    implementation(project(":navigation"))
//    implementation(project(":di"))
//    implementation(project(":shared"))
//    implementation(project(":feature:auth"))
//    implementation(libs.firebase.common.ktx)
//    debugImplementation(compose.uiTooling)
//}

