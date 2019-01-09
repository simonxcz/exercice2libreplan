package Autom3.libreplan2;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilsPage extends ConfigurationPage {

	
	//Bouton créer
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//td[@class='z-button-cm' and contains(.,'Créer')]")
	WebElement bouton_creer;
	
	//Tableau titre colonne "Nom de profil"
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Nom de profil')]")
	WebElement colonne_nom_profil;
	
	//Tableau titre colonne "Actions"
	@FindBy(how = How.XPATH, using ="(//div[contains(text(),'Actions')])[1]")
	WebElement colonne_actions;

	
	public ProfilsPage(WebDriver driver) {
		super(driver);
	}

	public void assertProfilPage() {
		Assert.assertTrue("Vérification de la présence du bouton créer", this.bouton_creer.isDisplayed());
		Assert.assertTrue("Vérification de la présence du bouton créer", this.colonne_nom_profil.isDisplayed());
		Assert.assertTrue("Vérification de la présence du bouton créer", this.colonne_actions.isDisplayed());
	}
	
	public CreerProfilPage clickBoutonCreer(){
		this.bouton_creer.click();
		return PageFactory.initElements(driver, CreerProfilPage.class);
	}
}
