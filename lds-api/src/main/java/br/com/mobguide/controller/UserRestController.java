package br.com.mobguide.controller;

import br.com.mobguide.model.entities.UserModel;
import br.com.mobguide.service.CrudService;
import br.com.mobguide.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class    UserRestController {

    private CrudService<UserModel> service = new UserServiceImpl();

    @GetMapping("/find/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") final int id){
        UserModel user = service.readById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/find")
    public ResponseEntity<List<UserModel>> getUsers() {
        List<UserModel> list = Arrays.asList(new UserModel());
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") final int id){
        return ResponseEntity.ok(true);
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> create(@RequestBody final UserModel user){
        return ResponseEntity.ok(1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@PathVariable("id") final int id,
                                          @RequestBody() final UserModel user) {
        return ResponseEntity.ok(true);
    }


}
