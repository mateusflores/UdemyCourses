package entities;

public class PessoaFisica extends Pessoa {
    private Double gastosSaude;

    public PessoaFisica() {
        super() ;
    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public Double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(Double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public Double totalPago() {
        double total = 0.0;
        double abatimentoSaude = this.gastosSaude / 2;
        if (this.getRendaAnual() < 20000) {
            total = (this.getRendaAnual() * 0.15) - abatimentoSaude;
        } else {
            total = ((this.getRendaAnual() * 0.25) - abatimentoSaude);
        }
        return total;
    }
}
