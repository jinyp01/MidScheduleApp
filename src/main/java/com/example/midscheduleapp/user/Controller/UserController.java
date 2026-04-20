package com.example.midscheduleapp.user.Controller;

import com.example.midscheduleapp.user.Dto.*;
import com.example.midscheduleapp.user.Service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("users")
    ResponseEntity<CreateUserResponse> createUser( @RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponse> loginUser(
            @RequestBody LoginRequest request,
            HttpSession session){
        session.setAttribute("loginUser", userService.login(request));
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(request));
    }


    @GetMapping("users")
    ResponseEntity<List<GetUserResponse>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @GetMapping("users/{userId}")
    ResponseEntity<GetUserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
    }

    @PutMapping("users/{userId}")
    ResponseEntity<UpdateUserResponse> updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest request
            ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, request));
    }


    @DeleteMapping("users/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
