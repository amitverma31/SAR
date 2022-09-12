package com.readandstore.logs.service;

import com.readandstore.logs.entity.LogData;
import com.readandstore.logs.repository.LogDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ReadAndStoreFileService {

    @Autowired
    LogDataRepository logDataRepository;

    public String readFile(List<String> fileNames) {
        fileNames.forEach(fileName -> {
            List<String> lines = Collections.emptyList();
            List<LogData> logDataList = new ArrayList<>();
            try {
                lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
                Iterator<String> itr = lines.iterator();
                while(itr.hasNext()) {
                    LogData logdata = new LogData();
                    logdata.setLogDesc(itr.next());
                    logdata.setCreatedDate(new Date());
                    logDataList.add(logdata);
                }
                if (!CollectionUtils.isEmpty(logDataList)) {
                    logDataRepository.saveAll(logDataList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return "success";
    }

    public List<LogData> listAllLog() {
        return logDataRepository.findAll();
    }

    public List<LogData> findByLogInfo(String desc){
        var findLog=(List<LogData>) logDataRepository.findByLogInfo(desc);
        return findLog;
    }
}
