package org.example.ex2

data class Movie(val title: String, val price: Double)

class TicketService(private val paymentMethod: PaymentMethod) {
    fun purchaseTicket(movie: Movie): Boolean {
        val success = paymentMethod.pay(movie.price)
        if (success) {
            println("Bilet achizitionat: ${movie.title}")
        } else {
            println("Plata esuata pentru: ${movie.title}")
        }
        return success
    }
}