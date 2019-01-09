package Autom3.libreplan2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPage extends GenericPage {
	WebDriver driver;

	@FindBy(how = How.XPATH, using ="//button[contains(text(),'Calendrier')]")
	WebElement onglet_calendrier1;
	
	@FindBy(how = How.XPATH, using ="input[@class='z-textbox z-textbox-text-invalid']")
	WebElement field_name_project;
	

	//WebElement
	@FindBy(how = How.XPATH, using ="//div[contains(@id, '2c-header')]//span")
	List<WebElement> assert_spantext; 

	@FindBy(how = How.XPATH, using ="//table[contains(@id, 'h4-box')]//td[text()='Liste des projets']")
	WebElement verification_onglet_menu_listeDesProjets;

	@FindBy(how = How.XPATH, using ="//span[@title='Créer un nouveau projet']")
	WebElement acces_popup_creation_project;

	@FindBy(how = How.XPATH, using ="//table[contains(@id, 'f4-box')]//td[text()='Planification des projets']")
	WebElement verification_onglet_planification;

	@FindBy(how = How.XPATH, using ="//tr[contains(@id, 'j6')]//span")
	List<WebElement> assert_spantextprojet01; 
	
	@FindBy(how = How.XPATH, using ="//tr[contains(@id, 'j6')]//span[@title]")
	List<WebElement> assert_spantitleattributprojet01;
	//-------------------------------------------------------	
	
	//Tableau servant pour comparer les données (Asserts). A changer lors du test
	static String[] verifspanliste01 = {"PROJET_TEST1", "PRJTEST001", "19 déc. 2018", "29 déc. 2018", "", "0 €","0", "PRE-VENTES"};
	static String[] verifspanlisteattribut01 = {"Modifier", "Supprimer", "Voir la prévision", "Créer un modèle"};

	//-----------------------------------------------------------

	public CalendarPage(WebDriver driver) {
		super(driver);
	}

			
		public void assertCalendrier() throws InterruptedException {	
			Assert.assertTrue("Présence de l'onglet Calendrier", onglet_calendrier.isDisplayed());
		}


		public WebElement getOnglet_calendrier() {
			return onglet_calendrier1;
		}

		public WebElement getField_name_project() {
			return field_name_project;
		}
		
		//Ouverture popup pour accèder au formulaire de création d'un projet
		public CreationProjet AccesPopupCreationProject() throws Exception {
			acces_popup_creation_project.click();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Creation projet en cours");
			return PageFactory.initElements(driver, CreationProjet.class);
		}

		//Vérification si présence de l'onglet nommé "planification des projets" et absence du menu horizontal
		public void AssertEditionProjet04() throws InterruptedException {
			//problème de synchronisation, mise en place d'un thread sleep en début d'instruction
			Thread.sleep(2000);
			System.out.println("Verification si présence de l'onglet nommé Planification des projets");
			Assert.assertTrue(verification_onglet_planification.isDisplayed());
			Assert.assertTrue("onglet planification non visible",this.verification_onglet_planification.getText().equals("Planification des projets"));
			System.out.println("Verification terminée confirmation de l'onglet concerné");
			System.out.println("Verification de l'absence des éléments du menu horizontal en cours...");
			//Vérification si liste comporte bien 0 élément
			Assert.assertTrue(this.assert_spantext.size()==0);
		
			System.out.println("Verification terminée, aucun élément trouvé");
		}

		//Vérification si présence de l'onglet nommé "Liste des projets"
		public void AssertVerificationListeProjets() throws Exception {
			Assert.assertTrue(this.verification_onglet_menu_listeDesProjets.isDisplayed());
			Assert.assertTrue("onglet planification non visible",this.verification_onglet_menu_listeDesProjets.getText().equals("Liste des projets"));

		}

		//Vérification si informations conformes au projet crée
		public void AssertVerificationProjet() throws Exception {
			for(int i=0; i <= 7; i++) 
			{
				while(assert_spantextprojet01.contains(null)) {
					i++;}

				Assert.assertTrue("informations non conforme", this.assert_spantextprojet01.get(i).getText().equals(verifspanliste01[i]));
				;
			};

			for(int i=0; i <= 3; i++) {
				Assert.assertTrue("informations non conforme", this.assert_spantitleattributprojet01.get(i).getAttribute("title").equals(verifspanlisteattribut01[i]));
			}

		}


}
