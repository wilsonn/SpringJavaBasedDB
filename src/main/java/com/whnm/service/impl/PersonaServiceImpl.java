package com.whnm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whnm.dao.PersonaDao;
import com.whnm.model.Persona;
import com.whnm.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	@Qualifier("personaSpringJdbcTemplate")
	private PersonaDao personaDAO;

	@Override
	public void create(Persona persona) {
		personaDAO.create(persona);
	}

	@Override
	public void update(Persona persona) {
		personaDAO.update(persona);
	}

	@Override
	public List<Persona> listAll() {
		return personaDAO.listAll();
	}

	@Override
	public Persona find(Integer id) {
		return personaDAO.find(id);
	}

//	@Transactional("transactionManager")
	@Override
	public void delete(Integer id) {
		personaDAO.delete(id);
	}
	
	
}
