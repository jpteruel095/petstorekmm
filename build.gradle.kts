import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("com.android.tools.build:gradle:4.2.2")
    }
}

val localProperties = gradleLocalProperties(rootDir)

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri(
                path = localProperties.getProperty("REPOSITORY_ENDPOINT")!!
            )
            credentials {
                username = localProperties.getProperty("USERNAME")!!
                password = localProperties.getProperty("AUTH_TOKEN")!!
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}