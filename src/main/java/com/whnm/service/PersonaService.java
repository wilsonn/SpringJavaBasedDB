package com.whnm.service;

import java.util.List;

import com.whnm.model.Persona;

public interface PersonaService {
	void create(Persona persona);
	void update(Persona persona);
	List<Persona> listAll();
	Persona find(Integer id);
	void delete(Integer id);
}
