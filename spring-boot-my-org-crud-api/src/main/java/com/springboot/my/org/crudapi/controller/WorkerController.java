package com.springboot.my.org.crudapi.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.service.WorkerService;

@RestController
public class WorkerController {
	
	@Autowired
	WorkerService workerService;
	
	@GetMapping("/worker/worker/{id}")
	public Worker showWorker(@PathVariable int id) {
		return workerService.dispWorkerById(id);
	}
	
	@GetMapping("/worker/all")
	public List<Worker> showAllWorkers() {
		return workerService.dispAllWorkers();
	}
	
	@PostMapping("/worker/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody Worker worker) {
		return workerService.create(worker);	
	}
	
	@PatchMapping("/worker/update/{id}")
	public boolean update(@PathVariable int id,@RequestBody Map<String,String> requestBody) {
		return workerService.update(id,requestBody.get("email"));
	}
	
	@DeleteMapping("/worker/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return workerService.delete(id);
	}
	
	@GetMapping("/worker/all/fullInfo")
	public List<Map<String,String>> getFullInfo(){
		return workerService.getAllDetails();
	}
	
	@GetMapping("/dept/{dept}/all/fullInfo")
	public List<Map<String,String>> getFullDeptInfo(@PathVariable String dept){
		return workerService.getAllDetailsByDept(dept);
	}
}
