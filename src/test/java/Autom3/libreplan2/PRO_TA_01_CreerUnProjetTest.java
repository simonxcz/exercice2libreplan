package Autom3.libreplan2;

import static org.junit.Assert.*;

import org.junit.Test;

import java.beans.EventHandler;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;
import BDD.JDBC;
import Outils.Highlighter;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.postgresql.core.ConnectionFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import BDD.JDBC;


import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class PRO_TA_01_CreerUnProjetTest {

	WebDriver driver;


	@Test
	public void proTa01CreerUnProjet() throws Exception {

		try {
			
			/*
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
			driver.manage().window().maximize();*/
		//	LoginPage logpage = new LoginPage(driver);

			//-----------------Pas de test 01-----------------------------------------------------------------
			System.out.println("\n-----Pas de test 01 : Connexion à l'application - Profil Admin-----");
			//Connexion à l'application
			ConnexionTest pou = new ConnexionTest();
			//Accession à la page calender
			CalendarPage p_index_calendar = pou.libreplanTest();
		//	CalendarPage p_index_calendar = logpage.clickSubmitButton();
			//Wait pour être sûr de cliquer sur le bouton
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//-----------------Pas de test 02-----------------------------------------------------------------
			System.out.println("\n-----Pas de test 02 : Accéder au formulaire de création d'un projet-----");
			CreationProjet p_creation_projet  = p_index_calendar.AccesPopupCreationProject();
			Thread.sleep(5000);
			System.out.println("Popup creation projet affiché");
			p_creation_projet.CreationProjetAssert01();

			//----------------Pas de test 03------------------------------------------------------------------
			System.out.println("\n-----Pas de test 03 : Créer un projet - Bouton [Accepter]-----");
			ProjetEdition projet_edition= p_creation_projet.creationProjet("PROJET_TEST1", "PRJTEST001", 19, 29);
			Thread.sleep(3000);
			System.out.println("Creation projet terminé");

			//----------------Pas de test 04------------------------------------------------------------------
			System.out.println("Menu édition du projet");
			System.out.println("\n-----Pas de test 04 : Vérifier les onglets - menu vertical-----");
			projet_edition.AssertMenuVertical();

			//----------------Pas de test 05------------------------------------------------------------------
			System.out.println("\n-----Pas de test 05 : Vérifier les onglets - menu horizontal-----");
			projet_edition.AssertMenuHorizontal();

			//----------------Pas de test 06 et 07------------------------------------------------------------
			System.out.println("\n-----Pas de test 06 et 07 : Utilisation du bouton d'annulation de l'édition du projet (1/4)-----");
			System.out.println("bouton d'annulation de l'édition du projet cliqué");
			System.out.println("Vérifications Assert en cours...");
			projet_edition.AssertEditionProjet01();
			System.out.println("Vérifications Assert terminées, aucune erreur est affichée");
			Thread.sleep(3000);

			//----------------Pas de test 08------------------------------------------------------------------
			System.out.println("\n-----Pas de test 08 : Utilisation du bouton d'annulation de l'édition du projet (2/4) -----");
			System.out.println("Popup ouvert et Bouton Annuler cliqué");
			projet_edition.assert_spantextannuler.get(2).click();
			System.out.println("Vérifications Assert en cours...");
			projet_edition.AssertEditionProjet02();
			System.out.println("Vérifications Assert terminées, aucune erreur est affichée");

			//----------------Pas de test 09-------------------------------------------------------------------
			System.out.println("\n-----Pas de test 09 : Utilisation du bouton d'annulation de l'édition du projet (3/4)-----");
			Thread.sleep(3000);
			projet_edition.btn_annuler.click();
			System.out.println("Popup ouvert et Bouton Annuler cliqué");
			System.out.println("Vérifications Assert en cours");
			Thread.sleep(3000);
			projet_edition.AssertEditionProjet03();
			System.out.println("Vérifications Assert terminées, aucune erreur est affichée");

			//----------------Pas de test 10--------------------------------------------------------------------
			System.out.println("\n-----Pas de test 10 : Utilisation du bouton d'annulation de l'édition du projet (4/4)-----");
			CalendarPage p_index_calendar01 = projet_edition.clickbtnEditionOK();
			System.out.println("Bouton OK cliqué pour annulation de l'édition");
			System.out.println("Vérification Absence du menu horizontal");
			p_index_calendar01.AssertEditionProjet04();
			System.out.println("Vérification Absence du menu horizontal");

			//----------------Pas de test 11
			System.out.println("\n-----Pas de test 11 : Vérifier la création du projet-----");
			Thread.sleep(3000);
			CalendarPage p_index_calendar02 = p_index_calendar01.clickLienCalendrierProjets();
			System.out.println("Vérifications Assert en cours");
			p_index_calendar02.AssertVerificationListeProjets();
			System.out.println("Onglet Calendrier->Projets cliqué");
			System.out.println("Vérifications Assert terminées, aucune erreur est affichée");

			//----------------Pas de test 12--------------------------------------------------------------------
			System.out.println("\n-----Pas de test 12 : Vérifier les informations affichées pour le projet-----");
			p_index_calendar02.AssertVerificationProjet();
			System.out.println("Informations conformes");
		}catch(Exception e) {System.out.println("Erreur rencontrée de type" + e);}





	}
}
