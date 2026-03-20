package org.example

class XmlParser : Parser {
    override fun parse(text: String): Map<String, Any> {
        println("Parsing XML content...")
        return mapOf("type" to "xml", "content" to text.take(20))
    }
}