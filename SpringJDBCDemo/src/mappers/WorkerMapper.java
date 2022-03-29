package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import models.Worker;

public class WorkerMapper implements RowMapper<Worker>{
	public Worker mapRow(ResultSet res,int rowNum) throws SQLException{
		Worker worker=new Worker();
		worker.setWorkerId(res.getInt("worker_id"));
		worker.setFirstName(res.getString("first_name"));
		worker.setLastName(res.getString("last_name"));
		worker.setSalary(res.getInt("salary"));
		worker.setJoiningDate(res.getDate("joining_date"));
		worker.setDepartment(res.getString("department"));
		worker.setEmail(res.getString("email"));
		return worker;
	}
}
