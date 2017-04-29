package com.mackleaps.model.dominio;

public class Categoria {

	private Integer idCategoria;
	private String tituloCategoria;
	private String descricaoCategoria;
	private Integer idQuestionario;
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public String getTituloCategoria() {
		return tituloCategoria;
	}
	public void setTituloCategoria(String tituloCategoria) {
		this.tituloCategoria = tituloCategoria;
	}
	
	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}
	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}
	
	public Integer getIdQuestionario() {
		return idQuestionario;
	}
	public void setIdQuestionario(Integer idQuestionario) {
		this.idQuestionario = idQuestionario;
	}
	
}
