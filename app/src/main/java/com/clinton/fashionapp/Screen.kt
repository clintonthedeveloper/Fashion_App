package com.clinton.fashionapp

sealed class Screen(val route:String){
    data object Landing : Screen("Landing_Screen")
    data object Dashboard : Screen("dashboard_screen")
    data object Product : Screen("product_screen")
}