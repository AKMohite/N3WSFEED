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
        classpath(Library.classPathDetekt)

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

//    region detekt
    apply(plugin = "io.gitlab.arturbosch.detekt")

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        config.from(rootProject.files("config/detekt/detekt.yml"))
        autoCorrect = true
        reports {
            html.required.set(true) // observe findings in your browser with structure and code snippets
            xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
            txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
            sarif.required.set(true) // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
            md.required.set(true) // simple Markdown format
        }
    }
//    endregion detekt
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
