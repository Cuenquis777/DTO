package com.example.demo.presentation.controller;

import com.example.demo.presentation.dto.UserDTO;
import com.example.demo.service.interfeces.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //Injecting the service
    @Autowired
    private IUserService userService;

    //Find all
    @GetMapping("/find")
    public ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    //Find by ID
    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findAll(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    // Create user
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(this.userService.createUser(userDTO), HttpStatus.CREATED);
    }

    // Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        return new ResponseEntity<>(this.userService.updateUser(userDTO, id), HttpStatus.OK);
    }

    //Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}

