package com.mackleaps.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mackleaps.model.dominio.Questao;

public class JdbcTemplateQuestao implements IQuestaoDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createQuestao(Questao c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Questao getQuestao(Integer idQuestao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questao> listQuestao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuestao(Integer idQuestao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuestao(Questao c) {
		// TODO Auto-generated method stub
		
	}

}
