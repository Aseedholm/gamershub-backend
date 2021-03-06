package jpa.server.backend.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import jpa.server.backend.models.GameGroup;
import jpa.server.backend.models.User;

public interface UserDao {
  //create user
  User createUser(User user);

  //Get a list of game groups where user is a member of
  List<GameGroup> getUserMembershipGroups(Integer userId);

  //Get a list of game groups where user is the admin of
  List<GameGroup> getUserAdminGroups(Integer userId);


  //find user by id
  User findUserById(Integer userId);

  //find all users
  List<User> findAllUsers();

  int deleteUser(Integer userId);

  User updateUser(User user, Integer userId);

  User findUserByUsername(String username);

}
