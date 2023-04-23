package com.konrad_szydlowski.demo.user.controller;

import com.konrad_szydlowski.demo.user.exception.UserException;
import com.konrad_szydlowski.demo.user.model.UserDto;
import com.konrad_szydlowski.demo.user.repository.table.User;
import com.konrad_szydlowski.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    final UserService userService;
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(value = "id")Long userId) {
        return userService.findUserById(userId);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUserById(@PathVariable(value = "id")Long userId) throws UserException {
        return userService.deleteUserById(userId);
    }
}
