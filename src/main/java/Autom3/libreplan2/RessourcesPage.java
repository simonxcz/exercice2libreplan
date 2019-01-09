package Autom3.libreplan2;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RessourcesPage extends GenericPage {

	//Bouton creer ressource
	@FindBy(how = How.XPATH, using ="//table/descendant::td[contains(.,'Créer')]")
	WebElement button_creer_ressources;
	
	//Bouton modifier
	@FindBy(how = How.XPATH, using ="(//span[@title='Modifier'])[2]")
	WebElement critere_test_bouton_modifier;
	
	//Titre Types de critères liste
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Types de')]")
	WebElement titre_type_de_criteres;
	
	//Types de critères deuxième ligne
	@FindBy(how = How.XPATH, using ="(//span[contains(text(),'Critère - Test bouton')])[1]")
	WebElement deuxieme_ligne;
	
	//Types de critères titre deuxième ligne
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'2')]")
	WebElement titre_type_de_criteres2;
	

	public RessourcesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public CreerTypeCriterePage clickButtonCreer() throws InterruptedException {
		button_creer_ressources.click();
		return PageFactory.initElements(driver, CreerTypeCriterePage.class);
	}
	

	public CreerTypeCriterePage clickBoutonModifierCritere() throws InterruptedException {
		Thread.sleep(3000);
		this.critere_test_bouton_modifier.click();
		return PageFactory.initElements(driver, CreerTypeCriterePage.class);
	}
	
	public void assertTitle(String s) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(this.titre_type_de_criteres.getText());
		Assert.assertTrue("Vérification du titre", this.titre_type_de_criteres.getText().equals("Types de critères Liste"));
	}
	
	public void assertTitleModification() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(this.titre_type_de_criteres2.getText().equals("Modifier Type de critère: Critère - Test bouton 2"));
	}
	
	public CreerTypeCriterePage choisirDeuxiemeCritereListe() throws Exception {
		Thread.sleep(2000);
		deuxieme_ligne.click();
		return PageFactory.initElements(driver, CreerTypeCriterePage.class);
	}
	
	

}
