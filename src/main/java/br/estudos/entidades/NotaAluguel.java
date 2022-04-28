package br.estudos.entidades;

import java.util.Date;

public class NotaAluguel {

    private Double preco;
    private Date dataEntrega;

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getDataEntega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        dataEntrega = time;
    }
}
