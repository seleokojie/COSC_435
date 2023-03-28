package edu.towson.cosc435.labsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import edu.towson.cosc435.labsapp.model.Song
import edu.towson.cosc435.labsapp.ui.MainScreen
import edu.towson.cosc435.labsapp.ui.confirmdialog.ConfirmViewModel
import edu.towson.cosc435.labsapp.ui.songlist.SongListView
import edu.towson.cosc435.labsapp.ui.theme.LabsAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalComposeUiApi::class)
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("TAG", "onCreate")
            LabsAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val songs = (0..20).map { i ->
        Song("Song $i", "Artist $i", i, i % 3 == 0)
    }
    LabsAppTheme {
        Surface(color = MaterialTheme.colors.background) {
            val vm = ConfirmViewModel()
            SongListView(songs, songs[0], vm, {}, {}, {}, {}, {})
        }
    }
}