package com.example.Music.Controller;

import com.example.Music.Model.Playlist;
import com.example.Music.Model.SignUpDto;
import com.example.Music.Model.Song;
import com.example.Music.Model.User;
import com.example.Music.Service.PlaylistService;
import com.example.Music.Service.TokenService;
import com.example.Music.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;




    @PostMapping("user/signup")
    public String userSignUp(@Valid @RequestBody User user)
    {
        return userService.userSignUp(user);
    }



    //sign in
    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password)
    {
        return userService.userSignIn(email,password);
    }

    @PostMapping("addToPlaylist")
    public String addToPlaylist(@RequestParam String email, @RequestParam String tokenValue, @RequestBody Playlist playlist)
    {

        return userService.addToPlaylist(email,tokenValue,playlist);
    }


}
