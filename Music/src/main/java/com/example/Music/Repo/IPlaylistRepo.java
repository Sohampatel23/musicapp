package com.example.Music.Repo;

import com.example.Music.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepo extends JpaRepository<Playlist,Integer> {
}
