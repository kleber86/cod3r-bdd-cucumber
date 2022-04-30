package br.estudos.steps;

import br.estudos.entidades.Filme;
import br.estudos.entidades.NotaAluguel;
import br.estudos.service.AluguelService;
import br.estudos.utils.DateUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AlugarFilmesSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel notaAluguel;
    private String erro;
    private String tipoAluguel;

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
            notaAluguel = aluguel.alugar(filme, tipoAluguel);
        }catch (RuntimeException e){
            erro = e.getMessage();
        }
    }

    @Então("o preço do aluguel será R$ {double}")
    public void oPreçoDoAluguelSeráR$(Double double1) {
        assertEquals(double1, notaAluguel.getPreco());
    }


    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
        assertEquals(int1, filme.getEstoque());
    }

    @Então("não será possivel por falta de estoque")
    public void nãoSeráPossivelPorFaltaDeEstoque() {
        assertEquals("Filme sem estoque", erro);
    }

    @Dado("que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo;
    }

    @Então("a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(Integer int1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
        Date dataReal = notaAluguel.getDataEntega();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("a pontuação recebida será de {int} pontos")
    public void aPontuaçãoRecebidaSeráDePontos(Integer int1) {
       assertEquals(int1, notaAluguel.getPontuacao());
    }
}
