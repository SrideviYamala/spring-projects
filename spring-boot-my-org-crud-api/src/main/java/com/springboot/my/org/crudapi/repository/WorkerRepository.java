package com.springboot.my.org.crudapi.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.WorkerDAO;
import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.util.DatabaseConnection;

@Repository
public class WorkerRepository implements WorkerDAO {
    private final Connection conn;
    public WorkerRepository() throws SQLException, ClassNotFoundException {
        this.conn = DatabaseConnection.getConnection();
    }

    @Override
    public int add(Worker worker) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into worker values(?,?,?,?,?,?,?)");
        ps.setInt(1, worker.getWorkerId());
        ps.setString(2, worker.getFirstName());
        ps.setString(3, worker.getLastName());
        ps.setInt(4, worker.getSalary());
        ps.setDate(5, worker.getJoiningDate());
        ps.setString(6, worker.getDepartment());
        ps.setString(7, worker.getEmail());
        return ps.executeUpdate();
    }

    @Override
    public boolean delete(int workerId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from worker where worker_id=?");
        ps.setInt(1, workerId);
        int rowsDeleted = ps.executeUpdate();
        System.out.println("Rows deleted: " + rowsDeleted);
        return rowsDeleted==1;
    }

    @Override
    public Worker getWorker(int workerId) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from worker where worker_id=?");
        ps.setInt(1, workerId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6),
                rs.getString(7));
    }

    @Override
    public List<Worker> getWorkers() throws SQLException {
        List<Worker> workersList = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from worker");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            workersList.add(new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
        return workersList;
    }
    
    @Override
    public boolean update(int id,String email) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "update worker SET email = ? WHERE worker_id = ?");
        ps.setString(1, email);
        ps.setInt(2, id);
        int rowsUpdated = ps.executeUpdate();
        System.out.println(rowsUpdated + " row updated");
        return rowsUpdated==1;
    }
    
    public List<Map<String,String>> getAllDetails() throws SQLException {
    	String sql = """
    			select * from 
    			(select * from worker inner join title on worker_id = worker_ref_id) joined left join bonus 
    			on joined.worker_id = bonus.worker_ref_id
    			""";
    	
    	Statement state = conn.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	List<Map<String,String>> ls = new ArrayList<>();
    	while (res.next()) {
    		Map<String,String> map = new HashMap<>();
    		map.put("workerId", ""+res.getInt("worker_id"));
    		map.put("firstName", res.getString("first_name"));
    		map.put("lastName", res.getString("last_name"));
    		map.put("salary",""+res.getInt("salary"));
    		map.put("joiningDate", res.getDate("joining_date")+"");
    		map.put("dept", res.getString("department"));
    		map.put("email", res.getString("email"));
    		map.put("workerTitle", res.getString("worker_title"));
    		map.put("affectedFrom",res.getDate("affected_from")+"");
    		map.put("bonusAmount", res.getInt("bonus_amount")+"");
    		map.put("bonusDate", res.getDate("bonus_date")+"");
    		System.out.println(map);
    		ls.add(map);
    		System.out.println(ls);
    	}
    	return ls;
    }
    
    public List<Map<String,String>> getAllDetailsByDept(String dept) throws SQLException{
    	String sql = String.format("""
    			select * from 
    			(select * from worker inner join title on worker_id = worker_ref_id
    			where department = "%s") joined left join bonus 
    			on joined.worker_id = bonus.worker_ref_id
    			""",dept);
    	
    	Statement state = conn.createStatement();
    	ResultSet res = state.executeQuery(sql);
    	List<Map<String,String>> ls = new ArrayList<>();
    	while (res.next()) {
    		Map<String,String> map = new HashMap<>();
    		map.put("workerId", ""+res.getInt("worker_id"));
    		map.put("firstName", res.getString("first_name"));
    		map.put("lastName", res.getString("last_name"));
    		map.put("salary",""+res.getInt("salary"));
    		map.put("joiningDate", res.getDate("joining_date")+"");
    		map.put("dept", res.getString("department"));
    		map.put("email", res.getString("email"));
    		map.put("workerTitle", res.getString("worker_title"));
    		map.put("affectedFrom",res.getDate("affected_from")+"");
    		map.put("bonusAmount", res.getInt("bonus_amount")+"");
    		map.put("bonusDate", res.getDate("bonus_date")+"");
    		System.out.println(map);
    		ls.add(map);
    	}
    	return ls;
    }
}

