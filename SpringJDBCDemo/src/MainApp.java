import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import helpers.WorkerHelper;
import models.Worker;
import services.WorkerJDBCTemplate;
public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		WorkerJDBCTemplate workerJDBCTemplate = (WorkerJDBCTemplate) context.getBean("workerJDBCTemplate");
		
		System.out.println("Records Creation: \n");
		workerJDBCTemplate.create(10, "Aiswarya", "Seepana", 30000, Date.valueOf("2022-03-21"), "Account",
                "a.seepana@my_org.in");
		System.out.println();
		
		System.out.println("Displaying All Worker Records: \n");
		List<Worker> workers = workerJDBCTemplate.getAllStudents(); 
		WorkerHelper.printAllWorkers(workers);
		
		workerJDBCTemplate.delete(10);
		System.out.println();
		
		workerJDBCTemplate.update(9,"HR");
		
		System.out.println("Displaying Worker Record By Specific ID: \n");
		Worker worker = workerJDBCTemplate.getStudentById(9); 
		System.out.println(worker);
		System.out.println();
	}

}
