package com.mackleaps.model.dominio;

public class Questionario {

	private Integer idQuestionario;
	private String tituloQuestionario;
	private String descricaoQuestionario;
	
	public Questionario(){ }
	
	public Questionario(String tituloQuestionario, String descricaoQuestionario){
		this.tituloQuestionario = tituloQuestionario;
		this.descricaoQuestionario = descricaoQuestionario;
	}
	
	public Integer getIdQuestionario() {
		return idQuestionario;
	}
	public void setIdQuestionario(Integer idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	
	public String getTituloQuestionario() {
		return tituloQuestionario;
	}
	public void setTituloQuestionario(String tituloQuestionario) {
		this.tituloQuestionario = tituloQuestionario;
	}
	
	public String getDescricaoQuestionario() {
		return descricaoQuestionario;
	}
	public void setDescricaoQuestionario(String descricaoQuestionario) {
		this.descricaoQuestionario = descricaoQuestionario;
	}
	
	
	
}
