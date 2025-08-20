package com.example.zfinances.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zfinances.presentation.components.NavigationDrawer
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCreditCardScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Estados para os campos do formulário
    var nickname by remember { mutableStateOf("") }
    var bank by remember { mutableStateOf("") }
    var closingDay by remember { mutableStateOf("") }
    var paymentDay by remember { mutableStateOf("") }
    var creditLimit by remember { mutableStateOf("") }

    NavigationDrawer(
        drawerState = drawerState,
        navController = navController
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Cadastrar Cartão") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Apelido do Cartão
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Apelido do Cartão",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = nickname,
                            onValueChange = { nickname = it },
                            label = { Text("Ex: Cartão Principal") },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("Digite um apelido para o cartão") }
                        )
                    }
                }

                // Banco do Cartão
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Banco do Cartão",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = bank,
                            onValueChange = { bank = it },
                            label = { Text("Ex: Nubank, Itaú, Bradesco") },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("Digite o nome do banco") }
                        )
                    }
                }

                // Dia de Fechamento da Fatura
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Dia de Fechamento da Fatura",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = closingDay,
                            onValueChange = {
                                if (it.length <= 2 && (it.isEmpty() || it.toIntOrNull() != null)) {
                                    closingDay = it
                                }
                            },
                            label = { Text("Dia (1-31)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("Ex: 10") }
                        )
                    }
                }

                // Dia de Vencimento da Fatura
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Dia de Vencimento da Fatura",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = paymentDay,
                            onValueChange = {
                                if (it.length <= 2 && (it.isEmpty() || it.toIntOrNull() != null)) {
                                    paymentDay = it
                                }
                            },
                            label = { Text("Dia (1-31)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("Ex: 15") }
                        )
                    }
                }

                // Limite do Cartão
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Limite do Cartão",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = creditLimit,
                            onValueChange = { creditLimit = it },
                            label = { Text("R$ 0,00") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("Digite o limite do cartão") }
                        )
                    }
                }

                // Botão Salvar
                Button(
                    onClick = {
                        // TODO: Implementar lógica de salvar cartão
                        // Por enquanto apenas mostrar um feedback
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                ) {
                    Text(
                        text = "SALVAR CARTÃO",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
