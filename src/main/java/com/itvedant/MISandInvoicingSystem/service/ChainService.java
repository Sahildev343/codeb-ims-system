package com.itvedant.MISandInvoicingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddChainsDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateChainDAO;
import com.itvedant.MISandInvoicingSystem.entity.Chain;
import com.itvedant.MISandInvoicingSystem.entity.Group;
import com.itvedant.MISandInvoicingSystem.repository.ChainRepository;
import com.itvedant.MISandInvoicingSystem.repository.GroupRepository;

@Service
public class ChainService {

	
	@Autowired
	private ChainRepository chainRepository;
	
	
	@Autowired
	private GroupRepository groupRepository;
	
	
	
	public Chain create(AddChainsDAO addChainsDAO) {
		
		Group group = this.groupRepository.findById(addChainsDAO.getGroupId()).orElseThrow(()-> {
			
			throw new RuntimeException("Group With this Id Not Found");
		});
		
		
		Chain chain = new Chain();
		chain.setName(addChainsDAO.getName());
		chain.setGroup(group);
		
		this.chainRepository.save(chain);
		
		return chain;
	}
	
	
	public List<Chain> getAll() {
		
		List<Chain> li = new ArrayList<>();
		
		li = this.chainRepository.findAll();
		
		return li;
		
		
	}
	
	
	public Chain getById(Integer id) {
		
		Chain chain = this.chainRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Chain Record with this id not found");
		});
		
		
		return chain;
	}
	
	
	public Chain update(UpdateChainDAO updateChainDAO, Integer id) {
		
		Chain chain = this.chainRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Chain Record with this id not found");
		});
		
		if(updateChainDAO.getName() != null) {
			
			chain.setName(updateChainDAO.getName());
		}
		
		if(updateChainDAO.getGroupId() != null) {
			Group group = this.groupRepository.findById(updateChainDAO.getGroupId()).orElseThrow(()-> {
				
				throw new RuntimeException("Group With this Id Not Found");
			});
			
			chain.setGroup(group);
			
			
			
		}
		
		this.chainRepository.save(chain);
		
		return chain;
	}
	
	
	public String delete(Integer id) {
		
		this.chainRepository.deleteById(id);
		
		return "Chain Record Deleted Successfully";
		
	}
}
