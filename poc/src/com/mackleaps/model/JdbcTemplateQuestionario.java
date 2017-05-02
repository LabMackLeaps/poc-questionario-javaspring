package com.mackleaps.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mackleaps.model.dominio.Categoria;
import com.mackleaps.model.dominio.Questionario;

public class JdbcTemplateQuestionario implements IQuestionarioDao{

	private JdbcTemplate jdbcTemplateObject;	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createQuestionario(Questionario q) {
		String queryInsercao = "INSERT INTO tbQuestionario (titulo, descricao) VALUES (?, ?)";
		jdbcTemplateObject.update(queryInsercao, q.getTituloQuestionario(), 
												 q.getDescricaoQuestionario());
		
	}

	@Override
	public Questionario getQuestionario(Integer idQuestionario) {
		String queryGet = "SELECT * FROM tbQuestionario WHERE idQuestionario = ?";
		Questionario q = jdbcTemplateObject.queryForObject(queryGet, new Object[]{idQuestionario}, new MapperQuestionario());
		
		return q;
	}

	@Override
	public List<Questionario> listQuestionario() {
		String queryLista = "SELECT * FROM tbQuestionario";
		List <Questionario> questionarios = jdbcTemplateObject.query(queryLista, new MapperQuestionario());
		
		return questionarios;
	}

	@Override
	public void deleteQuestionario(Integer idQuestionario) {
		String queryExclusao = "DELETE FROM tbQuestionario WHERE idQuestionario = ?";
		jdbcTemplateObject.update(queryExclusao, idQuestionario);
		
	}

	@Override
	public void updateQuestionario(Questionario q) {
		String queryUpdate = "UPDATE tbQuestionario SET titulo = ?, descricao = ? WHERE idQuestionario = ?";
		jdbcTemplateObject.update(queryUpdate, q.getTituloQuestionario(), 
											   q.getDescricaoQuestionario(), 
											   q.getIdQuestionario());
		
	}

	@Override
	public List<Categoria> listCategoriasQuestionario(Integer idQuestionario) {
		String queryLista = "SELECT * FROM tbCategoria WHERE idQuestionario = ?";
		List <Categoria> categorias = jdbcTemplateObject.query(queryLista, 
															   new Object[]{idQuestionario}, 
															   new MapperCategoria());
		
		return categorias;
	}

}
