package edu.towson.cosc435.labsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import edu.towson.cosc435.labsapp.model.Song
import edu.towson.cosc435.labsapp.ui.theme.LabsAppTheme

class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val songs = listOf<Song>()
                    MainScreen(songs)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    songs: List<Song>
) {
    Column(
    ) {
        // TODO - 3d. Add Search bar here
        // TODO - 1b. Add the LazyList here
    }
}

// TODO - 1. Display 20 songs in a LazyList using the SongRow composable
// TODO - 2. Implement deletion of a single Song row
// TODO - 3. Implement the Song row checkbox to track the "IsAwesome" state
// TODO - 4. Implement a search bar for filtering the list.
// TODO - 4a. Create a new Composable (Row with OutlinedTextField and Button) for the Search feature
// TODO - 4b. Add internal mutable state to track the text input for the Search composable.
// TODO - 4c. Hoist a function that handles the search button click

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val songs = listOf(Song("Thriller", "MJ", 1, true), Song("Hotline Bling", "Drake", 2, false))
    LabsAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            MainScreen(songs)
        }
    }
}