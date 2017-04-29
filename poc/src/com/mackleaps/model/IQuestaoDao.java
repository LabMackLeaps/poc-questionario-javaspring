package com.mackleaps.model;

import java.util.List;

import javax.sql.DataSource;

import com.mackleaps.model.dominio.Questao;

public interface IQuestaoDao {

	public void setDataSource(DataSource dataSource);
	public void createQuestao(Questao c);
	public Questao getQuestao (Integer idQuestao);
	public List<Questao> listQuestao ();
	public void deleteQuestao (Integer idQuestao);
	public void updateQuestao (Questao c);
	
}
