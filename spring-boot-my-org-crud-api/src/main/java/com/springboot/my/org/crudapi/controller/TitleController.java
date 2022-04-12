package com.springboot.my.org.crudapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.service.TitleService;

@RestController
public class TitleController {
	@Autowired
	TitleService titleService;
	@GetMapping("/worker/title/{id}")
	public List<Title> showWorkerTitle(@PathVariable int id)  {

			return titleService.getWorkerTitle(id);
	}
	
	@GetMapping("/dept/{dept}/all")
	public List<Title> showAllTitleInDept(@PathVariable String dept) {
			return titleService. getAllWorkerTitleInDept(dept);

	}

	@PostMapping("/worker/{id}/promote/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean create(@PathVariable int id, @PathVariable String title) {
		return titleService.createTitle(id, title);	
	}

	@DeleteMapping("/worker/{id}/demote")
	public boolean deleteTitle(@PathVariable int id) {
			return titleService.deleteTitle(id);
}
}
