package com.codewithtanya.blog.controllers;

import com.codewithtanya.blog.payloads.ApiResponse;
import com.codewithtanya.blog.payloads.UserDto;
import com.codewithtanya.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
@Autowired
    private UserService userService;

@PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
  UserDto createdUser = userService.createUser(userDto);
  return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
}
@GetMapping("/{id}")
    public ResponseEntity<UserDto> getSingleUserById(@PathVariable("id") Integer userId){
    UserDto getUser=userService.getUserById(userId);
    return new ResponseEntity<>(getUser,HttpStatus.OK);
}

@PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("id") Integer uid){
    UserDto updatedUser=userService.updateUser(userDto,uid);
    return new ResponseEntity<>(updatedUser,HttpStatus.OK);
}

@GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
    List<UserDto> allUser=userService.getAllUser();
    return new ResponseEntity<>(allUser,HttpStatus.OK);
}
@DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Integer uid){
    userService.deleteUser(uid);
return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);

}
}
