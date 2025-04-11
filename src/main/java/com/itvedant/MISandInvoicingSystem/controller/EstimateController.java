package com.itvedant.MISandInvoicingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.MISandInvoicingSystem.dao.AddEstimateDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateEstimateDAO;
import com.itvedant.MISandInvoicingSystem.service.EstimateService;

@RestController
@RequestMapping("/estimates")
public class EstimateController {

	
	@Autowired
	private EstimateService service;
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AddEstimateDAO addEstimateDAO) {
		
		return ResponseEntity.ok(this.service.create(addEstimateDAO));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByid(@PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		
		
		return ResponseEntity.ok(this.service.getAll());
	}
	
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UpdateEstimateDAO updateEstimateDAO, @PathVariable Integer id) {
		
		
		return ResponseEntity.ok(this.service.update(updateEstimateDAO, id));
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		return ResponseEntity.ok(this.service.delete(id));
	}
}
