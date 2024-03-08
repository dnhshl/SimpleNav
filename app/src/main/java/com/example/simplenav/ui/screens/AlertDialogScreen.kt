package com.example.simplenav.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun AlertDialogScreen(navController: NavController) {

    AlertDialog(
        title = { Text("Info!") },
        text = { Text("Löschen oder nicht löschen, das ist hier die Frage.") },
        onDismissRequest = { navController.popBackStack() },
        confirmButton = {
            TextButton( onClick = { navController.popBackStack() } ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton( onClick = { navController.popBackStack() } ) {
                Text("Dismiss")
            }
        }
    )
}
