package com.mackleaps.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mackleaps.model.dominio.Categoria;
import com.mackleaps.model.dominio.Questao;

public class JdbcTemplateCategoria implements ICategoriaDao{	

	private JdbcTemplate jdbcTemplateObject;	
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createCategoria(Categoria c) {
		String queryInsercao = "INSERT INTO tbCategoria (titulo, descricao, idQuestionario) VALUES (?, ?, ?)";
		jdbcTemplateObject.update(queryInsercao, c.getTituloCategoria(), 
												 c.getDescricaoCategoria(),
												 c.getIdQuestionario());
		
	}

	@Override
	public Categoria getCategoria(Integer idCategoria) {
		String queryGet = "SELECT * FROM tbCategoria WHERE idCategoria = ?";
		Categoria c = jdbcTemplateObject.queryForObject(queryGet, new Object[]{idCategoria}, new MapperCategoria());
		
		return c;
	}

	@Override
	public List<Categoria> listCategoria() {
		String queryLista = "SELECT * FROM tbCategoria";
		List <Categoria> categorias = jdbcTemplateObject.query(queryLista, new MapperCategoria());
		
		return categorias;
	}

	@Override
	public void deleteCategoria(Integer idCategoria) {
		String queryExclusao = "DELETE FROM tbCategoria WHERE idCategoria = ?";
		jdbcTemplateObject.update(queryExclusao, idCategoria);
		
	}

	@Override
	public void updateCategoria(Categoria c) {
		String queryUpdate = "UPDATE tbCategoria SET titulo = ?, descricao = ? WHERE idCategoria = ?";
		jdbcTemplateObject.update(queryUpdate, c.getTituloCategoria(), 
											   c.getDescricaoCategoria(), 
											   c.getIdCategoria());
		
	}

	@Override
	public List<Questao> listQuestoesCategoria(Integer idCategoria) {
		String queryLista = "SELECT * FROM tbQuestao WHERE idCategoria = ?";
		List<Questao> questoes = jdbcTemplateObject.query(queryLista, 
														  new Object[]{idCategoria}, 
														  new MapperQuestao());
		
		return questoes;
	}
	

}
