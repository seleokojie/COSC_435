package edu.towson.cosc435.labsapp.model

data class Album(val name: String, val songs: List<Song> = listOf()) {
}