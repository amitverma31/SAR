package com.demo.department.service;

import com.demo.department.entity.DepartmentEntity;
import com.demo.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentEntity> listAllDepartment(){
        log.info("service for list the all departments.");
        return departmentRepository.findAll();
    }

    public  void saveDepartment(DepartmentEntity departmentEntity){
        log.info("service for save departments.");
        departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartment(Long departmentId){
        log.info("service for get departments.");
        return departmentRepository.findById(departmentId).get();
    }

    public DepartmentEntity deleteDepartment(Long departmentId){
        log.info("service for delete departments.");
        departmentRepository.deleteById(departmentId);
        return  null;
    }
}
