package edu.towson.cosc435.labsapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LandscapeView(content: @Composable () -> Unit) {
    Row(
    ) {
        Card(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.CenterVertically)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // TODO - 5b. Display the currently selected song here
            }
        }
        content()
    }
}