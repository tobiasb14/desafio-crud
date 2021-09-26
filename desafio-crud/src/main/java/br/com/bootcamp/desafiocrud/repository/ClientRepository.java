package br.com.bootcamp.desafiocrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bootcamp.desafiocrud.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
