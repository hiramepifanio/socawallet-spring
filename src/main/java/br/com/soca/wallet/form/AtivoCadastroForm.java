package br.com.soca.wallet.form;

import java.math.BigDecimal;

import br.com.soca.wallet.exception.FormException;
import br.com.soca.wallet.model.Ativo;
import br.com.soca.wallet.model.Carteira;
import br.com.soca.wallet.model.Usuario;
import br.com.soca.wallet.repository.CarteiraRepository;
import br.com.soca.wallet.util.ContextUtil;


public class AtivoCadastroForm implements Form{

    //private String email;
    private String papel;
    private BigDecimal cotacao;
    private BigDecimal quantidade;
    private Integer idCarteira;
    

    public Ativo converter(CarteiraRepository carteiraRepository) {

        System.out.println("c28");
        Usuario usuario = ContextUtil.getUsuario();
        System.out.println("c30");
        System.out.println(idCarteira);
        Carteira  carteira = carteiraRepository.findById(idCarteira).get();
        System.out.println("c32");
        Ativo ativo = new Ativo();
        

        try{
            System.out.println("c37");
            ativo.setCarteira(carteira);
        } catch(Exception e){
            System.out.println("Carteira invalida");
        }
        

        try{
            System.out.println("c45");
            ativo.setUsuario(usuario);
        } catch(Exception e) {
            System.out.println("Usuario invalido");
        }
        
        System.out.println("c51");
        ativo.setPapel(papel);
        System.out.println("c53");
        ativo.setCotacao(cotacao);
        System.out.println("c55");
        ativo.setQuantidade(quantidade);
        return ativo;        
    }

    @Override
    public void verificarEntradas() {
        if (papel== null || papel.isEmpty())
            throw new FormException("Informe o nome do Ativo");
        if (cotacao == null)
            throw new FormException("Informe a cotação");
        if (quantidade == null)
            throw new FormException("Informe a quantidade");

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


}
