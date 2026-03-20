package org.example.ex2

interface PaymentMethod {
    fun pay(amount: Double): Boolean
}

class BankAccount(
    private var availableAmount: Double,
    val cardNumber: String,
    val expirationDate: String,
    val cvvCode: Int,
    val userName: String
) {
    fun updateAmount(value: Double): Boolean {
        if (availableAmount + value >= 0) {
            availableAmount += value
            return true
        }
        return false
    }
}

class CardPayment(private val bankAccount: BankAccount) : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        return bankAccount.updateAmount(-amount)
    }
}

class CashPayment(private var availableAmount: Double) : PaymentMethod {
    override fun pay(amount: Double): Boolean {
        if (availableAmount >= amount) {
            availableAmount -= amount
            return true
        }
        return false
    }
}