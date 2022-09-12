package com.readandstore.logs.repository;

import com.readandstore.logs.entity.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LogDataRepository extends JpaRepository<LogData, Integer> {
    @Query(value = "SELECT logs FROM LogData logs WHERE logs.logDesc LIKE %:desc%")
    List<LogData> findByLogInfo(@Param("desc") String desc);
}
