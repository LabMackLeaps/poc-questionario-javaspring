package com.mackleaps.model.dominio;

public class Questao {

	private Integer idQuestao;
	private String pergunta;
	private Integer idCateogira;
	
	public Integer getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public Integer getIdCateogira() {
		return idCateogira;
	}
	public void setIdCateogira(Integer idCateogira) {
		this.idCateogira = idCateogira;
	}
	
}
