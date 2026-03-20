package org.example.ex3

import java.util.Scanner

class NoteApp(private val user: User, private val manager: NoteManager) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            println("\nUtilizator: ${user.name} | 1.Lista 2.Incarca 3.Nou 4.Sterge 5.Iesire")
            when (scanner.nextLine()) {
                "1" -> manager.listNotes().forEach { println("[${it.id}] De: ${it.author} la ${it.timestamp}") }
                "2" -> {
                    print("ID notita: "); val note = manager.loadNote(scanner.nextLine())
                    println(note?.content ?: "Notita negasita.")
                }
                "3" -> {
                    print("Continut: "); manager.createNote(user.name, scanner.nextLine())
                    println("Salvat!")
                }
                "4" -> {
                    print("ID pentru stergere: "); manager.removeNote(scanner.nextLine())
                    println("Operatiune finalizata.")
                }
                "5" -> break
            }
        }
    }
}