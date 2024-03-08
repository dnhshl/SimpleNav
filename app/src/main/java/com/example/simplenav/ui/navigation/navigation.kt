package com.example.simplenav.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.simplenav.R
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
    object Home : NavDestination(
        route = "home",
        title = R.string.homeScreenTitle,
        label = R.string.homeScreenLabel,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon =Icons.Outlined.Home,
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

    object Screen1 : NavDestination(
        route = "other1",
        title = R.string.settingsScreenTitle,
        showArrowBack = true,
        content = { navController -> OtherScreen1(navController) }
    )

    object Screen2 : NavDestination(
        route = "other2",
        title = R.string.settingsScreenTitle,
        showArrowBack = true,
        content = { navController -> OtherScreen2(navController) }
    )

    object Info : NavDestination(
        route = "info",
        content = { navController -> InfoScreen(navController) }
    )
}


val bottomBarNavDestinations = listOf (
    NavDestination.Home,
    NavDestination.Details,
    NavDestination.Settings,
)

val otherDestinations = listOf (
    NavDestination.Screen1,
    NavDestination.Screen2
)

val navDestinations = bottomBarNavDestinations + otherDestinations

val dialogDestinations = listOf (
    NavDestination.Info
)
fun isBottomNavDestination(route: String): Boolean {
    return bottomBarNavDestinations.any { it.route == route }
}
fun hasArrowBack(route: String): Boolean {
    val destination = navDestinations.filter { it.route == route }
    if (destination.size > 0) return destination[0].showArrowBack
    return false
}

