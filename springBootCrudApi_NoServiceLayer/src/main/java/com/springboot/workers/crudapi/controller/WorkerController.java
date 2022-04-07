package com.springboot.workers.crudapi.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	WorkerRepository workerRepository;
	
	@GetMapping("/worker/{id}")
	public Worker getWorker(@PathVariable int id) {
		try {
			return workerRepository.getWorker(id);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		}
	
	@GetMapping("/all")
	public List<Worker> showAllWorkers(){
		try {
			return workerRepository.getWorkers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody Worker worker){
		try {
			workerRepository.add(worker);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return worker.getFirstName()+" Record Added Successfully";
		}
	
	@PatchMapping("/update/{id}")
	public boolean update(@PathVariable int id,@RequestBody Map<String,String>requestBody ){
		boolean rowsAffected=false;
		try {
			rowsAffected = this.workerRepository.update(id,requestBody.get("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;				
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id){
		boolean rowsAffected=false;
		try {
			rowsAffected = this.workerRepository.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;		
	}

}
