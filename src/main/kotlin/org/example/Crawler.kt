package org.example

import org.jsoup.Jsoup

class Crawler(private val url: String) {

    fun getResource(): String {
        return try {
            Jsoup.connect(url).ignoreContentType(true).execute().body()
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }

    fun processContent(parser: Parser) {
        val rawData = getResource()
        val result = parser.parse(rawData)
        println("Result: $result")
    }
}