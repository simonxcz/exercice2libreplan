package Autom3.libreplan2;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProjetEdition extends GenericPage {



	//---------------------------------

	//WebElement
	@FindBy(how = How.XPATH, using ="(//table[contains(@id, 'p3-real')]//span)[1]")
	WebElement btn_enregistrer;

	@FindBy(how = How.XPATH, using ="(//table[contains(@id, 'p3-real')]//span)[2]")
	WebElement btn_annuler;

	@FindBy(how = How.XPATH, using ="//td[text()='Planification de projet']")
	WebElement verification_onglet_planification;

	@FindBy(how = How.XPATH, using ="//td[text()='Détail du projet']")
	WebElement onglet_detail_projet;

	@FindBy(how = How.XPATH, using ="//td[text()='Chargement des ressources']")
	WebElement onglet_chargement_des_ressources;

	@FindBy(how = How.XPATH, using ="//td[text()='Allocation avancée']")
	WebElement onglet_allocation;

	@FindBy(how = How.XPATH, using ="//td[text()='Tableau de bord']")
	WebElement onglet_tableau_de_bord;

	//---------------------------------	

	//Liste de WebElement
	@FindBy(how = How.XPATH, using ="//div[contains(@id, '2c-header')]//span")
	List<WebElement> assert_spantext; 

	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'r4-cave')]//span")
	List<WebElement> assert_spantextannuler; 

	@FindBy(how = How.XPATH, using ="//div[contains(@id, '5-cave')]//span")
	List<WebElement> assert_spantextannuler2; 
	//-------------------------------------------------	

	//Tableau static d'éléments pour comparaison de données

	static String[] verifspan = {"WBS (tâches)", "Données générales", "Coût", "Avancement", "Libellés", "Exigence de critère", 
			"Matériels", "Formulaires qualité des tâches", "Autorisation"};

	static String[] verifspan_annuler = {"Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", "OK", "Annuler"};
	//------------------------------------------------------------------	



	//Constructeur
	public ProjetEdition(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Vérification dans l'ordre du menu horizontal
	public void AssertMenuHorizontal() throws Exception{
		System.out.println("Verification des élements du menu horizontal en cours...");
		for(int i=0; i <= 8; i++) {
			this.assert_spantext.get(i).getText().equals(ProjetEdition.verifspan[i]);
			;
		}
		System.out.println("Verification des élements du menu horizontal terminée, aucune erreur trouvée");
	}

	//Vérification dans l'ordre du menu vertical
	public void AssertMenuVertical() throws Exception {
		System.out.println("Verification des élements du menu vertical en cours...");
		Assert.assertTrue("onglet planification non visible",this.verification_onglet_planification.getText().equals("Planification de projet"));

		Assert.assertTrue("onglet detail projet non visible",this.onglet_detail_projet.getText().equals("Détail du projet"));

		Assert.assertTrue("onglet chargement des ressoources non visible",this.onglet_chargement_des_ressources.getText().equals("Chargement des ressources"));

		Assert.assertTrue("onglet allocation non visible",this.onglet_allocation.getText().equals("Allocation avancée"));

		Assert.assertTrue("onglet tableau de bord non visible",this.onglet_tableau_de_bord.getText().equals("Tableau de bord"));

		System.out.println("Verification des élements du menu vertical terminée, aucune erreur trouvée");

	}


	//Methodes
	public void AssertEditionProjet01() throws Exception{	
		//Vérification si présence du bouton Enregistrer
		Assert.assertTrue(btn_enregistrer.isDisplayed());
		//Vérification assert sur "Titre de l'infobulle-->Enregistrer le projet"
		Assert.assertTrue("bouton enregistrer non trouvé",this.btn_enregistrer.getAttribute("title").equals("Enregistrer le projet"));
		//Vérification si présence du bouton Annuler
		Assert.assertTrue(btn_annuler.isDisplayed());
		//Vérification assert sur "Titre de l'infobulle-->Annuler l'édition"
		Assert.assertTrue("bouton annuler non trouvé",this.btn_annuler.getAttribute("title").equals("Annuler l'édition"));
		Assert.assertTrue(btn_annuler.isDisplayed());


		this.btn_annuler.click();
		for(int i=0; i <= 2; i++) {
			this.assert_spantextannuler.get(i).getText().equals(ProjetEdition.verifspan_annuler[i]);

		}
		//Vérification si présence Bouton OK et Annuler 
		Assert.assertTrue(assert_spantextannuler.get(1).isDisplayed());
		Assert.assertTrue(assert_spantextannuler.get(2).isDisplayed());

	}


	public void AssertEditionProjet02() throws Exception {
		//Verification de la présence de l'onglet "Détail du projet" et de son texte dans le menu vertical affiché 
		Assert.assertTrue("onglet detail projet non visible",this.onglet_detail_projet.getText().equals("Détail du projet"));
		Assert.assertTrue("onglet detail projet non affiché",this.onglet_detail_projet.isDisplayed());

		//Verification de la présence de l'onglet "WBS (tâches)" et de son texte affiché dans le menu horizontal
		Assert.assertTrue(this.assert_spantext.get(0).getText().equals("WBS (tâches)"));
		Assert.assertTrue("onglet WBS (tâches) non visible",this.assert_spantext.get(0).isDisplayed());

	}



	//Verification des messages dans la fênetre d'édition du projet
	public void AssertEditionProjet03() throws Exception{

		for(int i=0; i <= 2; i++) {
			Assert.assertTrue(this.assert_spantextannuler2.get(i).getText().equals(ProjetEdition.verifspan_annuler[i]));

		}
		//Vérification si présence Bouton OK et Annuler 
		Assert.assertTrue(assert_spantextannuler2.get(1).isDisplayed());
		Assert.assertTrue(assert_spantextannuler2.get(2).isDisplayed());

	}

	//Méthode pour cliquer sur le bouton OK de la fênetre d'édition du projet-> retour à la page Index(planner)
	public CalendarPage clickbtnEditionOK() throws Exception {
		this.assert_spantextannuler2.get(1).click();
		return PageFactory.initElements(driver, CalendarPage.class);

	}

}