package edu.towson.cosc435.labsapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.labsapp.ui.nav.Routes
import edu.towson.cosc435.labsapp.ui.nav.SongsNavGraph

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val nav = rememberNavController()
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(nav = nav)
        }
    ) {
        SongsNavGraph(nav)
    }
}

@Composable
private fun TopBar() {
    TopAppBar(
        title = { Text("Songs App") },
    )
}

@Composable
private fun BottomBar(
    nav: NavHostController 
) {
    BottomNavigation(
        elevation = 16.dp
    ) {
        val backStack by nav.currentBackStackEntryAsState()
        val destination = backStack?.destination
        BottomNavigationItem(
            selected = destination?.route == Routes.SongList.route,
            onClick = {
                nav.navigate(Routes.SongList.route){
                    launchSingleTop = true
                    popUpTo(Routes.SongList.route){ inclusive = false }
                }
            },
            icon = {
                Icon(Icons.Default.Home, "")
            },
            label = {
                Text("SongList")
            }
        )
        BottomNavigationItem(
            selected = destination?.route == Routes.AddSong.route,
            onClick = {
                nav.navigate(Routes.AddSong.route){
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(Icons.Default.Add, "")
            },
            label = {
                Text("New Song")
            }
        )
    }
}