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

import com.itvedant.MISandInvoicingSystem.dao.AddBrandDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateBrandDAO;
import com.itvedant.MISandInvoicingSystem.service.BrandService;

@RestController
@RequestMapping("/brands")
public class BrandController {

	
	@Autowired
	private BrandService service;
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AddBrandDAO addBrandDAO) {
		
		return ResponseEntity.ok(this.service.create(addBrandDAO));
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		
		
		return ResponseEntity.ok(this.service.GetAll());
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UpdateBrandDAO updateBrandDAO, @PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.update(updateBrandDAO, id));
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.delete(id));
	}
	
}
