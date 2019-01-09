package Autom3.libreplan2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Outils.Highlighter;

import org.junit.Assert;

public class CreerTypeCriterePage extends RessourcesPage {

	//Champ du nom
	@FindBy(how = How.XPATH, using ="//span[@class=\"z-label\" and contains(.,'Nom')]/following::input[@class='z-textbox'][1]")
	WebElement champ_nom;

	//Type de critère menu déroulant
	@FindBy(how = How.XPATH, using ="//td[@class='z-comboitem-text' and contains(.,'PARTICIPANT')]")
	WebElement type_critere_participant;

	//Type de critère bouton menu déroulant
	@FindBy(how = How.XPATH, using ="//i[@class='z-combobox-btn']")
	WebElement btn_type_critere_participant;

	//Bouton valeur multiple
	@FindBy(how = How.XPATH, using ="//span[contains(.,'Valeurs multiples par ressource')]/following::input[@type='checkbox'][1]")
	WebElement valeur_multiple;

	//bouton hierarchie
	@FindBy(how = How.XPATH, using ="//span[contains(.,'Hiérarchie')]/following::input[@type='checkbox'][1]")
	WebElement hierarchie_box;

	//Bouton active 
	@FindBy(how = How.XPATH, using ="//span[contains(.,'Activé')]/following::input[@type='checkbox'][1]")
	WebElement active_box;

	//Champ description
	@FindBy(how = How.XPATH, using ="//textarea[@class='z-textbox']")
	WebElement description_field;

	//Bouton sauver et continuer
	@FindBy(how = How.XPATH, using ="//td[@class='z-button-cm' and contains(.,'Sauver et continuer')]")
	WebElement bouton_sauver_continuer;

	//Bouton annuler
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Annuler')]")
	WebElement bouton_annuler;	
	
	@FindBy(how = How.XPATH, using ="//td[@class='z-button-cm' and contains(.,'Enregistrer')]")
	WebElement bouton_enregistrer;
	
	//Message de confirmation d'ajout
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Type de critère \"Critère - Test bouton\" enregistré')]")
	WebElement message_confirmation_ajout;

	//Champ titre
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Modifier')]")
	WebElement title_field;
	
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Test bouton 2')]")
	WebElement title_suppression_critere_2;
	

	
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Test bouton 2')]")
	WebElement champ_confirmation_enregistrement_critere_2;

	@FindBy(how = How.XPATH, using ="//td[contains(text(),'Modifier Type')]")
	WebElement titre_modifier_enregistrement_critere_2;
	
	@FindBy(how = How.XPATH, using ="//table/descendant::td[contains(.,'Créer Type')]")
	WebElement titre_creer_type_criteres;
	
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Modifier')]")
	WebElement onglet_modifier;

	@FindBy(how = How.XPATH, using ="//input[contains(@class,'z-combobox')]")
	WebElement onglet_champ;
	




	public CreerTypeCriterePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public TypeCritereListPage remplirFormulaireAnnulation() throws Exception {
		
		this.clearName();
		Highlighter.highLightElement(driver,champ_nom);
		this.changeName("Critère - Test bouton");
		Highlighter.highLightElement(driver,onglet_champ);
		Highlighter.highLightElement(driver,btn_type_critere_participant);
		this.btn_type_critere_participant.click();
		Highlighter.highLightElement(driver,type_critere_participant);
		this.type_critere_participant.click();
		Highlighter.highLightElement(driver,valeur_multiple);
		this.valeurMultipleBox();
		Highlighter.highLightElement(driver,hierarchie_box);
		this.hierarchieBox();
		Highlighter.highLightElement(driver,active_box);
		this.activeBox();
		Highlighter.highLightElement(driver,description_field);
		this.description_field.sendKeys("Critère - Test bouton");
		this.boutonAnnulerTypeCritere();
		return PageFactory.initElements(driver, TypeCritereListPage.class);
	}

	public void remplirFormulaireSauverContinuer() throws InterruptedException {
		this.clearName();
		this.changeName("Critère - Test bouton");
		this.choixDuTypeParticipant();
		this.valeurMultipleBox();
		this.hierarchieBox();
		this.activeBox();
		this.description_field.sendKeys("Critère - Test bouton");
		this.clickSauverContinuer();
		
	}
	
	public TypeCritereListPage remplirFormulaireEnregister() {
		this.clearName();
		this.changeName("Critère - Test bouton");
		Highlighter.highLightElement(driver,onglet_champ);
		this.btn_type_critere_participant.click();
		this.type_critere_participant.click();
		this.valeurMultipleBox();
		this.hierarchieBox();
		this.activeBox();
		this.description_field.sendKeys("Critère - Test bouton");
		this.clickEnregistrer();
		return PageFactory.initElements(driver, TypeCritereListPage.class);
	}


	/*Méthode pour cocher la checkbox valeur multiples
	 * */
	public void valeurMultipleBox() {
		if(this.valeur_multiple.isSelected()) {

		}else {
			this.valeur_multiple.clear();
		}
	}

	/*Méthode pour cocher la checkbox hierarchie
	 * */
	public void hierarchieBox() {
		if(this.hierarchie_box.isSelected()) {

		}else {
			this.hierarchie_box.clear();
		}
	}

	/*Méthode pour cocher la checkbox active
	 * */
	public void activeBox() {
		if(this.active_box.isSelected()) {

		}else {
			this.active_box.clear();
		}
	}

	public void clickSauverContinuer(){
		Highlighter.highLightElement(driver,bouton_sauver_continuer);
		this.bouton_sauver_continuer.click();
	}

	public void assertAjoutMessage() {
		Assert.assertTrue(message_confirmation_ajout.isDisplayed());
	}

	public void clearName() {
		this.champ_nom.clear();
	}
	public void changeName(String s) {
		if (s.equals(null)) {
			this.champ_nom.sendKeys("Critère - Test bouton -"+3);
		} else {
			this.champ_nom.clear();
			this.champ_nom.sendKeys(s);
		}
	}

	public TypeCritereListPage boutonAnnulerTypeCritere() throws Exception {
		Thread.sleep(2000);
		Highlighter.highLightElement(driver,bouton_annuler);
		this.bouton_annuler.click();

		return PageFactory.initElements(driver, TypeCritereListPage.class);
	}

	public void assertTitleCritere() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue("Vérification de la présence du titre",this.title_field.getText().equals("Modifier Type de critère: Critère - Test bouton"));
	}
	
	public void modifierChampNom(String s) {
		this.champ_nom.clear();
		this.champ_nom.sendKeys(s);
	}
	
	public void assertTitleSuppressionCritere2() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(this.titre_type_de_criteres2.isDisplayed());
	}
	
	public TypeCritereListPage clickEnregistrer() {
		this.bouton_enregistrer.click();
		return PageFactory.initElements(driver, TypeCritereListPage.class);

	}
	
	public void choixDuTypeParticipant() throws InterruptedException {
		Thread.sleep(2000);
		btn_type_critere_participant.click();
		type_critere_participant.click();
	}
	
	public void assertEnregistrementCritere2() throws Exception {
		Thread.sleep(2000);
		try {
			Assert.assertTrue("Vérification de l'enregistrement du titre",this.champ_confirmation_enregistrement_critere_2.getText().equals("Type de critère \"Critères - Test bouton 2\" enregistré"));
		} catch (Exception e) {
			System.out.println("Le titre n'a paqs été enregistré");
			throw e;
		}
	}
	
	public void assertModifierEnregistrementTitreCritere2() throws Exception {
		this.titre_modifier_enregistrement_critere_2.click();
		Thread.sleep(2000);
		try {
			Assert.assertTrue("Vérification de l'enregistrement du titre",this.titre_modifier_enregistrement_critere_2.getText().equals("Modifier Type de critère: Critères - Test bouton 2"));
		} catch (Exception e) {
			System.out.println("Le titre \'Modifier Type de critère: Critères - Test bouton 2\' n'a pas été pris en compte.");
			throw e;
		}
	}
	
	public void assertCreerTypeCriterePage() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue("Vérification de la présense du titre",this.titre_creer_type_criteres.isDisplayed());
		Assert.assertTrue("Vérification de la présense de l'onglet modifier",this.onglet_modifier.isDisplayed());
		Assert.assertTrue("Vérification de la présense du bouton annuler",this.bouton_annuler.isDisplayed());
		Assert.assertTrue("Vérification de la présense du bouton enregistrer",this.bouton_enregistrer.isDisplayed());
		Assert.assertTrue("Vérification de la présense du bouton sauver et continuer",this.bouton_sauver_continuer.isDisplayed());

	}
	
	
}
