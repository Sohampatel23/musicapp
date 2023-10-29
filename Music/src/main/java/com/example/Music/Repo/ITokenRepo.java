package com.example.Music.Repo;

import com.example.Music.Model.User;
import com.example.Music.Model.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<UserToken,Integer> {
    UserToken findFirstByTokenValue(String authTokenValue);

    UserToken findFirstByUser(User user);
}
