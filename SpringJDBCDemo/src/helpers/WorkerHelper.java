package helpers;

import java.util.List;
import models.Worker;

public class WorkerHelper {
	public static void printAllWorkers(List<Worker> workers) {
		for(Worker w: workers) {
			System.out.println("Worker ID: " + w.getWorkerId());
			System.out.println("FirstName: " + w.getFirstName());
			System.out.println("LastName: " + w.getLastName());
			System.out.println("Salary: " + w.getSalary());
			System.out.println("Joining Date: " + w.getJoiningDate());
			System.out.println("Department: " + w.getDepartment());
			System.out.println("Email: " + w.getEmail());
			System.out.println();
		}
	}
}
