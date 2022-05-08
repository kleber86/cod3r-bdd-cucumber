package br.estudos.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/reporte.html", "json:target/report.json"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        features = "src/test/resources/features/inserir_conta.feature",
        glue = "br.estudos.steps",
        tags = "not @ignore"
)
public class Runner {
}
