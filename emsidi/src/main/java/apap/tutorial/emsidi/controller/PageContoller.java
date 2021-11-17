package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class PageContoller {

    @RequestMapping("/")
    public String home(@ModelAttribute UserModel user, Model model){
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
