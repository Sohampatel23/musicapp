package com.example.Music.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;
    private String songName;
    private String songArtist;
    private Integer songLength;

//    @ManyToOne
//    @JoinColumn(name = "fk_playlistId")
//    Playlist playlist;

//    @ManyToMany(mappedBy = "songs") // Use "songs" instead of "playlists"
//    private Set<Playlist> playlists;
//
//    public Set<Playlist> getPlaylists() {
//        return playlists;
//    }
//
//    public void setPlaylists(Set<Playlist> playlists) {
//        this.playlists = playlists;
//    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public Integer getSongLength() {
        return songLength;
    }

    public void setSongLength(Integer songLength) {
        this.songLength = songLength;
    }
}
