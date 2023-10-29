package com.example.Music.Repo;

import com.example.Music.Model.Song;
import com.example.Music.Model.SongDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song,Integer> {
}
