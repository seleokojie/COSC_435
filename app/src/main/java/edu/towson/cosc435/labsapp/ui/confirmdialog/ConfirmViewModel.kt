package edu.towson.cosc435.labsapp.ui.confirmdialog

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ConfirmViewModel : ViewModel(), IConfirmViewModel {
    private val _showConfirmDialog: MutableState<Boolean> = mutableStateOf(false)
    private var _onConfirmDeleteCallback: (() -> Unit)? = null
    override val showConfirmDialog: State<Boolean> = _showConfirmDialog

    override fun showConfirmDelete(onConfirm: () -> Unit) {
        _showConfirmDialog.value = true
        _onConfirmDeleteCallback = onConfirm
    }

    override fun onConfirmDelete() {
        if(_onConfirmDeleteCallback != null) {
            _onConfirmDeleteCallback?.invoke()
            dismissDialog()
        }
    }

    override fun dismissDialog() {
        _showConfirmDialog.value = false
    }
}