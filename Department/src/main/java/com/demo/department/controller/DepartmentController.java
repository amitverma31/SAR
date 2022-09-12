package com.demo.department.controller;

import com.demo.department.entity.DepartmentEntity;
import com.demo.department.service.DepartmentService;
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
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping(" ")
    public List<DepartmentEntity> list() {
        log.info("List of all departments using getmapping.");
        return departmentService.listAllDepartment();
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentEntity> get(@PathVariable Long departmentId) {
        try {
            DepartmentEntity departmentEntity = departmentService.getDepartment(departmentId);
            log.info("get departments details by id using getmapping by ID");
            return new ResponseEntity<DepartmentEntity>(departmentEntity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            log.info("get department by id  has failed");
            return new ResponseEntity<DepartmentEntity>(HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody DepartmentEntity departmentEntity) {
        log.info("post departments details using post mapping.");
        departmentService.saveDepartment(departmentEntity);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<?> update(@RequestBody DepartmentEntity departmentEntity, @PathVariable Long departmentId) {
        try {
            DepartmentEntity existDepartmentEntity = departmentService.getDepartment(departmentId);
            departmentEntity.setDepartmentId(departmentId);
            departmentService.saveDepartment(departmentEntity);
            log.info("update departmentEntity by id using putmapping");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            log.info("update departmentEntity by id has failed");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<DepartmentEntity> deleteDepartment(@PathVariable Long departmentId) {
        try {
            DepartmentEntity departmentEntity = departmentService.deleteDepartment(departmentId);
            log.info("delete departmentEntity by id using deletemapping.");
            return new ResponseEntity<DepartmentEntity>(departmentEntity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            log.info("delete department by id failed");
            return new ResponseEntity<DepartmentEntity>(HttpStatus.OK);
        }
    }
}
