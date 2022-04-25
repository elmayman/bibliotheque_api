package com.example.bibliotheque_api.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotheque_api.entities.Livre;



public interface LivreRepo  extends JpaRepository<Livre, Long>{
	

}
