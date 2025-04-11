package com.itvedant.MISandInvoicingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddInvoiceDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateInvoiceDAO;
import com.itvedant.MISandInvoicingSystem.entity.Client;
import com.itvedant.MISandInvoicingSystem.entity.Estimate;
import com.itvedant.MISandInvoicingSystem.entity.Invoice;
import com.itvedant.MISandInvoicingSystem.repository.ClientRepository;
import com.itvedant.MISandInvoicingSystem.repository.EstimateRepository;
import com.itvedant.MISandInvoicingSystem.repository.InvoiceRepository;

@Service
public class InvoiceService {

	
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	@Autowired
	private EstimateRepository estimateRepository;
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public Invoice create(AddInvoiceDAO addInvoiceDAO) {
		
		Estimate estimate = this.estimateRepository.findById(addInvoiceDAO.getEstimateId()).orElseThrow(()-> {
			
			throw new RuntimeException("Estimate Record with this id not found");
		});
		
		
		Client client = this.clientRepository.findById(addInvoiceDAO.getClientId()).orElseThrow(()-> {
			
			throw new RuntimeException("Client record with this id not found");
		});
		
		
		Invoice invoice = new Invoice();
		invoice.setInvoiceNumber(addInvoiceDAO.getInvoiceNumber());
		invoice.setAmount(addInvoiceDAO.getAmount());
		invoice.setGstAmount(addInvoiceDAO.getGstAmount());
		invoice.setStatus(addInvoiceDAO.getStatus());
		invoice.setIssueDate(addInvoiceDAO.getIssueDate());
		invoice.setDueDate(addInvoiceDAO.getDueDate());
		invoice.setEstimate(estimate);
		invoice.setClient(client);
		
		this.invoiceRepository.save(invoice);
		
		return invoice;
	}
	
	
	public List<Invoice> getAll() {
		
		List<Invoice> li = new ArrayList<>();
		
		li = this.invoiceRepository.findAll();
		
		return li;
	}
	
	
	public Invoice getById(Integer id) {
		
		Invoice invoice = this.invoiceRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Invoice record with this id not found");
		});
		
		return invoice;
	}
	
	
	public Invoice update(UpdateInvoiceDAO updateInvoiceDAO, Integer id) {
		
		Invoice invoice = getById(id);
		
		
		if(updateInvoiceDAO.getAmount() != null) {
			
			invoice.setAmount(updateInvoiceDAO.getAmount());
		}
		
		if(updateInvoiceDAO.getGstAmount() != null) {
			
			invoice.setGstAmount(updateInvoiceDAO.getGstAmount());
		}
		
		if(updateInvoiceDAO.getStatus() != null) {
			
			invoice.setStatus(updateInvoiceDAO.getStatus());
		}
		
		if(updateInvoiceDAO.getIssueDate() != null) {
			
			invoice.setIssueDate(updateInvoiceDAO.getIssueDate());
		}
		
		if(updateInvoiceDAO.getDueDate() != null) {
			
			invoice.setDueDate(updateInvoiceDAO.getDueDate());
		}
		
		if(updateInvoiceDAO.getEstimateId() != null) {
			
			Estimate estimate = this.estimateRepository.findById(updateInvoiceDAO.getEstimateId()).orElseThrow(()-> {
				
				throw new RuntimeException("Estimate Record with this id not found");
			});
			
			
			invoice.setEstimate(estimate);
		}
		
		if(updateInvoiceDAO.getClientId() != null) {
			
			Client client = this.clientRepository.findById(updateInvoiceDAO.getClientId()).orElseThrow(()-> {
				
				throw new RuntimeException("Client record with this id not found");
			});
			
			
			invoice.setClient(client);
			
		}
		
		
		this.invoiceRepository.save(invoice);
		
		return invoice;
	}
	
	
	public String delete(Integer id) {
		
		this.invoiceRepository.deleteById(id);
		
		return "Record Deleted Succcessfully";
	}
}
