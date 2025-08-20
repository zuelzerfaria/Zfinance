package com.example.zfinances.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddTransaction : Screen("add_transaction")
    object Transactions : Screen("transactions")
    object Reports : Screen("reports")
    object Settings : Screen("settings")
    object AddCreditCard : Screen("add_credit_card")
    object CreditCards : Screen("credit_cards")
}
