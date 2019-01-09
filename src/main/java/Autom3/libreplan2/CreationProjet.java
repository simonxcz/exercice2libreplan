package Autom3.libreplan2;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreationProjet {



	//---------------------------------------------------------
	//WebElement
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-modal-header z-window-modal-header-move']")
	WebElement assert_affichage_popup;
	//Assert pas xxxx	
	@FindBy(how = How.XPATH, using ="//td[contains(@id, 's7-chdextr')]/div/span//input")
	WebElement assert_modele_field;

	//[begin]WebElement pour saisie formulaire de création d'un projet
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'p7-cell')]/input")
	WebElement field_name_project;

	@FindBy(how = How.XPATH, using ="//tbody[contains(@id, 'y7-empty')]/tr[1]")
	WebElement assert_liste_row_is_empty;

	@FindBy(how = How.XPATH, using ="//input[contains(@id, 'a-real')]")
	WebElement assert_calendrier_default;

	@FindBy(how = How.XPATH, using ="//td[contains(@id, 'n9-chdextr')]//input")
	WebElement assert_echeance_field;

	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'q9-cell')]//input")
	WebElement assert_client_field;


	@FindBy(how = How.XPATH, using ="//td[contains(@id, '48-chdex')]//input")
	WebElement assert_checkbox_code;

	@FindBy(how = How.XPATH, using ="//td[text()='Accepter']")
	WebElement assert_btn_accepter;

	@FindBy(how = How.XPATH, using ="//td[text()='Annuler']")
	WebElement assert_btn_annuler;


	//---------------------------------------------------------




	//WebElement associés pour la creation d'un projet
	@FindBy(how = How.XPATH, using ="//table[contains(@id, '28-real')]//input[contains(@id, '38')]")
	WebElement checkbox_generate_code;

	@FindBy(how = How.XPATH, using ="//td[contains(@id,'38-chdex')]/input")
	WebElement field_code;


	@FindBy(how = How.XPATH, using ="//div[contains(@id,'k9-cell')]//input")
	WebElement begin_date;

	@FindBy(how = How.XPATH, using ="//div[contains(@id,'n9-cell')]/i/input")
	WebElement end_date;

	@FindBy(how = How.XPATH, using ="//td[text()='Accepter']")
	WebElement btn_accept;

	//------------------------------------------	
	WebDriver driver;
	//Constructeur
	public CreationProjet(WebDriver driver) {
		this.driver = driver;
	//	PageFactory.initElements(driver,this);

	}

	//Creation projet
	public ProjetEdition creationProjet(String projet, String code, int date_de_debut, int date_de_fin) throws Exception{

		field_name_project.sendKeys(projet);
		checkbox_generate_code.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		field_code.click();
		field_code.clear();
		field_code.sendKeys(code);
		begin_date.click();
		begin_date.clear();
		begin_date.sendKeys(date_de_debut+" "+ "déc.2018");
		end_date.clear();
		end_date.sendKeys(date_de_fin+" "+ "déc.2018");
		btn_accept.click();
		//retour à la page Calendrier
		return PageFactory.initElements(driver, ProjetEdition.class);
	}

	public void CreationProjetAssert01() throws Exception{

		Assert.assertTrue("Apparition popup", this.assert_affichage_popup.getText().equals("Créer un nouveau projet"));
		System.out.println("Verification de la présence des éléments du formulaire de création d'un projet");
		//Verification si champs "nom" est bien vide
		Assert.assertTrue("champs_nom non vide", this.field_name_project.getText().isEmpty());
		//Verification si champs de saisie vide
		Assert.assertTrue("champs_nom non vide", this.assert_modele_field.getText().isEmpty());
		//Verification si liste vide sur sa premiere ligne seulement
		Assert.assertTrue("champs_nom non vide", this.assert_liste_row_is_empty.getText().isEmpty());
		//Verification si champs de texte est bien vide
		Assert.assertTrue("champs_nom non vide", this.assert_echeance_field.getText().isEmpty());
		Assert.assertTrue("champs_nom non vide", this.assert_client_field.getText().isEmpty());
		//Verification de la liste déroulante avec pour valeur par défaut "Default"
		Assert.assertTrue("il n'est pas positionné sur la valeur default", this.assert_calendrier_default.getAttribute("value").equals("Default"));
		//Verification si presence bouton
		Assert.assertTrue("bouton Accepter non présent", this.assert_btn_accepter.isDisplayed());
		Assert.assertTrue("bouton Accepter non présent", this.assert_btn_annuler.isDisplayed());
		//Verification si checkbox non coché
		Assert.assertTrue("checkbox non coche", this.assert_checkbox_code.isSelected());
		System.out.println("Verification terminée, tous les éléments du formulaire sont bien présents");
	}

}