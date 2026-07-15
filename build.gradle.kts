plugins {
	java
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.dependency.management)
}

group = "com.psb.potential"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

//configurations {
//	compileOnly {
//		extendsFrom(configurations.annotationProcessor.get())
//	}
//}

repositories {
	mavenCentral()
}

dependencies {
	implementation(platform(libs.spring.ai.bom))
	implementation(libs.bundles.web)
	implementation(libs.spring.ai.openai)
	implementation(libs.spring.ai.vector.store)
	implementation(libs.spring.ai.pinecone)
	//implementation(libs.spring.boot.starter.data.jpa)
	//implementation("libs.spring.boot.starter.security")
	//compileOnly("libs.lombok")
	//developmentOnly("libs.spring.boot.devtools")
	//runtimeOnly("libs.h2")
	//annotationProcessor("libs.lombok")
	testImplementation(libs.spring.boot.starter.test)
	//testImplementation("libs.spring.security.test")
	//testRuntimeOnly("libs.junit.platform.launcher")
}

tasks.test {
	useJUnitPlatform()
}
