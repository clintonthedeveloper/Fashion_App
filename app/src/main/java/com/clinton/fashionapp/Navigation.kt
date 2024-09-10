package com.clinton.fashionapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clinton.fashionapp.screens.DashboardScreen
import com.clinton.fashionapp.screens.LandingScreen
import com.clinton.fashionapp.screens.LoginScreen
import com.clinton.fashionapp.screens.ProductScreen
import com.clinton.fashionapp.screens.register.RegisterScreen
import com.clinton.fashionapp.ui.theme.ROUTE_DASHBOARD
import com.clinton.fashionapp.ui.theme.ROUTE_LANDING
import com.clinton.fashionapp.ui.theme.ROUTE_LOGIN
import com.clinton.fashionapp.ui.theme.ROUTE_PRODUCT
import com.clinton.fashionapp.ui.theme.ROUTE_REGISTER
import java.lang.reflect.Modifier

@Composable
fun Navigation(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_LOGIN) {
    NavHost(navController = navController, modifier = Modifier, startDestination = startDestination) {
        composable(ROUTE_LANDING){
            LandingScreen(navController)
        }
        composable(ROUTE_DASHBOARD){
            DashboardScreen( navController)
        }
        composable(ROUTE_PRODUCT){
            ProductScreen( navController)

        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)

        }
    }
}