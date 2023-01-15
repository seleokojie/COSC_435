package edu.towson.cosc435.labsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import edu.towson.cosc435.labsapp.model.Song
import edu.towson.cosc435.labsapp.ui.SearchBar
import edu.towson.cosc435.labsapp.ui.SongRow
import edu.towson.cosc435.labsapp.ui.theme.LabsAppTheme

class MainActivity : ComponentActivity() {

    private var original = (0..20).map { i ->
        Song("Song $i", "Artist $i", i, i % 3 == 0)
    }

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("TAG", "onCreate")
            LabsAppTheme {
                var songs by remember { mutableStateOf(original) }
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen(songs,
                        onDelete={ idx ->
                            songs = songs.subList(0, idx) + songs.subList(idx+1, songs.size)
                            original = songs },
                        onToggle={ idx ->
                            songs = songs.mapIndexed { index, song ->
                                if(idx == index) {
                                    song.copy(isAwesome = !song.isAwesome)
                                } else
                                    song
                            }
                            original = songs
                        },
                        onFilter={ s -> songs = original.filter { a -> a.name.contains(s, true) }}
                    )
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    songs: List<Song>,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit,
    onFilter: (String) -> Unit
) {
    // TODO - 6. When in landscape, display the LandscapeView composable
    Column(
    ) {
        SearchBar(onFilter=onFilter)
        LazyColumn {
            itemsIndexed(songs) { idx, song ->
                SongRow(idx, song, onDelete, onToggle)
            }
        }
    }
}

// TODO - 1. Create a ViewModel subclass for the MainScreen composable
// TODO - 2. Implement the ISongsRepository interface
// TODO - 3. Move all functions out of onCreate and into your new ViewModel
// TODO - 4. Implement the addSong function using the supplied FAB composable
// TODO - 5a. Maintain the state of the currently selected song (in your ViewModel)

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val songs = (0..20).map { i ->
        Song("Song $i", "Artist $i", i, i % 3 == 0)
    }
    LabsAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            MainScreen(songs, {}, {}, {})
        }
    }
}