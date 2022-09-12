package com.demo.user.valueobject;

import com.demo.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateValueObject {
    private UserEntity userEntity;
    private Department department;
}
