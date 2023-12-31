package com.example.Music.Service;

import com.example.Music.Model.Playlist;
import com.example.Music.Model.Song;
import com.example.Music.Repo.IPlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    IPlaylistRepo iPlaylistRepo;
    public String addToPlaylist(Playlist playlist) {
        iPlaylistRepo.save(playlist);
        return "Added to playlist";
    }

    public List<Playlist> getPlaylist() {
    return (List<Playlist>) iPlaylistRepo.findAll();
    }
}
