package org.example.ex3

interface NoteRepository {
    fun save(note: Note)
    fun getAll(): List<Note>
    fun delete(id: String): Boolean
    fun getById(id: String): Note?
}