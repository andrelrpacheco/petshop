package com.andre.petshop.domain.enums;

public enum StatusPayment {

	Approved(1, "Aprovado"),
	Canceled(2, "Cancelado"),
	Pending(3, "Pendente");
	
	private int cod;
	private String description;
	
	private StatusPayment(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public static StatusPayment toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (StatusPayment status : StatusPayment.values()) {
			if(cod.equals(status.getCod())) {
				return status;
			}
		}
		
		throw new IllegalArgumentException();
	}
	
	

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
