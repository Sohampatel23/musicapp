package com.example.Music.Service;

import com.example.Music.Model.Song;
import com.example.Music.Model.SongDto;
import com.example.Music.Repo.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    ISongRepo iSongRepo;
    public String addSong(Song song) {
        iSongRepo.save(song);
        return "Song added";
    }

    public List<Song> getAllSongs() {
        return (List<Song>) iSongRepo.findAll();
    }

    public String updateSong(Integer id, String name) {
        Optional<Song> songOptional = iSongRepo.findById(id);

        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setSongName(name); // Update the name

            iSongRepo.save(song); // Save the updated song back to the database

            return "Song updated successfully";
        } else {
            return "Song not found for ID: " + id;
        }
    }

    public String deleteSong(Integer id) {
        iSongRepo.deleteById(id);
        return "Song Deleted";
    }
}
