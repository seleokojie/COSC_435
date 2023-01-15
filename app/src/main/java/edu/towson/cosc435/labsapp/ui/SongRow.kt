package edu.towson.cosc435.labsapp.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.towson.cosc435.labsapp.model.Song

@ExperimentalFoundationApi
@Composable
fun SongRow(
    idx: Int,
    song: Song,
    onDelete: (Int) -> Unit,
    onToggle: (Int) -> Unit,
    onSelectSong: (Song) -> Unit
) {
    Log.d("TAG", song.name)
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 16.dp,
        modifier = Modifier
            .padding(start=16.dp, end=16.dp, top=5.dp, bottom=5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .combinedClickable(
                    onLongClick = {
                        onDelete(idx)
                    }
                ) {
                    onSelectSong(song)
                }.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(1.5f)
            ) {
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Name:", modifier = Modifier.weight(1.0f))
                    Text(song.name, modifier = Modifier.weight(2.0f), fontSize = 28.sp, color = MaterialTheme.colors.secondary)
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Artist:", modifier = Modifier.weight(1.0f))
                    Text(song.artist, modifier = Modifier.weight(2.0f))
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Track:", modifier = Modifier.weight(1.0f))
                    Text(song.track.toString(), modifier = Modifier.weight(2.0f))
                }
            }
            Column(
                modifier = Modifier.weight(1.0f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick= { onDelete(idx) }, modifier = Modifier.fillMaxWidth()) {
                    Text("Delete")
                }
                Spacer(modifier = Modifier.padding(bottom=5.dp))
                Row() {
                    Checkbox(checked = song.isAwesome, onCheckedChange = { onToggle(idx) }, modifier = Modifier.padding(end=5.dp))
                    Text("Is Awesome")
                }
            }
        }
    }
}
