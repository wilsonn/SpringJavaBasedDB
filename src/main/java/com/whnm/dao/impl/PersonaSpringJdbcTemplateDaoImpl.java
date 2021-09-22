package com.whnm.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.whnm.dao.PersonaDao;
import com.whnm.model.Persona;

@Repository("personaSpringJdbcTemplate")
public class PersonaSpringJdbcTemplateDaoImpl extends JdbcDaoSupport implements PersonaDao{
	
	@Autowired
	public PersonaSpringJdbcTemplateDaoImpl(DataSource datasource) {
		this.setDataSource(datasource);
	}
	
	@Override
	public void create(Persona persona) {
		
		String sql = "INSERT INTO PERSONA(NOMBRES, APELLIDOS) VALUES (?,?)";
		
		this.getJdbcTemplate().update(sql, persona.getNombres(), persona.getApellidos());
		
		System.out.println("Persona Creada " + persona.getApellidos());
	}

	@Override
	public void update(Persona persona) {
		String sql = "UPDATE PERSONA SET NOMBRES=?, APELLIDOS=? WHERE ID=?";		
		this.getJdbcTemplate().update(sql, persona.getNombres(), persona.getApellidos(), persona.getId());
	}

	@Override
	public List<Persona> listAll() {
		String sql = "SELECT ID, NOMBRES, APELLIDOS FROM PERSONA ORDER BY NOMBRES, APELLIDOS";		
		List<Persona> lista = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Persona>(Persona.class));
		return lista;
	}

	@Override
	public Persona find(Integer id) {
		String sql = "SELECT ID, NOMBRES, APELLIDOS FROM PERSONA WHERE ID=?";		
		Persona persona = this.getJdbcTemplate().queryForObject(sql, new Object [] {id}, new BeanPropertyRowMapper<Persona>(Persona.class));
		return persona;
	}

	@Transactional("transactionManager")
	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM PERSONA WHERE ID=?";
		this.getJdbcTemplate().update(sql, id);
		
		String sqlUpdate = "UPDATE PERSONA SET NOMBRES=?, APELLIDOS=? ,WHERE ID=?";		
		this.getJdbcTemplate().update(sqlUpdate, id);
	}

}
