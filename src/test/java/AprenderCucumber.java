import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AprenderCucumber {

    @Dado("que criei o arquivo corretamente")
    public void que_criei_o_arquivo_corretamente() {
    }

    @Quando("executa-lo")
    public void executa_lo() {
    }

    @Então("a especificação deve finalizar com sucesso")
    public void a_especificação_deve_finalizar_com_sucesso() {
    }

    private int contador = 0;
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
        System.out.println(int1);
        System.out.println(contador);
    }
}
