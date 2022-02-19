package br.com.soca.wallet.dto;

import br.com.soca.wallet.model.Carteira;

public class CarteiraDTO {

	private Integer id;
	private Integer usuarioId;
	private String nome;

	public CarteiraDTO(Carteira carteira) {
		id = carteira.getId();
		usuarioId = carteira.getUsuario().getId();
		nome = carteira.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
