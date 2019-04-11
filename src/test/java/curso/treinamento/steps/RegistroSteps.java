package curso.treinamento.steps;

import java.util.List;
import java.util.Map;

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

	}

	@Quando("^faço o preenchimento das informações da tela de Register$")
	public void faço_o_preenchimento_das_informações_da_tela_de_Register(DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

	}

	@Então("^sou registrado com sucesso$")
	public void sou_registrado_com_sucesso() throws Throwable {

	}
}