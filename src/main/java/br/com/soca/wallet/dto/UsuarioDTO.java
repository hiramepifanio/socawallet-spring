package br.com.soca.wallet.dto;

import br.com.soca.wallet.model.Usuario;

public class UsuarioDTO {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	
	public UsuarioDTO (Usuario u) {
		id = u.getId();
		nome = u.getNome();
		sobrenome = u.getSobrenome();
		email = u.getEmail();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
