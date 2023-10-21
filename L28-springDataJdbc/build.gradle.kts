dependencies {
    implementation("ch.qos.logback:logback-classic")
    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql")
    implementation("com.google.code.findbugs:jsr305")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("org.testcontainers:postgresql:1.19.1")
    testImplementation("org.testcontainers:junit-jupiter:1.19.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.4")
}
