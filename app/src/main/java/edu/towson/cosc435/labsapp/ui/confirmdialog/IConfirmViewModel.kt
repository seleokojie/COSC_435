package edu.towson.cosc435.labsapp.ui.confirmdialog

import androidx.compose.runtime.State

interface IConfirmViewModel {
    val showConfirmDialog: State<Boolean>
    fun showConfirmDelete(onConfirm: () -> Unit)
    fun onConfirmDelete()
    fun dismissDialog()
}