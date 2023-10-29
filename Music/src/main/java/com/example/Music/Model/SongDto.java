package com.example.Music.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;
    private String songName;
    private String songArtist;
    private Integer songLength;

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
