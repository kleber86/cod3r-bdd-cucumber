package br.estudos.steps;

import br.estudos.entidades.Filme;
import br.estudos.entidades.NotaAluguel;
import br.estudos.entidades.TipoAluguel;
import br.estudos.service.AluguelService;
import br.estudos.utils.DateUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AlugarFilmesSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel notaAluguel;
    private String erro;
    private TipoAluguel tipoAluguel;

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
        } catch (RuntimeException e) {
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
        tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL :
                tipo.equals("extendido") ? TipoAluguel.EXTENDIDO :
                         TipoAluguel.COMUM;
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

    @Dado("um filme")
    public void umFilme(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Double.parseDouble(map.get("preco")));

        String tipo = map.get("tipo");
        tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL :
                tipo.equals("extendido") ? TipoAluguel.EXTENDIDO :
                        TipoAluguel.COMUM;
    }
}
