package com.mackleaps.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mackleaps.model.dominio.Questao;

public class JdbcTemplateQuestao implements IQuestaoDao{

	private JdbcTemplate jdbcTemplateObject;	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createQuestao(Questao q) {
		String queryInsercao = "INSERT INTO tbQuestao (pergunta, idCategoria) VALUES (?, ?)";
		jdbcTemplateObject.update(queryInsercao, q.getPergunta(), 
												 q.getIdCategoria());
		
	}

	@Override
	public Questao getQuestao(Integer idQuestao) {
		String queryGet = "SELECT * FROM tbQuestao WHERE idQuestao = ?";
		Questao q = jdbcTemplateObject.queryForObject(queryGet, new Object[]{idQuestao}, new MapperQuestao());
		
		return q;
	}

	@Override
	public List<Questao> listQuestao() {
		String queryLista = "SELECT * FROM tbQuestao";
		List <Questao> questoes = jdbcTemplateObject.query(queryLista, new MapperQuestao());
		
		return questoes;
	}

	@Override
	public void deleteQuestao(Integer idQuestao) {
		String queryExclusao = "DELETE FROM tbQuestao WHERE idQuestao = ?";
		jdbcTemplateObject.update(queryExclusao, idQuestao);
		
	}

	@Override
	public void updateQuestao(Questao q) {
		String queryUpdate = "UPDATE tbQuestao SET pergunta = ? WHERE idQuestao = ?";
		jdbcTemplateObject.update(queryUpdate, q.getPergunta(), 
											   q.getIdQuestao());
		
	}

}
