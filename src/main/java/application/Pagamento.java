package application;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Pagamento {
    private String idTransacao;
    private double valor;
    private LocalDateTime dataHora;
    private String descricao;
    @Setter(AccessLevel.PROTECTED)
    private String status;

    public void exibirDetalhesPagamento() {
        System.out.println("--- Detalhes do Pagamento ---");
        System.out.println("ID: " + this.idTransacao);
        System.out.println("Valor: R$ " + this.valor);
        System.out.println("Data/Hora: " + this.dataHora);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Status: " + this.status);
    }

    private String gerarIdUnico() {
        return "TRA-" + UUID.randomUUID().toString().toUpperCase();
    }

    public Pagamento(double valor, String descricao) {
        this.idTransacao = gerarIdUnico();
        this.valor = valor;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
        this.status = "Pendente";
    }

    // protected void setStatus(String status) {
    //     this.status = status;
    // }

    public abstract boolean autenticar();
    public abstract boolean validarDados();
}