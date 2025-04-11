package com.itvedant.MISandInvoicingSystem.controller;

import java.net.ResponseCache;

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

import com.itvedant.MISandInvoicingSystem.dao.AddChainsDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateChainDAO;
import com.itvedant.MISandInvoicingSystem.service.ChainService;

@RestController
@RequestMapping("/chains")
public class ChainController {
	
	
	@Autowired
	private ChainService service;
	
	
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AddChainsDAO addChainsDAO) {
		
		return ResponseEntity.ok(this.service.create(addChainsDAO));
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
	public ResponseEntity<?> update(@RequestBody UpdateChainDAO updateChainDAO, @PathVariable Integer id) {
		
		
		return ResponseEntity.ok(this.service.update(updateChainDAO, id));
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.delete(id));
	}
	
}
