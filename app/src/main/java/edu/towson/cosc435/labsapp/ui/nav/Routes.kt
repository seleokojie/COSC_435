package edu.towson.cosc435.labsapp.ui.nav

sealed class Routes(val route: String) {
    object SongList: Routes("songlist")
    object AddSong: Routes("addsong")
}