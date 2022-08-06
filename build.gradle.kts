// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Library.classPathGradle)
        classpath(Library.classPathKotlin)
        classpath(Library.classPathHilt)
        classpath(Library.classPathKtlint)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")
allprojects {
    repositories {
        google()
        mavenCentral()
        
    }
}

subprojects {

//    region ktlint
    apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent

    // Optionally configure plugin
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
        version.set("0.42.0")
        outputColorName.set("RED")
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
        }
    }
//    endregion ktlint

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
