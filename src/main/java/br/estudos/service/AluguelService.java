package br.estudos.service;

import br.estudos.entidades.Filme;
import br.estudos.entidades.NotaAluguel;
import br.estudos.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipo) {
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel notaAluguel = new NotaAluguel();

        if("extendido".equals(tipo)){
            notaAluguel.setPreco(filme.getAluguel() * 2);
            notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
            notaAluguel.setPontuacao(2);
        }else{
            notaAluguel.setPreco(filme.getAluguel());
            notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
            notaAluguel.setPontuacao(1);
        }

        filme.setEstoque(filme.getEstoque() - 1);
        return notaAluguel;
    }
}
