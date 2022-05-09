package br.estudos.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("que estou acessando a aplicacao")
    public void queEstouAcessandoAAplicacao() {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @Quando("informo o usuario {string}")
    public void informoOUsuario(String string) {
        driver.findElement(By.id("email")).sendKeys(string);
    }

    @Quando("a senha {string}")
    public void aSenha(String string) {
        driver.findElement(By.id("senha")).sendKeys(string);
    }

    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Entao("visualizo a pagina inicial")
    public void visualizoAPaginaInicial() {
        String validacaoLogin = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        assertEquals("Bem vindo, Kleber!", validacaoLogin);
    }

    @Quando("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("informo a conta {string}")
    public void informoAConta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);
    }

    @Quando("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Entao("a conta eh inserida com sucesso")
    public void aContaEhInseridaComSucesso() {
        String validacaoLogin = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        assertEquals("Conta adicionada com sucesso!", validacaoLogin);
    }

    @Entao("sou notificado que o nome da conta eh obrigatoria")
    public void souNotificadoQueONomeDaContaEhObrigatoria() {
        String validacaoLogin = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        assertEquals("Informe o nome da conta", validacaoLogin);
    }

    @Entao("sou notificcado que ja existe uma conta com esse nome")
    public void souNotificcadoQueJaExisteUmaContaComEsseNome() {
        String validacaoLogin = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        assertEquals("Já existe uma conta com esse nome!", validacaoLogin);
    }

    @Então("recebo a mensagem {string}")
    public void receboAMensagem(String string) {
        String validacaoLogin = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
        assertEquals(string, validacaoLogin);
    }

    @After(order = 1, value = "not @unitarios")
    public void screenshot(Scenario cenario){
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("target/screenshot/"+cenario.getId()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After(order = 0, value = "not @unitarios")
    public void fecharBrowser(){
        driver.quit();
    }
}
