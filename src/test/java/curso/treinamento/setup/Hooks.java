package curso.treinamento.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	// para que criar : é denro da hooks que fica o Objeto driver - O navegador
	// além disso colocar o que inicia antes do teste e depois do teste - After
	// Before, ou seja, são as pré e pós condições
	// depois colocaremos uns switch para acessarmos mais de um browser

	public static WebDriver driver;

	@Before
	public void startTest() {

		// precisamos setar onde esta o driver do chrome driver e depois abrir o
		// navegador
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		// usado apenas para maximizar a tela do chromeDriver
		driver.manage().window().maximize();

		// depois precisamos falar em qual url nos queremos acessar quando iniciarmos
		// nosso teste
		driver.get("http://newtours.demoaut.com/");
	}

	@After
	public void finishTest(Scenario scenario) {
		// quase sempre colocamos no after o comando para fechar o chromeDriver para não
		// ter problemas de estourar a memoria do pc
		driver.close();
	}

	// esse metodo apenas retorna o driver para gente
	public static WebDriver getDriver() {
		return driver;
	}
}