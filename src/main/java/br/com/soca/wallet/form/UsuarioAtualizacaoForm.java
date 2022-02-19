package br.com.soca.wallet.form;

import br.com.soca.wallet.model.Usuario;

public class UsuarioAtualizacaoForm implements Form {

	private String nome;
	private String sobrenome;
	private String email;
	private String senha;

	public void atualizarUsuario(Usuario usuario) {
		if (!(nome == null)) usuario.setNome(nome);
		if (!(sobrenome == null)) usuario.setSobrenome(sobrenome);
		if (!(email == null)) usuario.setEmail(email);
	}
	
	@Override
	public void verificarEntradas() {
		
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
