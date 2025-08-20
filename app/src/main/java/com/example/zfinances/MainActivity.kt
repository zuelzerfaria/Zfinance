package com.example.zfinances

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.zfinances.presentation.navigation.ZfinancesNavigation
import com.example.zfinances.ui.theme.ZfinancesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZfinancesTheme {
                val navController = rememberNavController()
                ZfinancesNavigation(navController = navController)
            }
        }
    }
}
