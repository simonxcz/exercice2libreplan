package Autom3.libreplan2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Outils.Highlighter;


public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,  this);
		// TODO Auto-generated constructor stub
	}
	
	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public String getUtilisateur_login() {
		return utilisateur_login;
	}


	public void setUtilisateur_login(String utilisateur_login) {
		this.utilisateur_login = utilisateur_login;
	}


	public String getMot_de_passe_login() {
		return mot_de_passe_login;
	}


	public void setMot_de_passe_login(String mot_de_passe_login) {
		this.mot_de_passe_login = mot_de_passe_login;
	}


	public WebElement getUtilisateur_field() {
		return utilisateur_field;
	}


	public void setUtilisateur_field(WebElement utilisateur_field) {
		this.utilisateur_field = utilisateur_field;
	}


	public WebElement getMot_de_passe_login_field() {
		return mot_de_passe_login_field;
	}


	public void setMot_de_passe_login_field(WebElement mot_de_passe_login_field) {
		this.mot_de_passe_login_field = mot_de_passe_login_field;
	}


	public WebElement getBtn_se_connecter() {
		return btn_se_connecter;
	}


	public void setBtn_se_connecter(WebElement btn_se_connecter) {
		this.btn_se_connecter = btn_se_connecter;
	}


	public WebElement getAide_lien() {
		return aide_lien;
	}


	public void setAide_lien(WebElement aide_lien) {
		this.aide_lien = aide_lien;
	}

	String utilisateur_login = "admin";
	String mot_de_passe_login = "admin";
	
	//champ pour le login utilisateur
	@FindBy(how = How.XPATH, using ="//input[@name=\"j_username\"]")
	WebElement utilisateur_field;
	
	//champ pour le mot de passe utilisateur
	@FindBy(how = How.XPATH, using ="//input[@name=\"j_password\"]")
	WebElement mot_de_passe_login_field;
	
	//le bouton pour se connecter � l'application
	@FindBy(how = How.XPATH, using ="//input[@name=\"button\"]")
	WebElement btn_se_connecter;


	//le lien pour l'aide
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'Aide')]")
	WebElement aide_lien;
	

	public CalendarPage clickSubmitButton() {
		utilisateur_field.clear();
		utilisateur_field.sendKeys(utilisateur_login);
		mot_de_passe_login_field.clear();
		mot_de_passe_login_field.sendKeys(mot_de_passe_login);
		Highlighter.highLightElement(driver,btn_se_connecter);
		btn_se_connecter.submit();
		return PageFactory.initElements(driver, CalendarPage.class);
	}
	
}