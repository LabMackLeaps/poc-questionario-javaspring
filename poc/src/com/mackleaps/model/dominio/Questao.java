package com.mackleaps.model.dominio;

public class Questao {

	private Integer idQuestao;
	private String pergunta;
	private Integer idCategoria;
	
	public Questao() { }
	
	public Questao (String pergunta, Integer idCategoria){
		this.pergunta = pergunta;
		this.idCategoria = idCategoria;
	}
	
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
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
