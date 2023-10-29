package com.example.Music.Service;

import com.example.Music.Model.Playlist;
import com.example.Music.Model.SignUpDto;
import com.example.Music.Model.User;
import com.example.Music.Model.UserToken;
import com.example.Music.Repo.ITokenRepo;
import com.example.Music.Repo.IUserRepo;
import com.example.Music.Service.emailUtility.EmailHandler;
import com.example.Music.Service.hashingUtility.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    TokenService tokenService;

    @Autowired
    PlaylistService playlistService;

    public String userSignUp(User user) {

        String newEmail = user.getUserEmail();

        User existingUSer = iUserRepo.findFirstByUserEmail(newEmail);

        if (existingUSer != null) {
            return "email already in use";
        }


        String signUpPassword = user.getUserPassword();

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);

            user.setUserPassword(encryptedPassword);

            iUserRepo.save(user);
            return "user registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignIn(String email, String password) {

        User existingUser = iUserRepo.findFirstByUserEmail(email);

        if (existingUser == null) {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if (existingUser.getUserPassword().equals(encryptedPassword)) {
                // return a token for this sign in
                UserToken token = new UserToken(existingUser);

                if (EmailHandler.sendEmail(email, "otp after login", token.getTokenValue())) {
                    tokenService.createToken(token);
                    return "check email for otp/token!!!";
                } else {
                    return "error while generating token!!!";
                }

            } else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }


        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }

    }


    public String addToPlaylist(String email, String tokenValue, Playlist playlist) {
        if (tokenService.authenticate(email, tokenValue)) {

            playlistService.addToPlaylist(playlist);


        } else {
            return "Un Authenticated access!!!";
        }
        return email;
    }
}
