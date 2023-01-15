package edu.towson.cosc435.labsapp.ui.songlist

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import edu.towson.cosc435.labsapp.model.Song
import edu.towson.cosc435.labsapp.ui.AddSongFAB
import edu.towson.cosc435.labsapp.ui.confirmdialog.ConfirmViewModel
import edu.towson.cosc435.labsapp.ui.LandscapeView
import edu.towson.cosc435.labsapp.ui.SearchBar
import edu.towson.cosc435.labsapp.ui.SongRow
import edu.towson.cosc435.labsapp.ui.confirmdialog.*

@ExperimentalFoundationApi
@Composable
fun SongListView(
    songs: List<Song>,
    selectedSong: Song?,
    confirmViewModel: ConfirmViewModel,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit,
    onFilter: (String) -> Unit,
    onSelectSong: (Song) -> Unit,
    onAddSong: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        ConfirmDialog(
            title = "Confirm",
            text = "Are you sure you want to delete?",
            confirmViewModel = confirmViewModel,
        )
        Column() {
            SearchBar(onFilter = onFilter)
            val config = LocalConfiguration.current
            if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
                LazyColumn {
                    itemsIndexed(songs) { idx, song ->
                        SongRow(idx, song, { idx ->
                            confirmViewModel.showConfirmDelete(onConfirm={ onDelete(idx) })
                        }, onToggle, onSelectSong)
                    }
                }
            } else {
                LandscapeView(selectedSong?.name) {
                    LazyColumn {
                        itemsIndexed(songs) { idx, song ->
                            SongRow(idx, song, { idx ->
                                confirmViewModel.showConfirmDelete(onConfirm={ onDelete(idx) })
                            }, onToggle, onSelectSong)
                        }
                    }
                }
            }
        }
        AddSongFAB(
            onClick = onAddSong,
            modifier = Modifier.padding(16.dp).align(Alignment.BottomEnd)
        )
    }
}
