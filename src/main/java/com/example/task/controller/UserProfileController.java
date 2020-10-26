package com.example.task.controller;

import com.example.task.entity.User;
import com.example.task.pojo.UserBean;
import com.example.task.repository.UserRepository;
import com.example.task.service.UserProfileService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserRepository userRepository;

    @ApiResponses({
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 200, message = "User found")
    })
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable final int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity(userRepository.findById(id).get(), HttpStatus.FOUND);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

   @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserBean userBean) {
        System.out.println("******" + userBean.getFirstName());
        return ResponseEntity.ok(userProfileService.addUser(userBean));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity updateUser(@RequestBody UserBean userBean) {
        System.out.println("******" + userBean.getFirstName());
        return ResponseEntity.ok(userProfileService.addUser(userBean));
    }
}
