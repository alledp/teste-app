package br.com.mobguide.controller;

import br.com.mobguide.model.entities.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class    UserRestController {

    @GetMapping("/find/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") final int id){
        return ResponseEntity.ok(new UserModel());
    }

    @GetMapping("/find")
    public ResponseEntity<List<UserModel>> getUsers() {
        List<UserModel> list = Arrays.asList(new UserModel());
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final int id){
        return ResponseEntity.ok(body: true);
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@RequestBody final UserModel user){
        return ResponseEntity.ok(body: 1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") final int id,
                                          @RequestBody()) {
        return ResponseEntity.ok(body: true);
    }


}
