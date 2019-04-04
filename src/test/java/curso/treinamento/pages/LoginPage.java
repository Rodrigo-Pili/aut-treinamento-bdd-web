package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// serve para procurar um elemento pelo name com a propriedade userName
	@FindBy(name = "userName")
	WebElement campoUsuario;

	@FindBy(name = "password")
	WebElement campoPassword;

	@FindBy(name = "login")
	WebElement botaoSign;
}
