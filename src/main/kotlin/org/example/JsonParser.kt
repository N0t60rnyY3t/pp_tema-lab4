package org.example

class JsonParser : Parser {
    override fun parse(text: String): Map<String, Any> {
        println("Parsing JSON content...")
        return mapOf("type" to "json", "content" to text.take(20))
    }
}