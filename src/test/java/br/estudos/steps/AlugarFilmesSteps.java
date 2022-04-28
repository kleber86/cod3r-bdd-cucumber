package br.estudos.steps;

import br.estudos.entidades.Filme;
import br.estudos.entidades.NotaAluguel;
import br.estudos.service.AluguelService;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AlugarFilmesSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel notaAluguel;
    private String erro;

    @Dado("um filme em estoque de {int} unidades")
    public void umFilmeEmEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Dado("que o preço do alguel seja R$ {double}")
    public void queOPreçoDoAlguelSejaR$(Double double1) {
        filme.setAluguel(double1);
    }

    @Quando("alugar")
    public void alugar() {
        try {
            notaAluguel = aluguel.alugar(filme);
        }catch (RuntimeException e){
            erro = e.getMessage();
        }
    }

    @Então("o preço do aluguel será R$ {double}")
    public void oPreçoDoAluguelSeráR$(Double double1) {
        assertEquals(double1, notaAluguel.getPreco());
    }


    @Então("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = notaAluguel.getDataEntega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
        assertEquals(int1, filme.getEstoque());
    }

    @Então("não será possivel por falta de estoque")
    public void nãoSeráPossivelPorFaltaDeEstoque() {
        assertEquals("Filme sem estoque", erro);
    }
}
