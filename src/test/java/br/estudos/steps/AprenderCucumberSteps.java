package br.estudos.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AprenderCucumberSteps {

    @Dado("que criei o arquivo corretamente")
    public void que_criei_o_arquivo_corretamente() {
    }

    @Quando("executa-lo")
    public void executa_lo() {
    }

    @Então("a especificação deve finalizar com sucesso")
    public void a_especificação_deve_finalizar_com_sucesso() {
    }

    private Integer contador = 0;
    @Dado("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(Integer int1) {
        contador = int1;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contador = contador + int1;
    }

    @Então("o valor do contador é {int}")
    public void oValorDoContadorÉ(Integer int1) {
       assertEquals(int1, contador);
    }

    Date entrega = new Date();

    @Dado("que a entrega é dia {int}\\/{int}\\/{int}")
    public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }
    @Quando("a entrega atrasar em (\\d+) (.+)$")
    public void aEntregaAtrasarEmDias(Integer int1, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if(tempo.equals("dias")){
            cal.add(Calendar.DAY_OF_MONTH, int1);
        }
        if(tempo.equals("meses")){
            cal.add(Calendar.MONTH, int1);
        }
        entrega = cal.getTime();
    }
    @Então("a entrefa será efetuada em (\\d{2}\\/\\d{2}/\\d{4})$")
    public void aEntrefaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        assertEquals(data, dataFormatada);
    }


    @Dado("que o ticket( especial)? é (A.\\d{3})$")
    public void queOTicketÉAF(String tipo, String arg1) {
    }

    @Dado("que o valor da passagem é R\\$ (\\d+),(\\d+)$")
    public void queOValorDaPassagemÉR$(int arg1, int arg2) {

    }

    @Dado("que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String string) {

    }

    @Dado("que o telefone do passageiro é (9\\d{3}}-\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(String telefone) {

    }

    @Quando("criar os steps")
    public void criarOsSteps() {

    }

    @Então("o teste vai funcionar")
    public void oTesteVaiFuncionar() {

    }
}
