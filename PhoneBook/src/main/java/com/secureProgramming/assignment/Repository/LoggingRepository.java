package com.secureProgramming.assignment.Repository;

import com.secureProgramming.assignment.Model.LogsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggingRepository extends JpaRepository<LogsModel,Integer> {
    @Query(value = "select max(a.id) from LogsModel a")
    public Integer findMaxId();

    @Query(value = "select a from LogsModel a")
    public List<LogsModel> getAllLogs();

}
