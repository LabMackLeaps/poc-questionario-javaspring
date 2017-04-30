package com.mackleaps.model;

import java.util.List;

import javax.sql.DataSource;

import com.mackleaps.model.dominio.Categoria;

public interface ICategoriaDao {
	
	public void setDataSource(DataSource dataSource);
	public void createCategoria(Categoria c);
	public Categoria getCategoria (Integer idCategoria);
	public List<Categoria> listCategoria ();
	public void deleteCategoria (Integer idCategoria);
	public void updateCategoria (Categoria c);
		
}
