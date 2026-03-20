package org.example.ex3

class NoteManager(private val repository: NoteRepository) {
    fun listNotes() = repository.getAll()
    fun createNote(author: String, content: String) = repository.save(Note(author = author, content = content))
    fun removeNote(id: String) = repository.delete(id)
    fun loadNote(id: String) = repository.getById(id)
}