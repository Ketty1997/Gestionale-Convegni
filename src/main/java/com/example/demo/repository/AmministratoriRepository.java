package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Amministratori;

public interface AmministratoriRepository extends JpaRepository<Amministratori, Integer> {
	//trovo amministratori per email e pass, uso optional perche la lista potrebbe essere vuota
	Optional <Amministratori> findByEmailAdminAndPassword(String email, String password);
	//trovo amministratori per email
	Optional<Amministratori> findByEmailAdmin(String email);
}
