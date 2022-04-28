package br.estudos.entidades;

public class Filme {

    private Integer estoque;
    private Double aluguel;

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setAluguel(Double valor) {
        this.aluguel = valor;
    }

    public Double getAluguel() {
        return aluguel;
    }

    public Integer getEstoque() {
        return estoque;
    }
}
