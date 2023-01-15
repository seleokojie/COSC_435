package edu.towson.cosc435.labsapp.data

import edu.towson.cosc435.labsapp.model.Song

interface ISongsRepository {
    fun getSongs(): List<Song>
    fun deleteSong(idx: Int)
    fun addSong(song: Song)
    fun toggleAwesome(idx: Int, song: Song)
}