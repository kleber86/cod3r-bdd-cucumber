package br.estudos.service;

import br.estudos.entidades.Filme;
import br.estudos.entidades.NotaAluguel;
import br.estudos.entidades.TipoAluguel;
import br.estudos.utils.DateUtils;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel notaAluguel = new NotaAluguel();
        switch (tipo){
            case COMUM:
                notaAluguel.setPreco(filme.getAluguel());
                notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
                notaAluguel.setPontuacao(1);
                break;
            case EXTENDIDO:
                notaAluguel.setPreco(filme.getAluguel() * 2);
                notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
                notaAluguel.setPontuacao(2);
                break;
            case SEMANAL:
                notaAluguel.setPreco(filme.getAluguel() * 3);
                notaAluguel.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
                notaAluguel.setPontuacao(3);
                break;
        }

        filme.setEstoque(filme.getEstoque() - 1);
        return notaAluguel;
    }
}
