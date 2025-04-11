package com.itvedant.MISandInvoicingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddGroupDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateGroupDAO;
import com.itvedant.MISandInvoicingSystem.entity.Group;
import com.itvedant.MISandInvoicingSystem.repository.GroupRepository;

@Service
public class GroupService {

	
	
	@Autowired
	private GroupRepository groupRepository;
	
	
	public Group create(AddGroupDAO addGroupDAO) {
		
		Group g = new Group();
		g.setName(addGroupDAO.getName());
		
		this.groupRepository.save(g);
		
		return g;
	}
	
	
	public List<Group> getAll() {
		
		List<Group> li = new ArrayList<>();
		li = this.groupRepository.findAll();
		
		return li;
	}
	
	
	public Group getById(Integer id) {
		
		Group g = this.groupRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Group Record with this id not found");
		});
		
		return g;
	}
	
	
	public Group update(UpdateGroupDAO updateGroupDAO, Integer id) {
		
		Group g = getById(id);
		
		if(updateGroupDAO.getName() != null) {
			 g.setName(updateGroupDAO.getName());
			
		}
		
		this.groupRepository.save(g);
		
		return g;
	}
	
	
	public String delete(Integer id) {
		
		this.groupRepository.deleteById(id);
		
		return "Deleted Record Successfully";
	}
	
}
