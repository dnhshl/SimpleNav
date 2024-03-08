package com.example.simplenav.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun InfoScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyAlertDialog(
            onDismissRequest = { navController.popBackStack() },
            onConfirmation = { navController.popBackStack() },
            dialogTitle = "Info!",
            dialogText = "Löschen oder nicht löschen, das ist hier die Frage."
        )
    }
}
