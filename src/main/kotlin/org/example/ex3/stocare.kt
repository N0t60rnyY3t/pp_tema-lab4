package org.example.ex3

import java.io.File
import java.time.LocalDateTime

class FileNoteRepository(private val directory: String = "notes") : NoteRepository {
    init { File(directory).mkdirs() }

    override fun save(note: Note) {
        val file = File(directory, "${note.id}.txt")
        file.writeText("${note.author}\n${note.timestamp}\n${note.content}")
    }

    override fun getAll(): List<Note> {
        return File(directory).listFiles()?.mapNotNull { file ->
            val lines = file.readLines()
            if (lines.size >= 3) {
                Note(
                    id = file.nameWithoutExtension,
                    author = lines[0],
                    timestamp = LocalDateTime.parse(lines[1]),
                    content = lines.drop(2).joinToString("\n")
                )
            } else null
        } ?: emptyList()
    }

    override fun delete(id: String): Boolean = File(directory, "$id.txt").delete()

    override fun getById(id: String): Note? = getAll().find { it.id == id }
}