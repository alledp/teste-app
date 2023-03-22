package br.com.mobguide.controller;

import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CrudService<UserModel> service;

    @GetMapping("/list")
    public String getUserPage(final Model model){

        List<UserModel> users = service.read();

        if (users == null){
            model.addAttribute("usuarios", new ArrayList<>());
        }else {
            model.addAttribute("usuarios", users);
        }


        return "user/list";
    }

    @GetMapping("/create")
    public String getCreatePage(){
        return "user/create";
    }

    @GetMapping("/edit")
    public String getEditPage(){
        return "user/edit";
    }
}
