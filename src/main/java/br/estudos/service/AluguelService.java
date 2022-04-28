package br.estudos.service;

import br.estudos.entidades.Filme;
import br.estudos.entidades.NotaAluguel;
import br.estudos.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel notaAluguel = new NotaAluguel();
        notaAluguel.setPreco(filme.getAluguel());
        notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return notaAluguel;
    }
}
