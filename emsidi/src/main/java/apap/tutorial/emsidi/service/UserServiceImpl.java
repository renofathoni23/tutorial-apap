package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import apap.tutorial.emsidi.model.UserModel;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt (String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> findAllUser(){
        return userDb.findAll();
    }

    @Override
    public UserModel findByUsername(String username){
        return userDb.findByUsername(username);
    }

    @Override
    public String deleteUser (UserModel user){
        userDb.delete(user);
        return "berhasil";
    }

    @Override
    public boolean passwordEqual(String userPassword, String formPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(userPassword,formPassword);
    }

    @Override
    public void setPassword(UserModel user, String newPassword){
        user.setPassword(newPassword);
    }


}
