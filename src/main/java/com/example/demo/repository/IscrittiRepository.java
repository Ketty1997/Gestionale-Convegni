package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Iscritti;

public interface IscrittiRepository extends JpaRepository <Iscritti, Integer> {
	
	//metodo che mi trova gli iscritti mettendo un nome o un cognome parziali
	public List <Iscritti> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(@Param("name") String name, @Param("surname") String surname);
}
