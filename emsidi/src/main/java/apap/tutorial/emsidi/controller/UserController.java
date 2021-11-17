package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import apap.tutorial.emsidi.model.RoleModel;


import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value="/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAllRole();
        model.addAttribute("user",user);
        model.addAttribute("listRole",listRole);
        return "form-add-user";

    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping(value = "/viewall")
    public String listSemuaUser(Model model){
        List<UserModel> listUser = userService.findAllUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value = "/delete/{username}")
    public String deleteUser(@PathVariable String username,@ModelAttribute UserModel Objuser,Model model){
        UserModel user = userService.findByUsername(username);
        String deleteUser = userService.deleteUser(user);

        if(deleteUser.equalsIgnoreCase("berhasil")){
            model.addAttribute("msg","Berhasil delete User");
        }
        else{
            model.addAttribute("msg", "Gagal untuk mendelete User");
        }
        return "delete-user";
    }

    @GetMapping("/updatePassword/{username}")
    private String changePasswordForm(@PathVariable String username) {
        UserModel myUser = userService.findByUsername(username);

        return "update-password";
    }

    @PostMapping("/updatePassword")
    private String changePasswordFormSubmit(
            @ModelAttribute UserModel user,
            String newPassword,
            String confirmPass,
            Model model
    ) {
        UserModel myUser = userService.findByUsername(user.getUsername());
        String msg = "";
        if (userService.passwordEqual(user.getPassword(), myUser.getPassword())){
            if (newPassword.equals(confirmPass)){
                userService.setPassword(myUser, newPassword);
                userService.addUser(myUser);
                msg += "Password berhasil terupdate";
            }
            else {
                msg += "Password baru dan Konfirmasi Password tidak sama";
            }
        }
        else {
            msg += "Password yang anda masukan salah";
        }
        model.addAttribute("msg", msg);
        model.addAttribute("username", user.getUsername());
        return "password-changed";
    }
}
