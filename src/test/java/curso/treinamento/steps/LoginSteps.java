package curso.treinamento.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LoginSteps {

	// setando na classe o navegador
	WebDriver driver;

	@Dado("^que eu esteja na tela de login$")
	public void queEuEstejaNaTelaDeLogin() {
		// seta onde está o chrome driver no projeto
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");

		// navegador
		driver = new ChromeDriver();

		// get seta a url
		driver.get("http://newtours.demoaut.com/");
	}

	@Quando("^faço login com o usuário \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void façoLoginComOUsuárioESenha(String usuario, String senha) {
		// seta campo de usuario
		driver.findElement(By.name("userName")).sendKeys(usuario);

		// seta campo de senha
		driver.findElement(By.name("password")).sendKeys(senha);

		// clica no botão login
		driver.findElement(By.name("login")).click();
	}

	@Então("^sou autenticado com sucesso$")
	public void souAutenticadoComSucesso() {

	}
}
