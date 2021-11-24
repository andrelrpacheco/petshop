package com.andre.petshop.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.andre.petshop.domain.enums.StatusPayment;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Double value;
	private Integer statusPayment;
	
	@OneToOne
	@JoinColumn(name = "id_service")
	@MapsId
	private Service service;
	
	public Payment() {
		
	}

	public Payment(Integer id, Double value, StatusPayment statusPayment, Service service) {
		super();
		this.id = id;
		this.value = value;
		this.statusPayment = statusPayment.getCod();
		this.service = service;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public StatusPayment getStatusPayment() {
		return StatusPayment.toEnum(statusPayment);
	}

	public void setStatusPayment(StatusPayment statusPayment) {
		this.statusPayment = statusPayment.getCod();
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
}
