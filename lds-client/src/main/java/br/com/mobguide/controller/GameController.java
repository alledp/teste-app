package br.com.mobguide.controller;

import br.com.mobguide.model.entities.Game;
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
@RequestMapping("/game")
public class GameController {

    @Autowired
    private CrudService<Game> service;

    @GetMapping("/detail/{id}")
    public String getGameDetail(@PathVariable("id") final int id, final Model model){
        final Game game_var = service.readById(id);

        model.addAttribute("game", game_var);

        return "game/detail";
    }

    @GetMapping("/list")
    public String getGamePage(final Model model){

        List<Game> games = service.read();

        if (games == null){
            model.addAttribute("games", new ArrayList<>());
        }else {
            model.addAttribute("games", games);
        }

        return "game/list";
    }

    @GetMapping("/create")
    public String getCreatePage(){
        return "game/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable("id") final int id, final Model model){
        final boolean response = service.deleteById(id);

        return getGamePage(model);
    }

    @GetMapping("/edit")
    public String getEditPage(){
        return "game/edit";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") final int id, final Model model){
        final Game game_var = service.readById(id);

        model.addAttribute("game", game_var);

        return "game/edit";
    }

    @PostMapping("/sign-up")
    public String signUP(final Model model, final Game game_var){


        service.create(game_var);

        return getGamePage(model);

    }

    @PostMapping("/update")
    public String update(final Game game_var, final Model model){

        boolean response = service.updateById(game_var.getId(),game_var);

        return getGameDetail(game_var.getId(),model);

    }

}
