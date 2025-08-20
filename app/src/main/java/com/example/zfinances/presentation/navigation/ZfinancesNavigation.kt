package com.example.zfinances.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zfinances.presentation.screens.AddCreditCardScreen
import com.example.zfinances.presentation.screens.AddTransactionScreen
import com.example.zfinances.presentation.screens.HomeScreen
import com.example.zfinances.presentation.screens.ReportsScreen
import com.example.zfinances.presentation.screens.SettingsScreen
import com.example.zfinances.presentation.screens.TransactionsScreen

@Composable
fun ZfinancesNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.AddTransaction.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.AddTransaction.route) {
            AddTransactionScreen(navController = navController)
        }

        composable(Screen.Transactions.route) {
            TransactionsScreen(navController = navController)
        }

        composable(Screen.Reports.route) {
            ReportsScreen(navController = navController)
        }

        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }

        composable(Screen.AddCreditCard.route) {
            AddCreditCardScreen(navController = navController)
        }

        composable(Screen.CreditCards.route) {
            // TODO: Criar tela de listagem de cartões
            SettingsScreen(navController = navController) // Temporário
        }
    }
}
