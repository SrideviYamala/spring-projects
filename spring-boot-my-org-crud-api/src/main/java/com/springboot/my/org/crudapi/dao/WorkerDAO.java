package com.springboot.my.org.crudapi.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.springboot.my.org.crudapi.model.Worker;

public interface WorkerDAO {
    public int add(Worker worker)
            throws SQLException;

    public boolean delete(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public boolean update(int id,String email)
            throws SQLException;
    
    public List<Map<String,String>> getAllDetails() throws SQLException;
    
    public List<Map<String,String>> getAllDetailsByDept(String dept) throws SQLException;
}
