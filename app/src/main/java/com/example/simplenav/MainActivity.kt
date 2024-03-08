package com.example.simplenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.simplenav.ui.screens.MyApp
import com.example.simplenav.ui.theme.SimpleNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleNavTheme {
                MyApp()
            }
        }
    }
}





