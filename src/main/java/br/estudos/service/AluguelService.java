package br.estudos.service;

import br.estudos.entidades.Filme;
import br.estudos.entidades.NotaAluguel;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        NotaAluguel notaAluguel = new NotaAluguel();
        notaAluguel.setPreco(filme.getAluguel());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        notaAluguel.setDataEntrega(cal.getTime());
        filme.setEstoque(filme.getEstoque() - 1);
        return notaAluguel;
    }
}
