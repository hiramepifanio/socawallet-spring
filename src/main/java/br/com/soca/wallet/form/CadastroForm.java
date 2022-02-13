package br.com.soca.wallet.form;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.soca.wallet.model.Usuario;

public class CadastroForm {

	private String nome;
	private String email;
	private String senha;
	
	public Usuario convert() {
		Usuario u = new Usuario();
		u.setNome(nome);
		u.setEmail(email);
		u.setSenha(new BCryptPasswordEncoder().encode(senha));
		
		return u;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
