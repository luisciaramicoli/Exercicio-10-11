package application;

public class Main {
    public static void main(String[] args) {
        PagamentoCartaoCredito pag1 = new PagamentoCartaoCredito(2, "Exemplo de Pagamento", "1234566", "Fulano", "11/26", "345", 2);

        pag1.exibirDetalhesPagamento();
        Priorizavel pri = pag1;
        Pagamento pag2 = pag1;

        pri.definirPrioridade(4);

        System.out.println(pag1.obterNivelPrioridade());
    
        pag1.processar();

        PagamentoBoleto pag3 = new PagamentoBoleto(300, "Exemplo de Pagamento");

        pag3.exibirDetalhesPagamento();

        Pagamento pagamentos[] = {pag1,pag3};

        for(Pagamento p : pagamentos){
            System.out.println(p.getIdTransacao());
        }
    }
}

