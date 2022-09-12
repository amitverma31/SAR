package com.demo.user.service;

import com.demo.user.entity.UserEntity;
import com.demo.user.valueobject.ResponseTemplateValueObject;
import java.util.List;

public interface UserService {
    public List<UserEntity> listOfUser();
    public void saveUser(UserEntity userEntity);
    public UserEntity getUser(Long userId);
    public UserEntity deleteUser(Long userId);
    public ResponseTemplateValueObject getUserWithDepartment(Long userId);
}
