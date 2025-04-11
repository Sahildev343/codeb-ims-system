package com.itvedant.MISandInvoicingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddPaymentDAO;

import com.itvedant.MISandInvoicingSystem.dao.UpdatePaymentDAO;
import com.itvedant.MISandInvoicingSystem.entity.Invoice;
import com.itvedant.MISandInvoicingSystem.entity.Payment;
import com.itvedant.MISandInvoicingSystem.repository.InvoiceRepository;
import com.itvedant.MISandInvoicingSystem.repository.PaymentRepository;

@Service
public class PaymentService {

	
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	
	
	public Payment create(AddPaymentDAO addPaymentDAO) {
		
		
		Invoice invoice = this.invoiceRepository.findById(addPaymentDAO.getInvoiceId()).orElseThrow(()-> {
			
			throw new RuntimeException("Invoice Record with this id not found");
		});
		
		
		Payment payment = new Payment();
		
		payment.setAmountPaid(addPaymentDAO.getAmountPaid());
		payment.setPaymentDate(addPaymentDAO.getPaymentDate());
		payment.setPaymentMode(addPaymentDAO.getPaymentMode());
		payment.setInvoice(invoice);
		
		
		this.paymentRepository.save(payment);
		
		
		return payment;
	}
	
	
	public List<Payment> getAll() {
		
		List<Payment> li = new ArrayList<>();
		
		li = this.paymentRepository.findAll();
		
		return li;
		
		
		
	}
	
	
	public Payment getById(Integer id) {
		
		Payment payment = this.paymentRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("Payment Record with this id not found");
		});
		
		return payment;
	}
	
	
	public Payment update(UpdatePaymentDAO updatePaymentDAO, Integer id) {
		
		
		Payment payment = getById(id);
		
		if(updatePaymentDAO.getAmountPaid() != null) {
			
			payment.setAmountPaid(updatePaymentDAO.getAmountPaid());
		}
		
		
		if(updatePaymentDAO.getPaymentDate() != null) {
			
			payment.setPaymentDate(updatePaymentDAO.getPaymentDate());
		}
		
		if(updatePaymentDAO.getPaymentMode() != null) {
			
			payment.setPaymentMode(updatePaymentDAO.getPaymentMode());
		}
		
		if(updatePaymentDAO.getInvoiceId() != null) {
			
			Invoice invoice = this.invoiceRepository.findById (updatePaymentDAO.getInvoiceId()).orElseThrow(()-> {
				
				throw new RuntimeException("Invoice Record with this id not found");
			});
			
			
			payment.setInvoice(invoice);
		}
		
		this.paymentRepository.save(payment);
		
		return payment;
	}
	
	
	public String delete(Integer id) {
		
		this.paymentRepository.deleteById(id);
		
		return "Record Deleted Successfully";
	}
	
}
