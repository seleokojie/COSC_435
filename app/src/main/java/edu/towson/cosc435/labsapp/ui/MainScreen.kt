package edu.towson.cosc435.labsapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
        BottomNavigationItem(
            selected = false, // TODO - 10. Set to true if the current route is the SongListRoute
            onClick = {
                // TODO - 9. Navigate to the song list route
            },
            icon = {
                Icon(Icons.Default.Home, "")
            },
            label = {
                Text("SongList")
            }
        )
        BottomNavigationItem(
            selected = false, // TODO - 12. Set to true if the current route is the NewSong route
            onClick = {
                // TODO - 11. Navigate to the new song route
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