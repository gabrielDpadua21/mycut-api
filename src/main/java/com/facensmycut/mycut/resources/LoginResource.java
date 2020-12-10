package com.facensmycut.mycut.resources;

import com.facensmycut.mycut.DTO.UserDTO;
import com.facensmycut.mycut.entities.Login;
import com.facensmycut.mycut.entities.User;
import com.facensmycut.mycut.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginResource {

    @Autowired
    private LoginService services;

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody Login obj) {
        User user = services.LoginAuthentication(obj.getEmail(), obj.getPassword());
        UserDTO userDto = new UserDTO(user);
        return ResponseEntity.ok().body(userDto);
    }

}
