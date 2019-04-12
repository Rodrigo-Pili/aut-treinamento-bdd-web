package curso.treinamento.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.LoginPage;
import curso.treinamento.pages.RegistroPage;
import curso.treinamento.setup.Hooks;

//metodo deprecionado - ja tem uma nova versao disponivel e voce esta usando o antigo

public class RegistroSteps {

	private LoginPage loginPage = new LoginPage(Hooks.getDriver());
	private RegistroPage registroPage = new RegistroPage(Hooks.getDriver());

	@Dado("^que eu esteja na tela de Registro$")
	public void que_eu_esteja_na_tela_de_Registro() {
		loginPage.clickRegister();
		Assert.assertTrue("A tela de registro não foi localizada.", registroPage.checkPage());
	}

	@Quando("^faço o preenchimento das informações da tela de Register$")
	public void faço_o_preenchimento_das_informações_da_tela_de_Register(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

		registroPage.preencherContactInformation(list.get(0).get("First Name"), list.get(0).get("Last Name"),
				list.get(0).get("Phone"), list.get(0).get("Email"));
		try {
			registroPage.preencherMailingIngormation(list.get(0).get("Address"), list.get(0).get("Address Complement"),
					list.get(0).get("City"), list.get(0).get("State Province"), list.get(0).get("Postal Code"),
					list.get(0).get("Country"));
		} catch (Exception e) {
			System.out.println(e);
		}
		registroPage.preencherUserInformation(list.get(0).get("User Name"), list.get(0).get("Password"),
				list.get(0).get("Confirm Passwaord"));
	}

	@Então("^sou registrado com sucesso$")
	public void sou_registrado_com_sucesso() throws Throwable {
		registroPage.clicaBotaoSubmit();
		Assert.assertTrue("Registro feito com sucesso", registroPage.checkRegistroFeito());
	}
}