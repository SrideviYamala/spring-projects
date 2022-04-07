package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	WorkerRepository workerRepository;
	
	public Worker dispWorkerById(int id) {
		try {
			return workerRepository.getWorker(id);
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
	public List<Worker> dispAllWorkers(){
		try {
			return workerRepository.getWorkers();
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
	public String create(Worker worker){
		try {
			workerRepository.add(worker);
			return worker.getFirstName()+" Record Added Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		}
	public boolean update(int id,String email){
		try {
			workerRepository.update(id,email);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(int id){
		try {
			workerRepository.delete(id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
