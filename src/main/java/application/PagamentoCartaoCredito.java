package application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoCartaoCredito extends Pagamento {
    private String numeroCartao;
    private String titularCartao;
    private String validadeCartao;
    private String cvv;

    public PagamentoCartaoCredito(double valor, String descricao, String numeroCartao, String titularCartao, String validadeCartao, String cvv){
        super(valor,descricao);
        this.numeroCartao = numeroCartao;
        this.titularCartao = titularCartao;
        this.validadeCartao = validadeCartao;
        this.cvv= cvv;
    }
    @Override
    public boolean autenticar(){
        System.out.println("Autenticando cartão para transação " + this.getIdTransacao());
        return true;
    }
    
    @Override
    public boolean validarDados(){
        System.out.println("Validando dados do cartao para transação " + this.getIdTransacao());
        return true;
    }
}
