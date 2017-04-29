package com.mackleaps.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mackleaps.model.dominio.Categoria;

public class JdbcTemplateCategoria implements ICategoriaDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createCateogira(Categoria c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria getCategoria(Integer idCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listCateogoria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategoria(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategoria(Categoria c) {
		// TODO Auto-generated method stub
		
	}

}
