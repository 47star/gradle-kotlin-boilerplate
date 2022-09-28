fun springBoot(name: String, version: String? = null) =
    "org.springframework.boot:spring-boot-$name${version?.let { ":$it" } ?: ""}"