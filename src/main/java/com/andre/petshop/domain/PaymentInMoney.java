package com.andre.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.andre.petshop.domain.enums.StatusPayment;

@Entity
public class PaymentInMoney extends Payment {

	private static final long serialVersionUID = 1L;

	private Date datePayment;
	private Double discount;
	
	public PaymentInMoney() {
		
	}

	public PaymentInMoney(Integer id, Double value, StatusPayment statusPayment, Service service, Date datePayment, Double discount) {
		super(id, value, statusPayment, service);
		this.datePayment = datePayment;
		this.discount = discount;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}
