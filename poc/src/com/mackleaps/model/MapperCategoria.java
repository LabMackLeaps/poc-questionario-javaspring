package com.mackleaps.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mackleaps.model.dominio.Categoria;

public class MapperCategoria implements RowMapper<Categoria>{

	/**
	 * Recebe um ResultSet e realiza o mapeamento do mesmo 
	 * Transformando o rs passado como parametro em um objeto do tipo Categoria
	 * */
	@Override
	public Categoria mapRow(ResultSet rs, int linha) throws SQLException {
		Categoria c = new Categoria();
		c.setIdCategoria(rs.getInt("idCategoria"));
		c.setTituloCategoria(rs.getString("titulo"));
		c.setDescricaoCategoria(rs.getString("descricao"));
		c.setIdQuestionario(rs.getInt("idQuestionario"));
					
		return c;
		
	}
	
}
