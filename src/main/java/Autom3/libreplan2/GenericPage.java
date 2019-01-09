package Autom3.libreplan2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Outils.Highlighter;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class GenericPage {

	protected final WebDriver driver;

	public GenericPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	String utilisateur_login = "admin";
	String mot_de_passe_login = "admin";

	@FindBy(how = How.XPATH, using ="//table[contains(@id, '7-a')]//button[contains(@id, '7-b')]")
	WebElement onglet_calendrier;

	@FindBy(how = How.XPATH, using ="//a[@href='/libreplan/planner/index.zul;orders_list']")
	WebElement Projets;


	//Champ d'indication de l'utilisateur connecté
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'admin')]")
	WebElement utilisateur_indication;

	//Champ d'indication de l'utilisateur connecté
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'Déconnexion')]")
	WebElement deconnexion_link;

	//Lien aide
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Aide')]")
	WebElement help_link;

	//Lien info
	@FindBy(how = How.XPATH, using ="(//img[@src=\"/libreplan/common/img/info.gif\" and @alt=\"Info\"])[1]")
	WebElement info_popup;

	//Lien modier le mot de passe
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'modifier le mot de passe')]")
	WebElement modifier_mot_passe;

	//Onglet Ressource
	@FindBy(how = How.XPATH, using ="//button[contains(text(),'Ressources')]")
	WebElement onglet_ressources;

	//Onglet Ressource_critères
	@FindBy(how = How.XPATH, using ="(//a[contains(text(),'Critère')])[1]")
	WebElement onglet_ressources_critere;

	//Onglet Calendrier
	@FindBy(how = How.XPATH, using ="//button[contains(text(),'Calendrier')]")
	WebElement onglet_calendrier1;

	//Onglet Configuration
	@FindBy(how = How.XPATH, using ="//button[@class='z-menu-btn' and contains(.,'Configuration')]")
	WebElement onglet_configuration;

	//Onglet Configuration profil
	@FindBy(how = How.XPATH, using ="//button[@class='z-menu-btn' and contains(.,'Configuration')]/following::a[@class='z-menu-item-cnt' and contains(.,'Profils')]")
	WebElement onglet_configuration_profil;


	@FindBy(how = How.XPATH, using ="//button[@class='z-menu-btn' and contains(.,'Ressources')]/following::a[@class='z-menu-item-cnt' and contains(.,\"Types d'avancement\")]") 
	WebElement onglet_ressources_item_type_avancement;

	public TypeCritereListPage ressourceOngletCritere() {

		Actions actions = new Actions(driver);
		Highlighter.highLightElement(driver, onglet_ressources);

		actions.moveToElement(onglet_ressources).build().perform();
		Highlighter.highLightElement(driver, driver.findElement(By.xpath("(//a[contains(text(),'Critère')])[1]")));

		driver.findElement(By.xpath("(//a[contains(text(),'Critère')])[1]")).click();
		return PageFactory.initElements(driver, TypeCritereListPage.class);

	}

	public ProfilsPage configurationOngletProfils() throws InterruptedException {

		Actions actions = new Actions(driver);
		Highlighter.highLightElement(driver, onglet_configuration);

		actions.moveToElement(onglet_configuration).build().perform();
		Thread.sleep(2000);
		Highlighter.highLightElement(driver,driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(.,'Configuration')]/following::a[@class='z-menu-item-cnt' and contains(.,'Profils')]")));

		driver.findElement(By.xpath("//button[@class='z-menu-btn' and contains(.,'Configuration')]/following::a[@class='z-menu-item-cnt' and contains(.,'Profils')]")).click();
		return PageFactory.initElements(driver, ProfilsPage.class);

	}

	//Méthode pour passer la souris sur l'onglet "Calendrier" puis clique sur l'item "Projets".
	public CalendarPage clickLienCalendrierProjets() throws Exception {

		//Utilisation de la classe Actions pour la fonction MouseOver
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(onglet_calendrier).build().perform();
		Thread.sleep(3000);
		Projets.click();
		Thread.sleep(3000);
		return PageFactory.initElements(driver, CalendarPage.class);


	}

	public TypeAvancementPage clickOngletRessourcesItemTypeAvancement() {

		Actions actions = new Actions(driver);
		actions.moveToElement(onglet_ressources).build().perform();
		onglet_ressources_item_type_avancement.click();
		return PageFactory.initElements(driver, TypeAvancementPage.class);

	}





}
