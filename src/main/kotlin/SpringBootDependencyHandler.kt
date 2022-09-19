fun springBoot(name: String, version: String?) =
    "org.springframework.boot:spring-boot-$name${version?.let { ":$it" }}"