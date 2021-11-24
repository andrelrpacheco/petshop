package com.andre.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.andre.petshop.domain.enums.StatusPayment;

@Entity
public class PaymentInMoney extends Payment {

	private static final long serialVersionUID = 1L;

	private Date dueDate;
	private Double discount;
	
	public PaymentInMoney() {
		
	}

	public PaymentInMoney(Integer id, Double value, StatusPayment statusPayment, Service service, Date dueDate, Double discount) {
		super(id, value, statusPayment, service);
		this.dueDate = dueDate;
		this.discount = discount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}
