package com.example.zfinances.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zfinances.presentation.navigation.Screen
import kotlinx.coroutines.launch

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    navController: NavController,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val navigationItems = listOf(
        NavigationItem("Nova Despesa", Icons.Default.Add, Screen.AddTransaction.route),
        NavigationItem("Cartões", Icons.Default.Star, Screen.CreditCards.route),
        NavigationItem("Cadastrar Cartão", Icons.Default.AddCircle, Screen.AddCreditCard.route),
        NavigationItem("Home", Icons.Default.Home, Screen.Home.route),
        NavigationItem("Transações", Icons.Default.List, Screen.Transactions.route),
        NavigationItem("Relatórios", Icons.Default.Info, Screen.Reports.route),
        NavigationItem("Configurações", Icons.Default.Settings, Screen.Settings.route)
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(280.dp)
            ) {
                // Header do Drawer
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(16.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Column {
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "ZFinances",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Controle Financeiro",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                HorizontalDivider()

                // Itens de navegação
                navigationItems.forEach { item ->
                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        },
                        label = { Text(item.title) },
                        selected = false, // TODO: Implementar lógica de seleção baseada na rota atual
                        onClick = {
                            navController.navigate(item.route) {
                                // Evita múltiplas instâncias da mesma tela
                                launchSingleTop = true
                                // Limpa o back stack até a tela de destino se ela já existir
                                popUpTo(item.route) { inclusive = true }
                            }
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                    )
                }
            }
        }
    ) {
        content()
    }
}
