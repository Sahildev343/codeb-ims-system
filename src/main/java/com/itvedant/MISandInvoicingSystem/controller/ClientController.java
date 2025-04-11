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

import com.itvedant.MISandInvoicingSystem.dao.AddClientDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateClientDAO;
import com.itvedant.MISandInvoicingSystem.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	
	
	
	
	@Autowired
	private ClientService service;
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AddClientDAO addClientDAO) {
		
		
		return ResponseEntity.ok(this.service.create(addClientDAO));
	}
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		
		
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		
		
		return ResponseEntity.ok(this.service.getAll());
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UpdateClientDAO updateClientDAO, @PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.update(updateClientDAO, id));
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.delete(id));
	}
	
	
	
}
