plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "bigs-test"
include("api-external", "api-internal", "common")
