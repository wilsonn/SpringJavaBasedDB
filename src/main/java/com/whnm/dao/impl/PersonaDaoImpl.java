package com.whnm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.whnm.dao.PersonaDao;
import com.whnm.model.Persona;

@Repository("personaJdbc")
public class PersonaDaoImpl implements PersonaDao{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void create(Persona persona) {
		
		String sql = "INSERT INTO PERSONA(NOMBRES, APELLIDOS) VALUES (?,?)";
		
		try (Connection cx = dataSource.getConnection()){
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, persona.getNombres());
			ps.setString(2, persona.getApellidos());
			ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			System.out.println("Persona No Creada " + e.getMessage());
		}
		
		System.out.println("Persona Creada " + persona.getApellidos());
	}

	@Override
	public void update(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Persona> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
