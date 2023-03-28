package edu.towson.cosc435.labsapp.ui.nav

import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.towson.cosc435.labsapp.model.Song
import edu.towson.cosc435.labsapp.ui.confirmdialog.ConfirmViewModel
import edu.towson.cosc435.labsapp.ui.newsong.NewSongView
import edu.towson.cosc435.labsapp.ui.songlist.SongListView
import edu.towson.cosc435.labsapp.ui.songlist.SongListViewModel

@OptIn(ExperimentalComposeUiApi::class)
@ExperimentalFoundationApi
@Composable
fun SongsNavGraph(
    navController: NavHostController = rememberNavController()
){
    val vm: SongListViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Routes.SongList.route
    ){
        composable(Routes.SongList.route) {
            val confirmViewModel: ConfirmViewModel = viewModel()
            val songs by vm.songs
            val selectedSong by vm.selectedSong
            SongListView(
                songs,
                selectedSong,
                confirmViewModel,
                onDelete=vm::deleteSong,
                onToggle=vm::toggleAwesome,
                onFilter=vm::filter,
                onSelectSong=vm::selectSong,
                onAddSong = {
                    navController.navigate(Routes.AddSong.route)
                }
            )
        }

        composable(Routes.AddSong.route) {
            NewSongView(onAddSong = { song ->
                vm.addSong(song)
                navController.popBackStack()
            })
        }

    }
}