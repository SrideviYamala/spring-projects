package com.springboot.my.org.crudapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.model.Bonus;
import com.springboot.my.org.crudapi.service.BonusService;

@RestController
public class BonusController {
	@Autowired
	BonusService bonusService;
	
	@GetMapping("/worker/bonus/{id}")
	public List<Bonus> showWorkerBonus(@PathVariable int id) {
		return bonusService.getWorkerWithBonus(id);
	}
	
	@GetMapping("/dept/{dept}/bonuses")
	public List<Bonus> showAllDeptBonus(@PathVariable String dept) {
		return bonusService.getBonusByDept(dept);
	}

	@PostMapping("/worker/{id}/bonus/new")
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@PathVariable int id,@RequestBody Bonus bonus) {
		return bonusService.createBonus(id,bonus);	
	}
	
	@DeleteMapping("/worker/{id}/bonus/latest")
	public boolean delete(@PathVariable int id) {
		return bonusService.deleteBonus(id);
	}
}
