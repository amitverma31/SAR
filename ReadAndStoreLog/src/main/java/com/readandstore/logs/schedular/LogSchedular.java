package com.readandstore.logs.schedular;

import com.readandstore.logs.service.ReadAndStoreFileService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class LogSchedular {
    Logger logger = LoggerFactory.getLogger(LogSchedular.class);

    @Autowired
    ReadAndStoreFileService readAndStoreFileService;

    @Scheduled(cron = "0 */15 * * * ?")
    public void runLogFile(){
        log.info("corn job expression for logfile:{}",new Date());
        List<String> fileNames=new ArrayList<>();
        fileNames.add("C:\\Users\\averma50\\Downloads\\SAR\\Department\\logs\\debug.log");
        fileNames.add("C:\\Users\\averma50\\Downloads\\SAR\\Department\\logs\\error.log");
        readAndStoreFileService.readFile(fileNames);
    }
}
