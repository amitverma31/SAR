package com.readandstore.logs.controller;

import com.readandstore.logs.entity.FileDTO;
import com.readandstore.logs.entity.LogData;
import com.readandstore.logs.service.ReadAndStoreFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/storelog")
public class LogDataController {

    @Autowired
    private ReadAndStoreFileService readAndStoreFileService;

    @PostMapping("/file")
    public String readFile(@RequestBody FileDTO fileDTO) {
        return readAndStoreFileService.readFile(fileDTO.getFilename());
    }

    @GetMapping("/")
    public List<LogData> list(){
        return readAndStoreFileService.listAllLog();
    }

    @GetMapping("/showLogInfo")
    List<LogData> findByLogInfo(@RequestParam("desc") String desc){
        return readAndStoreFileService.findByLogInfo(desc);
    }
}





