package com.demo.user.cotroller;

import com.demo.user.entity.UserEntity;
import com.demo.user.valueobject.ResponseTemplateValueObject;
import com.demo.user.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("")
    public List<UserEntity> list(){
        log.info("get the all user details.");
        return userServiceImpl.listOfUser();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> get(@PathVariable Long userId){
        try {
            UserEntity userEntity = userServiceImpl.getUser(userId);
            log.info("get the userEntity details with ID");
            return  new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
        } catch (NoSuchElementException e){
            log.info("getting error for get user by ID.");
            return new ResponseEntity<UserEntity>(HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public  void add (@RequestBody UserEntity userEntity){
        log.info("post the userEntity details.");
        userServiceImpl.saveUser(userEntity);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update (@RequestBody UserEntity userEntity, @PathVariable Long userId){
        try {
            UserEntity existUserEntity = userServiceImpl.getUser(userId);
            userEntity.setUserId(userId);
            userServiceImpl.saveUser(userEntity);
            log.info("update the userEntity details by id.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            log.info("getting error in update the userEntity details by id.");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Long userId){
        try{
            UserEntity userEntity = userServiceImpl.deleteUser(userId);
            log.info("delete the userEntity details");
            return new ResponseEntity<UserEntity>(userEntity,HttpStatus.OK);
        } catch (NoSuchElementException e){
            log.info("getting error in delete the user.");
            return new ResponseEntity<UserEntity>(HttpStatus.OK);
        }
    }

    // get the details with user and department
    @GetMapping("/vo/{id}")
    public ResponseTemplateValueObject getUserWithDepartment(@PathVariable ("id") Long userId){
        log.info("get the user with department.");
        return  userServiceImpl.getUserWithDepartment(userId);
    }
}
