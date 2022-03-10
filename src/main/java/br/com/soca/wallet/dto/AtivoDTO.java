package br.com.soca.wallet.dto;

import java.math.BigDecimal;

import br.com.soca.wallet.model.Ativo;

public class AtivoDTO {
    private Integer id;
    private Integer idCarteira;
    private Integer idUsuario;
    private String papel;
    private BigDecimal cotacao;
    private BigDecimal quantidade;

    public AtivoDTO(Ativo ativo){
        id = ativo.getId();
        idCarteira = ativo.getCarteira().getId();
        idUsuario = ativo.getUsuario().getId();
        papel = ativo.getPapel();
        cotacao = ativo.getCotacao();
        quantidade = ativo.getQuantidade();

    }
    

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIdCarteira() {
        return this.idCarteira;
    }

    public void setIdCarteira(Integer idCarteira) {
        this.idCarteira = idCarteira;
    }

    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


}
