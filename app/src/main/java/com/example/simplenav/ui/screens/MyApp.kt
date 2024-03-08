package com.example.simplenav.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.example.simplenav.ui.navigation.MyMenu
import com.example.simplenav.ui.navigation.MyNavBar
import com.example.simplenav.ui.navigation.MyTopBar
import com.example.simplenav.ui.navigation.NavDestination
import com.example.simplenav.ui.navigation.bottomBarNavDestinations
import com.example.simplenav.ui.navigation.dialogDestinations
import com.example.simplenav.ui.navigation.hasArrowBack
import com.example.simplenav.ui.navigation.isBottomNavDestination
import com.example.simplenav.ui.navigation.navDestinations

@Composable
fun MyApp() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            MyTopBar(
                navController = navController,
                screens = bottomBarNavDestinations,
                onMenuClick = { showMenu = !showMenu },
                showArrowBack = hasArrowBack(currentRoute)
            )
        },
        bottomBar = {
            if (isBottomNavDestination(currentRoute)) {
                MyNavBar(
                    navController = navController,
                    screens = bottomBarNavDestinations
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavDestination.Home.route,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            // Screens via BottomBar
            navDestinations.forEach { screen ->
                composable(screen.route) {
                    screen.content(navController)
                }
            }
            // Other Screens
            dialogDestinations.forEach { screen ->
                dialog(screen.route) {
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

