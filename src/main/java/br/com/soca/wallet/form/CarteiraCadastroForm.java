package br.com.soca.wallet.form;

import br.com.soca.wallet.exception.FormException;
import br.com.soca.wallet.model.Carteira;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.util.ContextUtil;

public class CarteiraCadastroForm implements Form {

	private String nome;

	public Carteira converter() {
		Usuario usuario = ContextUtil.getUsuario();
		Carteira carteira = new Carteira();
		carteira.setNome(nome);
		carteira.setUsuario(usuario);
		return carteira;
	}
	
	@Override
	public void verificarEntradas() {
		if (nome == null || nome.isEmpty())
			throw new FormException("Informe o nome da carteira.");
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
