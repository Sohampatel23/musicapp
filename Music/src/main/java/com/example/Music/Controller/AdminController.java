package com.example.Music.Controller;

import com.example.Music.Model.Song;
import com.example.Music.Model.SongDto;
import com.example.Music.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class AdminController {

    @Autowired
    SongService songService;

    @PostMapping("addSong")
    public String addSong(Song song)
    {
        return songService.addSong(song);
    }

    @GetMapping("getSongs")
    public List<Song> getAllSong()
    {
        return songService.getAllSongs();
    }

    @PutMapping("updateSong/{id}/{name}")
    public String updateSong(@PathVariable Integer id,@PathVariable String name)
    {
        return songService.updateSong(id,name);
    }

    @DeleteMapping("deleteSong/{id}")
    public String deleteSong(@PathVariable Integer id)
    {
        return songService.deleteSong(id);
    }
}
