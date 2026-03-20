package org.example.ex3

fun main() {
    val repo = FileNoteRepository()
    val manager = NoteManager(repo)
    val app = NoteApp(User("Student_TUIASI"), manager)
    app.start()
}