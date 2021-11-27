package com.andre.petshop.domain;

import javax.persistence.Entity;

import com.andre.petshop.domain.enums.StatusPayment;

@Entity
public class PaymentInCard extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Integer installments;
	
	public PaymentInCard() {
		
	}

	public PaymentInCard(Integer id, Double value, StatusPayment statusPayment, ServiceOfPet service, Integer installments) {
		super(id, value, statusPayment, service);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
}
