package com.courses.jetpackinstagramapp

sealed class NavigationItem(
    val title: String,
    val icon: Int = R.drawable.profile,
    val route: String
) {

    data object Home : NavigationItem(title = "home", icon = R.drawable.home, route = BottomNavRoutes.HOME.route)

    data object Search : NavigationItem(title = "search", icon = R.drawable.search, route = BottomNavRoutes.SEARCH.route)

    data object Reels : NavigationItem(title = "reels", icon = R.drawable.reel, route = BottomNavRoutes.REELS.route)

    data object Notification : NavigationItem(title = "notification", icon = R.drawable.shop, route = BottomNavRoutes.NOTIFICATION.route)

    data object Profile : NavigationItem(title = "profile", icon = R.drawable.profile, route = BottomNavRoutes.PROFILE.route)

}

enum class BottomNavRoutes(val route: String) {
    HOME("home"),
    SEARCH("search"),
    REELS("reels"),
    NOTIFICATION("notification"),
    PROFILE("profile")
}

