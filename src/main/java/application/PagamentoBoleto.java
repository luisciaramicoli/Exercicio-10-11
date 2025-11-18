package application;

public class PagamentoBoleto extends Pagamento implements Rastreavel {
    private String codigoRastreamento;



     @Override
    public boolean autenticar() {
        System.out.println("Autenticando boleto para transação " + this.getIdTransacao());
        return true;
    }
    
    @Override
    public boolean validarDados() {
        System.out.println("Valida-ndo dados do boleto para transação " + this.getIdTransacao());
        return true;
    }

    public PagamentoBoleto(double valor, String descricao){
        super(valor,descricao);
        this.codigoRastreamento = "BLT-" + this.getIdTransacao();
    }

    @Override
    public String obterCodigoRastreamento(){
        return this.codigoRastreamento;
    }

    @Override 
    public String verificarStatusRastreamento(){
        return "Boleto ID " + this.codigoRastreamento;
    }
}