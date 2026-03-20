package org.example

class YamlParser : Parser {
    override fun parse(text: String): Map<String, Any> {
        println("Parsing YAML content...")
        return mapOf("type" to "yaml", "content" to text.take(20))
    }
}