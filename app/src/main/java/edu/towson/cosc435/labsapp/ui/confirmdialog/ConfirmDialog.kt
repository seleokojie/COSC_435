package edu.towson.cosc435.labsapp.ui.confirmdialog

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun ConfirmDialog(
    title: String,
    text: String,
    confirmViewModel: IConfirmViewModel,
) {
    val show by confirmViewModel.showConfirmDialog
    if(show) {
        AlertDialog(
            onDismissRequest = { confirmViewModel.dismissDialog() },
            title = {
                Text(title)
            },
            text = {
                Text(text)
            },
            confirmButton = {
                Button({
                    confirmViewModel.onConfirmDelete()
                }) {
                    Text("Delete")
                }
            }
        )
    }
}