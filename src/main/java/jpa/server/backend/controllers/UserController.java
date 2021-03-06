package jpa.server.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.User;
import jpa.server.backend.services.UserService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class UserController {

  @Autowired
  private UserService userService;

  @DeleteMapping("/api/users/{userId}")
  public int deleteUser(@PathVariable int userId) {
    return this.userService.deleteUser(userId);
  }

  @GetMapping("/api/users")
  public List<User> findAllUsers() {
    return userService.findAllUsers();
  }

  @GetMapping("/api/users/{userId:[0-9]+}")
  public User findUserById(@PathVariable int userId) {
    return userService.findUserById(userId);
  }

  @PostMapping("/api/users")
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PutMapping("api/users/{userId}")
  public User updateUser(@RequestBody User user, @PathVariable Integer userId) {
    return userService.updateUser(user, userId);
  }

  @GetMapping("/api/users/{userId}/userMembershipGroups")
  public List<GameGroup> getUserMembershipGroups(@PathVariable("userId") Integer userId) {
    return userService.getUserMembershipGroups(userId);
  }

  @GetMapping("/api/users/{userId}/userAdminGroups")
  public List<GameGroup> getUserAdminGroups(@PathVariable("userId") Integer userId) {
    return userService.getUserAdminGroups(userId);
  }

  @GetMapping("/api/users/{username:[a-zA-z]+}")
  public User findUserByUsername(@PathVariable String username) {return userService.findUserByUsername(username); }
}
