package com.example.navigation

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "profile") {
        composable("profile") {
            Profile(navController)
        }
        composable("friendList") {
            FriendList(navController)
        }
    }
}

@Composable
fun Profile(navController: NavController) {
    Column {
        Text(text = "Hello Profile!")
        Button(onClick = { navController.navigate("friendList") }) {
            Text(text = "Navigate friendList")
        }
    }
}

@Composable
fun FriendList(navController: NavController) {
    Column {
        Text(text = "Hello FriendList!")
        Button(onClick = { navController.navigate("profile") }) {
            Text(text = "Navigate profile")
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    Profile(navController)
}

@Preview
@Composable
fun FriendListPreview() {
    val navController = rememberNavController()
    FriendList(navController)
}