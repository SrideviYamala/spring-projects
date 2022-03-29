package services;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import mappers.WorkerMapper;
import models.Worker;
public class WorkerJDBCTemplate {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(int workerId, String firstName, String lastName, int salary, Date joiningDate, String department,
            String email) {
		String sql = "insert into worker values(?,?,?,?,?,?,?)";
		
		jdbcTemplateObject.update(sql, workerId,firstName,lastName,salary,joiningDate,department,email);
		
		System.out.println("Worker " + firstName + "'s record inserted successfully");
		return;
	}
	
	public Worker getStudentById(Integer worker_id) {
		String sql = "SELECT * FROM worker WHERE worker_id = ?";
		Worker worker = jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {worker_id}, 
				new WorkerMapper()
				);
		
		return worker;
	}
	
	public List<Worker> getAllStudents() {
		String sql = "SELECT * FROM worker";
		List<Worker> students = jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
		
		return students;
	}
	
	public void update(Integer worker_id, String department) {
		String sql = "UPDATE worker SET department = ? WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, department, worker_id);
		System.out.println("Record #" + worker_id + "'s department updated to " + department);
		return;
	}
	
	public void delete(Integer worker_id) {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, worker_id);
		System.out.println("Record #" + worker_id + " deleted");
		return;
	}
}
