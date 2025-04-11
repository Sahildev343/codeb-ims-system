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

import com.itvedant.MISandInvoicingSystem.dao.AddGroupDAO;
import com.itvedant.MISandInvoicingSystem.dao.AddInvoiceDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateGroupDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateInvoiceDAO;
import com.itvedant.MISandInvoicingSystem.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	
	
	@Autowired
	private InvoiceService service;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AddInvoiceDAO addInvoiceDAO) {
		
		
		return ResponseEntity.ok(this.service.create(addInvoiceDAO));
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
	public ResponseEntity<?> update(@RequestBody UpdateInvoiceDAO updateInvoiceDAO, @PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.update(updateInvoiceDAO, id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		return ResponseEntity.ok(this.service.delete(id));
	}
}
