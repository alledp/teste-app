package br.com.mobguide.controller;

import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CrudService<UserModel> service;

    @GetMapping("/detail/{id}")
    public String getUserDetail(@PathVariable("id") final int id, final Model model){
        final UserModel userModel = service.readById(id);

        model.addAttribute("usuario", userModel);

        return "user/detail";
    }

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

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") final int id, final Model model){
        final UserModel userModel = service.readById(id);

        model.addAttribute("usuario", userModel);

        return "user/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") final int id, final Model model){
        final boolean response = service.deleteById(id);

        return getUserPage(model);
    }

    @GetMapping("/edit")
    public String getEditPage(){
        return "user/edit";
    }

    @PostMapping("/sign-up")
    public String signUP(final Model model, final UserModel user){


        service.create(user);

        return getUserPage(model);

    }

    @PostMapping("/update")
    public String update(final UserModel user, final Model model){

        boolean response = service.updateById(user.getId(),user);

        return getUserDetail(user.getId(),model);

    }
}
