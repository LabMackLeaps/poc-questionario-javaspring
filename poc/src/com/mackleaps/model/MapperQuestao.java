package com.mackleaps.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mackleaps.model.dominio.Questao;

public class MapperQuestao implements RowMapper<Questao>{

	/**
	 * Recebe um ResultSet e realiza o mapeamento do mesmo 
	 * Transformando o rs passado como parametro em um objeto do tipo Categoria
	 * */
	@Override
	public Questao mapRow(ResultSet rs, int linha) throws SQLException {
		Questao q = new Questao();
		q.setIdQuestao(rs.getInt("idQuestao"));
		q.setPergunta(rs.getString("pergunta"));
		q.setIdCategoria(rs.getInt("idCategoria"));
		
		return q;
		
	}
	
}
