package com.mackleaps.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		Questionario q = jdbcTemplateObject.queryForObject(queryGet, new Object[]{idQuestionario}, new QuestionarioMapper());
		
		return q;
	}

	@Override
	public List<Questionario> listQuestionario() {
		String queryLista = "SELECT * FROM tbQuestionario";
		List <Questionario> questionarios = jdbcTemplateObject.query(queryLista, new QuestionarioMapper());
		
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

	private class QuestionarioMapper implements RowMapper<Questionario>{

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
	
}
