package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//Cucumber ile junit'in entegre olmasını sağlayan scenario çalıştırıcı notasyonu
@CucumberOptions(plugin = {"pretty",//pretty->konsolda scenariolar ile ilgili ayrıntılı bilgi verir
        "html:target/default-cucumber-reports.html",
        "json:target/json-reports/cucumber.json",
        "junit:target/xml-report/cucumber.xml",}, //"rerun:TestOutput/failed_scenario.txt"},
        /*
rerun plugin'i sayesinde fail olan scenariolarımızı yolunu belirttiğimiz .txt dosya için tutacaktır
 */
        features = "src/test/resources", //features package'ının yolu (content root)

        glue = {"techproed/StepDefinitions","techproed/Hooks"}, //stepDefinitions package ismi
        tags = "", //Hangi scenarioları bu tag ıle belirtirsek o scenariolar çalışır

        dryRun = false //true seçersek scenariolari kontrol eder browser'ı çalıştırmaz
        //monochrome = true//-->true kullanırsak konsoldaki çıktıları tek renk(siyah) olarak verir
)



public class Runner {
}