package br.com.soca.wallet.form;

import br.com.soca.wallet.model.Carteira;

public class CarteiraAtualizacaoForm implements Form {

	private String nome;
	
	public void atualizarCarteira(Carteira carteira) {
		if (!(nome == null)) carteira.setNome(nome);
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
}
