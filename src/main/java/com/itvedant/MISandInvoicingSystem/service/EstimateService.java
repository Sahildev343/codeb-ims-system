package com.itvedant.MISandInvoicingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddEstimateDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateEstimateDAO;
import com.itvedant.MISandInvoicingSystem.entity.Chain;
import com.itvedant.MISandInvoicingSystem.entity.Client;
import com.itvedant.MISandInvoicingSystem.entity.Estimate;
import com.itvedant.MISandInvoicingSystem.repository.ChainRepository;
import com.itvedant.MISandInvoicingSystem.repository.ClientRepository;
import com.itvedant.MISandInvoicingSystem.repository.EstimateRepository;

@Service
public class EstimateService {

	
	@Autowired
	private EstimateRepository estimateRepository;
	
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Autowired
	private ChainRepository chainRepository;
	
	
	public Estimate create(AddEstimateDAO addEstimateDAO) {
		
		Client client = this.clientRepository.findById(addEstimateDAO.getClientId()).orElseThrow(()-> {
			
			throw new RuntimeException("Client Record with thia id not found");
		});
		
		Chain chain = this.chainRepository.findById(addEstimateDAO.getChainId()).orElseThrow(()-> {
			
			throw new RuntimeException("Chain Record with this id not found");
		});
		
		
		Estimate estimate = new Estimate();
		estimate.setAmount(addEstimateDAO.getAmount());
		estimate.setStatus(addEstimateDAO.getStatus());
		estimate.setClient(client);
		estimate.setChains(chain);
		
		this.estimateRepository.save(estimate);
		
		return estimate;
		
		
	}
	
	
	public List<Estimate> getAll() {
		List<Estimate> li  = new ArrayList<>();
		
		li = this.estimateRepository.findAll();
		
		return li;
		
	}
	
	
	public Estimate getById(Integer id) {
		
		Estimate e = this.estimateRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Estimate Record with this id not found");
		});
		
		return e;
	}
	
	
	public Estimate update(UpdateEstimateDAO updateEstimateDAO, Integer id) {
		
	Estimate e = this.estimateRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Estimate Record with this id not found");
		});
	
	if(updateEstimateDAO.getAmount() != null) {
		
		e.setAmount(updateEstimateDAO.getAmount());
	}
	
	if(updateEstimateDAO.getStatus() != null) {
		
		e.setStatus(updateEstimateDAO.getStatus());
		
	}
	
	if(updateEstimateDAO.getClientId() != null) {
		
	Client client = this.clientRepository.findById(updateEstimateDAO.getClientId()).orElseThrow(()-> {
			
			throw new RuntimeException("Client Record with thia id not found");
		});
	
	e.setClient(client);
		
	}
	
	if(updateEstimateDAO.getChainId() != null) {
		
Chain chain = this.chainRepository.findById(updateEstimateDAO.getChainId()).orElseThrow(()-> {
			
			throw new RuntimeException("Chain Record with this id not found");
		});

e.setChains(chain);

		
		
	}
	
	this.estimateRepository.save(e);
	
	return e;
		
		
	}
	
	
	public String delete(Integer id) {
		
		this.estimateRepository.deleteById(id);
		
		return "Estimate Record Deleted Successfully";
	}
}
