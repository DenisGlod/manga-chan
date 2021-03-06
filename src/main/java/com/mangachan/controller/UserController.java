package com.mangachan.controller;

import com.mangachan.service.UserService;
import com.mangachan.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/users", produces = {"application/json;charset=UTF-8"})
@ResponseBody
public class UserController {
    private final UserService service;

    @GetMapping("/getAll")
    public List<UserDto> getAllUsers() {
        return service.getAllUser();
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUserById(@RequestParam(name = "id") Long id) {
        Optional<UserDto> optionalUserBean = service.findUserById(id);
        if (optionalUserBean.isPresent()) {
            return ResponseEntity
                    .ok(optionalUserBean.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Пользователь с id " + id + " не найден");
        }
    }

    @PostMapping("/add")
    public UserDto saveOrUpdateUser(@RequestBody UserDto userDto) {
        return service.save(userDto);
    }

    @PostMapping(path = "/login", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<?> findUserByEmailAndPassword(@RequestParam(name = "email") String email,
                                                        @RequestParam(name = "password") String password) {
        Optional<UserDto> optionalUserBean = service.login(email, password);
        if (optionalUserBean.isPresent()) {
            return ResponseEntity
                    .ok(optionalUserBean.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Пользователь не найден");
        }
    }

}
