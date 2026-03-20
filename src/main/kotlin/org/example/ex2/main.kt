package org.example.ex2

fun main() {
    val movie = Movie("Dune", 30.0)

    val myAccount = BankAccount(100.0, "4444-5555", "12/26", 123, "Popescu I.")
    val cardService = TicketService(CardPayment(myAccount))
    cardService.purchaseTicket(movie)

    val cashService = TicketService(CashPayment(10.0))
    cashService.purchaseTicket(movie)
}