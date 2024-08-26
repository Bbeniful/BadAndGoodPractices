package com.bbeniful.badandgoodexamples.forgottenComments

class ForgottenComments {

    // TODO: This is just a temporary solution, we'll fix this later.
    // Calculate total payment amount
    fun calculateTotalBad(paymentList: List<Double>): Double {
        var total = 0.0

        for (payment in paymentList) {
            total += payment
        }

        // FIXME: This method doesn't handle negative payments, but we need to fix it later.
        return total
    }

    // I don't like the way this function is implemented, but it works for now.
    fun processPaymentBad(payment: Double): String {
        if (payment < 0) {
            return "Error: Negative payment not allowed."
        }
        return "Payment of $$payment processed."
    }

    // Solution

    // Improved version: Handles all payments properly, including negative values.
    fun calculateTotalGood(paymentList: List<Double>): Double {
        var total = 0.0

        for (payment in paymentList) {
            if (payment < 0) {
                throw IllegalArgumentException("Negative payments are not allowed.")
            }
            total += payment
        }

        return total
    }

    // Refactored: Handles negative payments properly and provides clear feedback.
    fun processPaymentGood(payment: Double): String {
        return if (payment < 0) {
            "Error: Negative payment not allowed."
        } else {
            "Payment of $$payment processed successfully."
        }
    }
}