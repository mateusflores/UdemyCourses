package entities;

public class Carro {
    private String name;
    private String placa;
    private Integer ano;

    public Carro(String name, String placa, Integer ano) {
        this.name = name;
        this.placa = placa;
        this.ano = ano;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
            return "\nNome: " + this.name + "\nPlaca: " + this.placa + "\nAno: " + this.ano;
    }
}
