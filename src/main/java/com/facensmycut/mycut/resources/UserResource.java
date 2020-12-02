package com.facensmycut.mycut.resources;

import com.facensmycut.mycut.entities.Login;
import com.facensmycut.mycut.entities.User;
import com.facensmycut.mycut.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices services;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = services.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = services.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/mail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        User user = services.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody Login obj) {
        User user = services.findByEmail(obj.getEmail());
        if(user.getPassword().contentEquals(obj.getPassword())) {
            user.setPassword("");
            return ResponseEntity.ok().body(user);
        }

        user.setPassword("");
        user.setPhone("");
        user.setName("error");
        user.setEmail("error");

        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
