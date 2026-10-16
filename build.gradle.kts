plugins {
    id("java")
}

group = "dev.rdh"

val glaDir = project.property("gla_dir") as? String ?: error("gla_dir needed to build gla!")
val glaPath = file(glaDir)
if (!glaPath.exists()) {
    error("gla_dir path does not exist: $glaDir")
}

val cargoToml = glaPath.resolve("Cargo.toml")
if (!cargoToml.exists()) {
    error("Cargo.toml not found in gla_dir: $glaDir")
}
val cargoContent = cargoToml.readText()
version = Regex("version = \"([^\"]+)\"").find(cargoContent)?.groupValues?.get(1)
    ?: error("Failed to parse version from Cargo.toml")

tasks.processResources {
    from(glaPath.resolve("target/release")) {
        include("libgla.dylib")
    }
}

val stubs = sourceSets.create("stubs")

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net")
}

dependencies {
    implementation("org.lwjgl:lwjgl:3.4.3")
    implementation("net.fabricmc:fabric-loader:0.19.5")
    compileOnly(stubs.output)
}

tasks.processResources {
    val v = project.version
    filesMatching("fabric.mod.json") {
        expand("version" to v)
    }
}

tasks.withType<JavaCompile> {
    options.release = 8
}
tasks.jar {
    manifest.attributes("TweakClass" to "dev.rdh.gla.GlaTweaker")
}
