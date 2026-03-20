package org.example.ex3

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: String = UUID.randomUUID().toString().take(4),
    val author: String,
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)