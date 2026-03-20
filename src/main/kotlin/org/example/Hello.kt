package org.example

fun main() {
    val crawler = Crawler("https://google.com")
    val myParser = JsonParser()
    crawler.processContent(myParser)
}