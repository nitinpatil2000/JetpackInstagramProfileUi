package com.courses.jetpackinstagramapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(navHostController: NavHostController) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val screenList = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Reels,
        NavigationItem.Notification,
        NavigationItem.Profile,
    )

    NavigationBar(
        modifier = Modifier.background(Color.White) // Set the background color here
    ) {
        screenList.forEach { screen ->
            contentColorFor(backgroundColor = Color.Red)
            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                onClick = { navHostController.navigate(screen.route) },
                icon = {
                    if (screen.route == NavigationItem.Profile.route) {
                        ProfileIcon()
                    } else {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = screen.title,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(24.dp)
                    )
                },



                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Red,
                    unselectedIconColor = Color.Black,
                    indicatorColor = Color.Transparent,

                    )
            )
        }
    }
}


@Composable
fun ProfileIcon() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = null,
        modifier = Modifier
            .border(width = 1.dp, color = Color.Red, shape = CircleShape)
            .size(24.dp)
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .clip(CircleShape)
    )
}
