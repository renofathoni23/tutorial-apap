package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;

import java.util.List;


public interface UserService {

    UserModel addUser(UserModel user);
    public String encrypt (String password);
    List<UserModel> findAllUser();
    String deleteUser (UserModel user);
    UserModel findByUsername(String username);
    boolean passwordEqual(String userPassword, String formPassword);
    void setPassword(UserModel user, String newPassword);
}
