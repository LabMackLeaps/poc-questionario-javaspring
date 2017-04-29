package com.mackleaps.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mackleaps.model.dominio.Questionario;

public class JdbcTemplateQuestionario implements IQuestionarioDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createQuestionario(Questionario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Questionario getQuestionario(Integer idQuestionario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questionario> listQuestionario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuestionario(Integer idQuestionario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuestionario(Questionario c) {
		// TODO Auto-generated method stub
		
	}

}
