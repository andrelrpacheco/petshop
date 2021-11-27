package com.andre.petshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer idade;
	
	@ManyToOne
	@JoinColumn(name = "id_specie")
	private Specie specie;
	
	@ManyToOne
	@JoinColumn(name = "id_race")
	private Race race;
	
	@OneToMany(mappedBy = "pet")
	private List<ServiceOfPet> services = new ArrayList<>();
	
	public Pet() {
		
	}

	public Pet(Integer id, String name, Integer idade, Specie specie, Race race) {
		super();
		this.id = id;
		this.name = name;
		this.idade = idade;
		this.specie = specie;
		this.race = race;
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
		Pet other = (Pet) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Specie getSpecie() {
		return specie;
	}

	public void setSpecie(Specie specie) {
		this.specie = specie;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public List<ServiceOfPet> getServices() {
		return services;
	}

	public void setServices(List<ServiceOfPet> services) {
		this.services = services;
	}
}
