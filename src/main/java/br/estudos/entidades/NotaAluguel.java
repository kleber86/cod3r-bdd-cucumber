package br.estudos.entidades;

import java.util.Date;

public class NotaAluguel {

    private Double preco;
    private Date dataEntrega;
    private Integer pontuacao;

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

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao){
        this.pontuacao = pontuacao;
    }
}
