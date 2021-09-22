package com.whnm.dao;

import java.util.List;

import com.whnm.model.Persona;

public interface PersonaDao {
	void create(Persona persona);
	void update(Persona persona);
	List<Persona> listAll();
	Persona find(Integer id);
	void delete(Integer id);
}
