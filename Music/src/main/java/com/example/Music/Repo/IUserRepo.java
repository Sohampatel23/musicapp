package com.example.Music.Repo;

import com.example.Music.Model.SignUpDto;
import com.example.Music.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Integer> {

    User findFirstByUserEmail(String newEmail);
}
