package com.itvedant.MISandInvoicingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddBrandDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateBrandDAO;
import com.itvedant.MISandInvoicingSystem.entity.Brand;
import com.itvedant.MISandInvoicingSystem.entity.Chain;
import com.itvedant.MISandInvoicingSystem.repository.BrandRepository;
import com.itvedant.MISandInvoicingSystem.repository.ChainRepository;

@Service
public class BrandService {

	
	
	@Autowired
	private BrandRepository brandRepository;
	
    
	
	@Autowired
	private ChainRepository chainRepository;
	
	
	public Brand create(AddBrandDAO addBrandDAO) {
		
		Chain chain = this.chainRepository.findById(addBrandDAO.getChainId()).orElseThrow(()-> {
			
			throw new RuntimeException("Chain Id not Found");
		});
		
		Brand brand = new Brand();
		brand.setName(addBrandDAO.getName());
		brand.setChains(chain);
		
		this.brandRepository.save(brand);
		
		return brand;
		
	}
	
	
	public List<Brand> GetAll() {
		
		List<Brand> li = new ArrayList<>();
		li = this.brandRepository.findAll();
		
		return li;
	}
	
	public Brand getById(Integer id) {
		
		Brand brand = this.brandRepository.findById(id).orElse(null);
		return brand;
	}
	
	
	public Brand update(UpdateBrandDAO updateBrandDAO, Integer id) {
		Brand brand = this.brandRepository.findById(id).orElse(null);
		
		if(updateBrandDAO.getName() != null) {
			
			brand.setName(updateBrandDAO.getName());
		}
		
		if(updateBrandDAO.getChainId() != null) {
			
			Chain chain = this.chainRepository.findById(updateBrandDAO.getChainId()).orElseThrow(()-> {
				
				throw new RuntimeException("Chain Id not Found");
			});
			
			brand.setChains(chain);
			
		}
		
		this.brandRepository.save(brand);
		
		return brand;
		
	}
	
	
	public String delete(Integer id) {
		
		this.brandRepository.deleteById(id);
		
		return "Brand Record Deleted Successfully";
	}
}
