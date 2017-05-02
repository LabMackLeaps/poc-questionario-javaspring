package com.mackleaps.model;

import java.util.List;

import javax.sql.DataSource;

import com.mackleaps.model.dominio.Categoria;
import com.mackleaps.model.dominio.Questionario;

public interface IQuestionarioDao {

	public void setDataSource(DataSource dataSource);
	public void createQuestionario(Questionario c);
	public Questionario getQuestionario (Integer idQuestionario);
	public List<Questionario> listQuestionario ();
	public void deleteQuestionario (Integer idQuestionario);
	public void updateQuestionario (Questionario c);
	public List<Categoria> listCategoriasQuestionario(Integer idQuestionario);
	
}
