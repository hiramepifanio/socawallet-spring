package br.com.soca.wallet.form;

import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.util.ModelException;

public class AtualizarUsuarioForm {

	private String nome;
	private String sobrenome;
	private String email;
	private String senha;

	public Usuario atualizarUsuario(Usuario u) {
		u.setNome(nome);
		u.setSobrenome(sobrenome);
		u.setSenha(senha);
		
		return u;
	}
	
	public void verificarEntradas() {
		if (nome == null || nome.isEmpty())
			throw new ModelException("Informe seu nome.");
		if (sobrenome == null || sobrenome.isEmpty())
			throw new ModelException("Informe seu sobrenome.");
		if (email == null || email.isEmpty())
			throw new ModelException("Informe seu email.");
		if (senha == null || senha.isEmpty())
			throw new ModelException("Informe sua senha.");
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
