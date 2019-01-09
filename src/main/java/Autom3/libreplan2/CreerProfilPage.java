package Autom3.libreplan2;

import java.util.List;

import javax.security.auth.login.Configuration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CreerProfilPage extends ConfigurationPage {

	
	//Champ nom
	@FindBy(how = How.XPATH, using ="//tr[contains(@id, '85')]//input")
	WebElement name_field;
	  
	//Champ nom
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Nom')]")
	WebElement name_title_field;

	
	//Bouton enregistrer
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Enregistrer')]")
	WebElement bouton_enregistrer;
	
	//Bouton sauver et continuer
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Sauver et continuer')]")
	WebElement bouton_sauver_continuer;
	
	//Bouton annuler
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Annuler')]")
	WebElement bouton_annuler;
	
	//Bouton annuler
	@FindBy(how = How.XPATH, using ="//*[@class=\"z-row\"]")
	WebElement champ_nom_over;
	
	//Onglet associations bouton
	@FindBy(how = How.XPATH, using ="//i[contains(@class,'btn')]")
	WebElement onglet_asso;
	
	//Bouton "Ajouter un rôle"
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Ajouter un rôle')]")
	WebElement bouton_ajouter_role;
	
	//Bouton "Ajouter un rôle"
	@FindBy(how = How.XPATH, using ="//input[@autocomplete='off' and @type='text']")
	WebElement role_afficher;
	
	//Bouton "Nouvel ajout"
	@FindBy(how = How.XPATH, using ="//div[contains(@id,'s4-cell')]")
	WebElement role_ajouter;
	
	//Poubelle
	@FindBy(how = How.XPATH, using ="(//img[contains(@src,'ico_borrar')])[8]")
	WebElement poubelle;
	
			
	
	public CreerProfilPage(WebDriver driver) {
		super(driver);
	}

	public void assertNameFieldEmpty() throws Exception {
		Thread.sleep(2000);
		Assert.assertTrue("Vérification du titre", this.name_field.getText().isEmpty());
		Assert.assertTrue("Vérification du bouton enregistrer", this.bouton_enregistrer.isEnabled());
		Assert.assertTrue("Vérification du bouton sauver et continuer", this.bouton_sauver_continuer.isDisplayed());
		Assert.assertTrue("Vérification du bouton annuler", this.bouton_annuler.isDisplayed());
	}
	
	public void saisirNom(String s) throws Exception {
		/*Actions actions = new Actions(driver);
		actions.moveToElement(name_field).click();*/
		this.onglet_asso.click();
		this.name_field.sendKeys(s);		
	}
	
	public void associationRole(int index) {
		List<WebElement> lignes = driver.findElements(By.xpath("//tr[contains(@class,'comboitem')]/td[contains(@class,'text')]"));
		lignes.get(index).click();
		bouton_ajouter_role.click();
		
	}
	
	public void assertAjoutRole() {
		System.out.println("Rôle affiché :" + role_afficher.getText());
		System.out.println("Rôle ajouté :" + role_ajouter);
		Assert.assertTrue("verification ajout role", role_afficher.equals(role_ajouter));
		Assert.assertTrue("Poubelle présente", this.poubelle.isDisplayed());
	}
	
	
}
