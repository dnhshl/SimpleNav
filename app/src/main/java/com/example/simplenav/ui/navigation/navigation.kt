package com.example.simplenav.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.simplenav.R
import com.example.simplenav.ui.screens.AlertDialogScreen
import com.example.simplenav.ui.screens.DetailsScreen
import com.example.simplenav.ui.screens.HomeScreen
import com.example.simplenav.ui.screens.InfoScreen
import com.example.simplenav.ui.screens.OtherScreen1
import com.example.simplenav.ui.screens.OtherScreen2
import com.example.simplenav.ui.screens.SettingsScreen

sealed class NavDestination(
    val route: String,
    val title: Int = 0,
    val label: Int = 0,
    val selectedIcon: ImageVector = Icons.Default.Check,
    val unselectedIcon: ImageVector = Icons.Default.Check,
    val showArrowBack: Boolean = false,
    val content: @Composable (NavController) -> Unit
) {

    // hier alle Bildschirme mit den notwendigen Infos dazu listen

    // BottomNavScreens

    object Home : NavDestination(
        route = "home",                          // eindeutige Kennung
        title = R.string.homeScreenTitle,        // Titel in der TopBar
        label = R.string.homeScreenLabel,        // Label in der BottomBar
        selectedIcon = Icons.Filled.Home,        // Icon in der BottomBar, wenn gewählt
        unselectedIcon =Icons.Outlined.Home,     // Icon in der BottomBar, wenn nicht gewählt
        // Lambda Funktion, über die der Screen aufgerufen wird
        content = { navController -> HomeScreen(navController) }
    )

    object Details : NavDestination(
        route = "detail",
        title = R.string.detailsScreenTitle,
        label = R.string.detailsScreenLabel,
        selectedIcon = Icons.Filled.CheckCircle,
        unselectedIcon = Icons.Outlined.CheckCircle,
        content = { navController -> DetailsScreen(navController) }
    )

    object Settings : NavDestination(
        route = "settings",
        title = R.string.settingsScreenTitle,
        label = R.string.settingsScreenLabel,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
        content = { navController -> SettingsScreen(navController) }
    )

    // FullScreens (benötigen keine Icons und kein Label;
    // dafür aber showArrowBack = true für den Zurück Pfeil in der TopBar

    object Screen1 : NavDestination(
        route = "other1",
        title = R.string.otherScreen1Title,
        showArrowBack = true,
        content = { navController -> OtherScreen1(navController) }
    )

    object Screen2 : NavDestination(
        route = "other2",
        title = R.string.otherScreen2Title,
        showArrowBack = true,
        content = { navController -> OtherScreen2(navController) }
    )

    // Dialog Screens

    object Info : NavDestination(
        route = "info",
        content = { navController -> InfoScreen(navController) }
    )

    object AlertDialog : NavDestination(
        route = "alert_dialog",
        content = { navController -> AlertDialogScreen(navController) }
    )
}


// Hier alle Bildschirme listen, über die in der Bottom Bar navigiert werden soll
val bottomBarNavDestinations = listOf (
    NavDestination.Home,
    NavDestination.Details,
    NavDestination.Settings,
)


// Hier alle Bildschirme listen, die als FullScreen Bildschirm angesprungen werden sollen
// wenn es keine gibt, dann
// val otherDestinations = emptyList<NavDestination>()
val otherDestinations = listOf (
    NavDestination.Screen1,
    NavDestination.Screen2
)


val navDestinations = bottomBarNavDestinations + otherDestinations


// Hier alle Dialogbilschirme listen
// wenn es keine gibt, dann
// val dialogDestinations = emptyList<NavDestination>()
val dialogDestinations = listOf (
    NavDestination.Info,
    NavDestination.AlertDialog
)

