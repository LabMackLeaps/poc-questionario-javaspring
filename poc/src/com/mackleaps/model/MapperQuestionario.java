package com.mackleaps.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mackleaps.model.dominio.Questionario;

public class MapperQuestionario implements RowMapper<Questionario>{

	/**
	 * Recebe um ResultSet e realiza o mapeamento do mesmo 
	 * Transformando o rs passado como parametro em um objeto do tipo Questionario
	 * */
	@Override
	public Questionario mapRow(ResultSet rs, int linha) throws SQLException {
		Questionario q = new Questionario();
		q.setIdQuestionario(rs.getInt("idQuestionario"));
		q.setTituloQuestionario(rs.getString("titulo"));
		q.setDescricaoQuestionario(rs.getString("descricao"));
					
		return q;
		
	}
	
}