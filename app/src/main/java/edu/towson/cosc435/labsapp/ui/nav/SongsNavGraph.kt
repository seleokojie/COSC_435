package edu.towson.cosc435.labsapp.ui.nav

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@ExperimentalFoundationApi
@Composable
fun SongsNavGraph(
    navController: NavHostController = rememberNavController()
) {
    // TODO - 7. Move the SongsListViewModel to here in order to "share" it with the NewSongView composable
    NavHost(
        navController = navController,
        startDestination = "???" // TODO - 6. Set the startDestination to the SongList route
    ) {
        // TODO - 4. Add a composable route for the SongsList. Move the previous main screen code here.
        // TODO - 5. Add a composable route for the NewSongView.
        // TODO - 8. In the NewSongView's onAddSong callback, add the song and navigate back
    }
}