package br.com.mobguide.controller;


import br.com.mobguide.model.entities.Game;
import br.com.mobguide.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*")
public class GameServiceController {

    @Autowired
    private CrudService<Game> service;

    @GetMapping("/find/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") final int id){
        Game game_var = service.readById(id);

        if(game_var == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(game_var);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Game>> getGames() {
        List<Game> list = service.read();

        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final int id){

        boolean response = service.deleteById(id);

        if(!response){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@RequestBody final Game game_var){

        int response = service.create(game_var);

        if(response == -1){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") final int id,
                                          @RequestBody() final Game game_update) {

        boolean response = service.updateById(id, game_update);

        if(!response){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }


}
