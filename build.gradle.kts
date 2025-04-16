plugins {
    id("java")
}

group = "de.philgenstock"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val mockitoVersion = "5.17.0"
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

tasks.test {
    useJUnitPlatform()
}