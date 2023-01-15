package edu.towson.cosc435.labsapp.data.impl

import edu.towson.cosc435.labsapp.data.ISongsRepository
import edu.towson.cosc435.labsapp.model.Song

class SongsRepository : ISongsRepository {

    private var _songs = listOf<Song>()

    init {
        _songs = (0..20).map { i ->
            Song("Song $i", "Artist $i", i, i % 3 == 0)
        }
    }

    override fun getSongs(): List<Song> {
        return _songs
    }

    override fun deleteSong(idx: Int) {
        _songs = _songs.subList(0, idx) + _songs.subList(idx+1, _songs.size)
    }

    override fun addSong(song: Song) {
        _songs = listOf(song) + _songs
    }

    override fun toggleAwesome(idx: Int) {
        val oldSong = _songs.get(idx)
        val newSong = oldSong.copy(isAwesome = !oldSong.isAwesome)
        _songs = _songs.subList(0, idx) + listOf(newSong) + _songs.subList(idx+1, _songs.size)
    }
}