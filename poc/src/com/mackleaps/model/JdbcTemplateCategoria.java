package com.mackleaps.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mackleaps.model.dominio.Categoria;

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
		Categoria c = jdbcTemplateObject.queryForObject(queryGet, new CategoriaMapper());
		
		return c;
	}

	@Override
	public List<Categoria> listCategoria() {
		String queryLista = "SELECT * FROM tbCategoria";
		List <Categoria> categorias = jdbcTemplateObject.query(queryLista, new CategoriaMapper());
		
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

	private class CategoriaMapper implements RowMapper<Categoria>{

		/**
		 * Recebe um ResultSet e realiza o mapeamento do mesmo 
		 * Transformando o rs passado como parametro em um objeto do tipo Categoria
		 * */
		@Override
		public Categoria mapRow(ResultSet rs, int linha) throws SQLException {
			Categoria c = new Categoria();
			c.setIdCategoria(rs.getInt("idCategoria"));
			c.setTituloCategoria(rs.getString("tituloCategoria"));
			c.setDescricaoCategoria(rs.getString("descricaoCategoria"));
			c.setIdCategoria(rs.getInt("idCategoria"));
						
			return c;
			
		}
		
	}
}
