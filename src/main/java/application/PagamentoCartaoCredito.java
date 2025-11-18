package application;

import lombok.Getter;

@Getter
public class PagamentoCartaoCredito extends Pagamento implements Priorizavel, Processavel {
    private String numeroCartao;
    private String titularCartao;
    private String validadeCartao;
    private String cvv;

    private int prioridade;

    public PagamentoCartaoCredito(
        double valor, String descricao, String numeroCartao,
        String titularCartao, String validadeCartao, String cvv,
        int prioridade
    ) {
        super(valor, descricao);
        this.numeroCartao = numeroCartao;
        this.titularCartao = titularCartao;
        this.validadeCartao = validadeCartao;
        this.cvv = cvv;
        this.prioridade = prioridade;
    }

    @Override
    public boolean autenticar() {
        System.out.println("Autenticando cartão para transação " + this.getIdTransacao());
        return true;
    }
    
    @Override
    public boolean validarDados() {
        System.out.println("Valida-ndo dados do cartão para transação " + this.getIdTransacao());
        return true;
    }

    @Override
    public int obterNivelPrioridade() {
        return this.prioridade;
    }

    @Override
    public void definirPrioridade(int prioridade) {
        if(prioridade >= 1 && prioridade <= 10) {
            this.prioridade = prioridade;
        } else {
            System.out.println("Nível de Prioridade Inválido (1-10)");
        }
    }

    @Override
    public boolean processar() {
        System.out.println("Processando pagamento via cartão ID: " + this.getIdTransacao());
        System.out.println("Transação " + this.getIdTransacao() + " APROVADO");
        this.setStatus("Aprovado");
        return true;
    }

    @Override
    public String obterStatusProcessamento() {
        return "Processamento via cartão " + this.getIdTransacao() + " : " + this.getStatus();
    }
}