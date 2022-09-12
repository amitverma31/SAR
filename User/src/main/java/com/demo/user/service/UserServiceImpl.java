package com.demo.user.service;

import com.demo.user.valueobject.Department;
import com.demo.user.valueobject.ResponseTemplateValueObject;
import com.demo.user.entity.UserEntity;
import com.demo.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<UserEntity> listOfUser() {
        log.info("service for list of user.");
        return userRepository.findAll();
    }

    public void saveUser(UserEntity userEntity) {
        log.info("service for save userEntity.");
        userRepository.save(userEntity);
    }

    public UserEntity getUser(Long userId) {
        log.info("service for get user.");
        return userRepository.findById(userId).get();
    }

    public UserEntity deleteUser(Long userId) {
        userRepository.deleteById(userId);
        log.info("service for delete user.");
        return null;
    }

    public ResponseTemplateValueObject getUserWithDepartment(Long userId) {
        log.info("Rest template for getting the userEntity with department");
        ResponseTemplateValueObject vo=new ResponseTemplateValueObject();
        UserEntity userEntity = userRepository.findByUserId(userId);
        //call the department from here
        Department department=
                restTemplate.getForObject("http://localhost:8081/department/"+ userEntity.getDepartmentId()
                        ,Department.class);
        //set userEntity and dep in VO
        vo.setUserEntity(userEntity);
        vo.setDepartment(department);
        return vo;
    }
}
