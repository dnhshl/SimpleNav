package com.example.simplenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simplenav.ui.MyMenu
import com.example.simplenav.ui.MyNavBar
import com.example.simplenav.ui.MyTopBar
import com.example.simplenav.ui.homeScreenRoute
import com.example.simplenav.ui.navDestinations
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

@Composable
fun MyApp() {
    val navController = rememberNavController()

    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            MyTopBar(
                navController = navController,
                screens = navDestinations,
                onMenuClick = { showMenu = !showMenu }
            )
        },
        bottomBar = {
            MyNavBar(
                navController = navController,
                screens = navDestinations
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = homeScreenRoute,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            navDestinations.forEach { screen ->
                composable(screen.route) {
                    screen.content(navController)
                }
            }
        }
        MyMenu(
            showMenu = showMenu,
            navController = navController,
            paddingValues = paddingValues,
            onToggleMenu = { showMenu = !showMenu }
        )
    }
}




