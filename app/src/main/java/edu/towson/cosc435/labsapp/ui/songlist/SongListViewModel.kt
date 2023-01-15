package edu.towson.cosc435.labsapp.ui.songlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import edu.towson.cosc435.labsapp.data.ISongsRepository
import edu.towson.cosc435.labsapp.data.impl.SongsRepository
import edu.towson.cosc435.labsapp.model.Song

class SongListViewModel : ViewModel() {
    private val _songs: MutableState<List<Song>> = mutableStateOf(listOf())
    val songs: State<List<Song>> = _songs

    private val _selected: MutableState<Song?>
    val selectedSong: State<Song?>

    private val _repository: ISongsRepository = SongsRepository()

    init {
        _songs.value = _repository.getSongs()
        _selected = mutableStateOf(null)
        selectedSong = _selected
    }

    fun addSong(song: Song) {
        _repository.addSong(song)
        _songs.value = _repository.getSongs()
    }

    fun deleteSong(idx: Int) {
        _repository.deleteSong(idx)
        _songs.value = _repository.getSongs()
    }

    fun toggleAwesome(idx: Int) {
        _repository.toggleAwesome(idx)
        _songs.value = _repository.getSongs()
    }

    fun filter(search: String) {
        _songs.value = _repository.getSongs().filter { a -> a.name.contains(search, true) }
    }

    fun selectSong(song: Song) {
        _selected.value = song
    }
}