package com.itvedant.MISandInvoicingSystem.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddClientDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateClientDAO;
import com.itvedant.MISandInvoicingSystem.entity.Brand;
import com.itvedant.MISandInvoicingSystem.entity.Chain;
import com.itvedant.MISandInvoicingSystem.entity.Client;
import com.itvedant.MISandInvoicingSystem.entity.Group;
import com.itvedant.MISandInvoicingSystem.entity.SubZone;
import com.itvedant.MISandInvoicingSystem.repository.BrandRepository;
import com.itvedant.MISandInvoicingSystem.repository.ChainRepository;
import com.itvedant.MISandInvoicingSystem.repository.ClientRepository;
import com.itvedant.MISandInvoicingSystem.repository.GroupRepository;
import com.itvedant.MISandInvoicingSystem.repository.SubZoneRepository;

@Service
public class ClientService {

	
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	
	
	@Autowired
	private ChainRepository chainRepository;
	
	
	@Autowired
	private BrandRepository brandRepository;
	
	
	@Autowired
	private SubZoneRepository subZoneRepository;
	
	
	
	
	public Client create(AddClientDAO addClientDAO) {
		
		
		Group group = this.groupRepository.findById(addClientDAO.getGroupId()).orElseThrow(()-> {
			
			throw new RuntimeException("Group record with this id not found");
		});
		
		
		Chain chain = this .chainRepository.findById(addClientDAO.getChainId()).orElseThrow(()-> {
			
			throw new RuntimeException("Chain Record with this id not found");
		});
		
		
		Brand brand = this.brandRepository.findById(addClientDAO.getBrandId()).orElseThrow(()-> {
			
			throw new RuntimeException("Brand Record with this id not found");
			
		});
		
		
		SubZone subZone = this.subZoneRepository.findById(addClientDAO.getSubZoneId()).orElseThrow(()-> {
			
			throw new RuntimeException("Subzone record with this id not found");
		});
		
		
		Client client = new Client();
		
		client.setName(addClientDAO.getName());
		client.setGstNumber(addClientDAO.getGstNumber());
		client.setAddress(addClientDAO.getAddress());
		client.setGroup(group);
		client.setChains(chain);
		client.setBrand(brand);
		client.setSubZones(subZone);
		
		this.clientRepository.save(client);
		
		return client;
		
		
	}
	
	public List<Client> getAll() {
		
		List<Client> li = new ArrayList<>();
		li = this.clientRepository.findAll();
		
		return li;
		
		
	}
	
	
	public Client update(UpdateClientDAO updateClientDAO, Integer id) {
		
		Client client = this.clientRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Client Record with this id not found");
		});
		
		if(updateClientDAO.getName() != null) {
			
			client.setName(updateClientDAO.getName());
		}
		
		if(updateClientDAO.getGstNumber() != null) {
			
			client.setGstNumber(updateClientDAO.getGstNumber());
			
		}
		
		if(updateClientDAO.getAddress() != null) {
			
			client.setAddress(updateClientDAO.getAddress());
			
		}
		
		if(updateClientDAO.getGroupId() != null) {
			
			Group group = this.groupRepository.findById(updateClientDAO.getGroupId()).orElseThrow(()-> {
				
				throw new RuntimeException("Group record with this id not found");
			});
			
			client.setGroup(group);
			
			
		}
		
		if(updateClientDAO.getChainId() != null) {
			
			Chain chain = this .chainRepository.findById(updateClientDAO.getChainId()).orElseThrow(()-> {
				
				throw new RuntimeException("Chain Record with this id not found");
			});
			
			client.setChains(chain);
			
		}
		
		if(updateClientDAO.getBrandId() != null) {
			
			Brand brand = this.brandRepository.findById(updateClientDAO.getBrandId()).orElseThrow(()-> {
				
				throw new RuntimeException("Brand Record with this id not found");
				
			});
			
			client.setBrand(brand);
		}
		
		if(updateClientDAO.getSubZoneId() != null) {
			
			SubZone subZone = this.subZoneRepository.findById(updateClientDAO.getSubZoneId()).orElseThrow(()-> {
				
				throw new RuntimeException("Subzone record with this id not found");
			});
			
			client.setSubZones(subZone);
			
		}
		
		this.clientRepository.save(client);
		
		return client;
		
	}
	
	
	public Client getById(Integer id) {
		
		Client client = this.clientRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Client record with this id not found");
		});
		
		return client;
	}
	
	
	public String delete(Integer id) {
		
		this.clientRepository.deleteById(id);
		
		return "Deleted Record Successfully";
	}
	
	
}
