package entities;

public class PessoaJuridica extends Pessoa {
    private int numeroFuncionarios;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, Double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public Double totalPago() {
        double total = 0;

        if (this.numeroFuncionarios > 10) {
            total = this.getRendaAnual() * 0.14;
        } else {
            total = this.getRendaAnual() * 0.16;
        }
        return total;
    }
}
