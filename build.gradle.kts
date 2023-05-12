repositories {
	mavenCentral()
}

plugins {
	java
	id("org.springframework.boot") version "3.0.6"
	id("org.liquibase.gradle")  version "2.2.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")

	liquibaseRuntime("org.liquibase:liquibase-core")
	liquibaseRuntime("com.mysql:mysql-connector-j")

	liquibaseRuntime("org.liquibase.ext:liquibase-hibernate5:3.8")
	liquibaseRuntime("org.springframework.boot:spring-boot")

	liquibaseRuntime("info.picocli:picocli:4.6.3")

	implementation("org.springframework.kafka:spring-kafka")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	testImplementation("org.springframework.security:spring-security-test")
}

apply(plugin = "org.liquibase.gradle")

liquibase {
	activities {
		register("main"){
			arguments = mapOf(
					"logLevel" to "info",
					"changeLogFile" to "src/main/resources/db/changelog/db.changelog-master.yaml",
					"url" to "jdbc:mysql://localhost:3306/credit_system",
					"username" to "root",
					"password" to  "admin"
			)
		}
	}
	runList = "main"
	//mainClassName = "org.liquibase.gradle.OutputEnablingLiquibaseRunner"
}

tasks.withType<Test> {
	useJUnitPlatform()
}
