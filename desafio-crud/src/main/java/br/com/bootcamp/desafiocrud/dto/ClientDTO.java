package br.com.bootcamp.desafiocrud.dto;

import java.time.Instant;

import br.com.bootcamp.desafiocrud.entity.Client;

public class ClientDTO {

	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;

	public ClientDTO() {}
	
	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.income = client.getIncome();
		this.birthDate = client.getBirthdate();
		this.children = client.getChildren();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}

}
