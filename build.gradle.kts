import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jmailen.gradle.kotlinter.tasks.LintTask
import org.jmailen.gradle.kotlinter.tasks.FormatTask

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jmailen.gradle:kotlinter-gradle:3.4.0")
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

tasks.create<LintTask>("ktLint") {
    group = "verification"
    source(files("shared"))
    reports.set(mapOf(
        "plain" to file("build/lint-report.txt"),
        "json" to file("build/lint-report.json")
    ))
}

tasks.create<FormatTask>("ktFormat") {
    group = "formatting"
    source(files("shared"))
    report.set(file("build/format-report.txt"))
}