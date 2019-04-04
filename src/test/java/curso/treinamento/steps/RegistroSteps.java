package curso.treinamento.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

//metodo deprecionado - ja tem uma nova versao disponivel e voce esta usando o antigo

public class RegistroSteps {

	// setando na classe o navegador
	WebDriver driver;

	@Dado("^que eu esteja na tela de Registro$")
	public void que_eu_esteja_na_tela_de_Registro() {
		// clicando na aba "Register"
		driver.findElement(By.linkText("REGISTER")).click();

		// xpath é o caminho do elemento
		// para criar um xpath - (crtl + f) / (//) / (tipo do elemento (img) e copia o
		// src )
		// isDisplayed valida se o elemento esta na tela
		Assert.assertTrue("Página 'Register' não apresentada com sucesso.",
				driver.findElement(By.xpath("//img[@src='/images/masts/mast_register.gif']")).isDisplayed());
	}

	@Quando("^faço o preenchimento das informações da tela de Register$")
	public void faço_o_preenchimento_das_informações_da_tela_de_Register(DataTable dataTable) {
		// pega o dataTable e poem em uma lista
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

		// preenche o campo 'First Name' com o valor que contem na posição 0 da lista do
		// dataTable First Name
		driver.findElement(By.name("firstName")).sendKeys(list.get(0).get("First Name"));

		// preenche o campo 'lastName' com o valor que contem na posição 0 da lista do
		// dataTable Last Name
		driver.findElement(By.xpath("//input[@name='lastName'][@size='20']")).sendKeys(list.get(0).get("Last Name"));

//		 procura o elemento que contem no texto dele a palavra 'Phone'
//		driver.findElement(By.xpath("//b[contains(text(),'Phone:')]"));
//
//		 procura o elemento que contem no texto dele a palavra 'To create'
//		driver.findElement(By.xpath("//font[contains(text(),'To create')]"));
//
//		 procura o elemento que tem o text 'Password'
//		driver.findElement(By.xpath("//b[text()='Password:']"));
//
//		 procurar o elemento a partir de um outro elemento
//		driver.findElement(By.xpath("//input[@name='phone']//following::input[1]"));
//		driver.findElement(By.xpath("//input[@name='phone']//following::input[@name='postalCode']"));
//		driver.findElement(By.xpath("//input[@name='phone']//following::select[@name='country']"));
//		driver.findElement(By.xpath("//input[@name='password']//preceding::input[1]"));

		// HIERARQUIA ID -> NAME -> CLASS

		// preenche o campo 'phone' com o valor que contem na posição 0 da lista do
		// dataTable
		// Phone
		driver.findElement(By.name("phone")).sendKeys(list.get(0).get("Phone"));

		// preenche o campo 'userName' com o valor que contem na posição 0 da lista do
		// dataTable Email
		driver.findElement(By.id("userName")).sendKeys(list.get(0).get("Email"));

		// preenche o campo 'address1' com o valor que contem na posição 0 da lista do
		// dataTable Address
		driver.findElement(By.name("address1")).sendKeys(list.get(0).get("Address"));

		// preenche o campo 'address2' com o valor que contem na posição 0 da lista do
		// dataTable Address Complement
		driver.findElement(By.name("address2")).sendKeys(list.get(0).get("Address Complement"));

		// preenche o campo 'city' com o valor que ontem na posição 0 da lista do
		// dataTable City
		driver.findElement(By.name("city")).sendKeys(list.get(0).get("City"));

		// preenche o campo 'state' com o valor que contem na posição 0 da lista do
		// dataTable State Province
		driver.findElement(By.name("state")).sendKeys(list.get(0).get("State Province"));

		// preenche o campo '' com o valor que contem na posição 0 da lista do dataTable
		// Postal Code
		driver.findElement(By.name("postalCode")).sendKeys(list.get(0).get("Postal Code"));

		// preencher o campo '' com o valor que contem na posição 0 da lista do
		// dataTable Country
		WebElement meuElementoDaCombobox = driver.findElement(By.name("country"));
		Select combobox = new Select(meuElementoDaCombobox);
		combobox.selectByVisibleText("BRAZIL");

		// preeche o campo 'email' com o valor que contem na posição 0 da lista do
		// dataTable
		// User Name
		driver.findElement(By.id("email")).sendKeys(list.get(0).get("User Name"));

		// preenche o campo 'password' com o valor que contem na posição 0 da lista do
		// dataTable
		// Password
		driver.findElement(By.name("password")).sendKeys(list.get(0).get("Password"));

		// preenche o campo 'confirmPassword' com o valor que contem na posição 0 da
		// lista do dataTable
		// Confirm Passwaord
		driver.findElement(By.name("confirmPassword")).sendKeys(list.get(0).get("Confirm Passwaord"));

		// clica no botão 'SUBMIT'
		driver.findElement(By.xpath("//input[@name='register']")).click();
	}

	@Então("^sou registrado com sucesso$")
	public void sou_registrado_com_sucesso() throws Throwable {

	}
}