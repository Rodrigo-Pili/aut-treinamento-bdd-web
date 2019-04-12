package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistroPage {

	public RegistroPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	WebElement campoFirstName;

	@FindBy(name = "lastName")
	WebElement campolastName;

	@FindBy(name = "phone")
	WebElement campoPhone;

	@FindBy(id = "userName")
	WebElement campoEmail;

	@FindBy(name = "address1")
	WebElement campoAddress;

	@FindBy(name = "address2")
	WebElement campoAddressComplement;

	@FindBy(name = "city")
	WebElement campoCity;

	@FindBy(name = "state")
	WebElement campoState;

	@FindBy(name = "postalCode")
	WebElement campoPostalCode;

	@FindBy(name = "country")
	WebElement campoComboBoxCountry;

	@FindBy(id = "email")
	WebElement campoUserName;

	@FindBy(name = "password")
	WebElement campoPassword;

	@FindBy(name = "confirmPassword")
	WebElement campoConfirmPassword;

	@FindBy(xpath = "//img[@src='/images/masts/mast_register.gif']")
	WebElement titlePage;

	@FindBy(name = "register")
	WebElement botaoSubmit;

	@FindBy(xpath = "//img[@src='/images/masts/mast_register.gif']//following::font[1]")
	WebElement registroFeitoComSucesso;

	public boolean checkPage() {
		return titlePage.isDisplayed();
	}

	public void preencherContactInformation(String firstName, String lastName, String phone, String email) {
		campoFirstName.sendKeys(firstName);
		campolastName.sendKeys(lastName);
		campoPhone.sendKeys(phone);
		campoEmail.sendKeys(email);
	}

	public void preencherMailingIngormation(String address, String addressComplement, String city, String state,
			String postalCode, String country) {
		campoAddress.sendKeys(address);
		campoAddressComplement.sendKeys(addressComplement);
		campoCity.sendKeys(city);
		campoState.sendKeys(state);
		campoPostalCode.sendKeys(postalCode);
		new Select(campoComboBoxCountry).deselectByValue(country);
	}

	public void preencherUserInformation(String userName, String password, String confirmPassword) {
		campoUserName.sendKeys(userName);
		campoPassword.sendKeys(password);
		campoConfirmPassword.sendKeys(confirmPassword);
	}

	public void clicaBotaoSubmit() {
		botaoSubmit.click();
	}

	public boolean checkRegistroFeito() {
		return registroFeitoComSucesso.isDisplayed();
	}
}