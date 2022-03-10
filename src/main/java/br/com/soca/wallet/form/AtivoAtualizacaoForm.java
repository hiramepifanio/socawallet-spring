package br.com.soca.wallet.form;

import java.math.BigDecimal;

import br.com.soca.wallet.model.Ativo;
import br.com.soca.wallet.repository.CarteiraRepository;

public class AtivoAtualizacaoForm implements Form{

	private String papel;
	private BigDecimal cotacao;
	private BigDecimal quantidade;
    private Integer idCarteira;

    public void atualizarAtivo(Ativo ativo, CarteiraRepository carteiraRepository){
        if (!(idCarteira == null)) ativo.setCarteira(carteiraRepository.findById(idCarteira).get());
        if (!(papel == null)) ativo.setPapel(papel);
        if (!(cotacao == null)) ativo.setCotacao(cotacao);
        if (!(quantidade == null)) ativo.setQuantidade(quantidade);

    }

    @Override
    public void verificarEntradas(){

    }

    public Integer getIdCarteira() {
        return this.idCarteira;
    }

    public void setIdCarteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public String getPapel() {
        return this.papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public BigDecimal getCotacao() {
        return this.cotacao;
    }

    public void setCotacao(BigDecimal cotacao) {
        this.cotacao = cotacao;
    }

    public BigDecimal getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

}

