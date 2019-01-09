
package Autom3.libreplan2;

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

//@Listeners(TestNGListener.class)
public class CRI_01_AdministrationDesCriteresTest  {
	WebDriver driver;
	JDBC datata = new JDBC();

	@Test
	public void  libreplanTest() throws Exception {
	 
		System.out.println("Pas de test 1 - Connexion");

		//Connexion à l'application
		ConnexionTest pou = new ConnexionTest();
		//Accession à la page calender
		CalendarPage calendar = pou.libreplanTest();
		
		
	
		
		//Vérification de la page calendar
		calendar.assertCalendrier();

		System.out.println("Pas de test 2 - Accès à la page d'administration des critères");

		//Accès à la liste des types de critères
		TypeCritereListPage tclp = calendar.ressourceOngletCritere();
		
		//Verification de la présence des différenrs éléments sur la page type de critères
		tclp.assertTypeCritereListePage();


		System.out.println("Pas de test 3 - Créer un critère - Accès au formulaire");
		
		//Cliquer sur le bouton de création d'un critère
		CreerTypeCriterePage creertype = tclp.clickButtonCreer();
		
		//Verification de la présence des différenrs éléments sur la page créer type de critères
		creertype.assertCreerTypeCriterePage();

		System.out.println("Pas de test 4 - Créer un critère - Annuler ");

		//Remplir le formulaire et annuler à la fin
		TypeCritereListPage tcl = creertype.remplirFormulaireAnnulation();
		
		//Vérification de la présence du titre de la page type de critères
		tcl.assertTitle();
		
		//Vérification de la non présence du bouton annuler
		tcl.assertFalseBoutonAnnuler();
		
		System.out.println("Pas de test 5 - Créer un critère - Enregistrer ");

		//Créer un type de crière
		CreerTypeCriterePage creetype1 = tcl.clickButtonCreer();
		
		//Remplir le formulaire pour un nouveau critère et l'enregistrer
		TypeCritereListPage tcl1 = creetype1.remplirFormulaireEnregister();

		//Vérification du titre de la page type du types de critères
		tcl1.assertTitle();
		
		//Vérification de l'ajout de la ligne dans le tableau
		tcl1.assertCritereTestBoutonTableau();
		System.out.println("Pas de test 6 - Créer un critère - Accès au formulaire");

		
		CreerTypeCriterePage creetype2 = tcl1.clickButtonCreer();
		creetype2.assertCreerTypeCriterePage();
		System.out.println("Pas de test 7 - Créer un critère - Sauver et continuer");
		//Suppression dans la base de données du nouveau critère "critères - Test"
		datata.deleteCritere();
		
		//Formulaire pour un nouveau critère rempli et enregistrer
		creetype2.remplirFormulaireSauverContinuer();
		
		//Vérification de l'ajout d'un message
		creetype2.assertAjoutMessage();
		System.out.println("Pas de test 8 - cliquer sur le bouton annuler ");

		//Clique sur le bouton annuler pour créer un type
		TypeCritereListPage ressource_2 = creertype.boutonAnnulerTypeCritere();

		//Vérification du titre de la page des types de critères
		ressource_2.assertTitle();
		
		//Vérication de la présence du tableau avec les titres des colonnes
		ressource_2.assertCritereTestBoutonTableau();

		System.out.println("Pas de test 9 - cliquer sur le bouton modifier");

		CreerTypeCriterePage creertype2 = ressource_2.clickBoutonModifierCritere();
		//Vérification de la présence de la page pour créer un type de critère
		creertype2.assertTitleCritere();

		System.out.println("Pas de test 10 - modifier un critère - bouton annuler ");

		//modification du critère de test
		creertype2.changeName("Critère - Test bouton - 2");
		TypeCritereListPage tcl3 = creertype2.boutonAnnulerTypeCritere();
		
		//Vérification de la présence du titre de la page des types de critères
		tcl3.assertTitle();
		
		//Vérification de la non modification du critère 2
		tcl3.assertNonModification();

		System.out.println("Pas de test 11 - modifier un critère - accès formulaire de modification colonne nom");

		CreerTypeCriterePage creertype3 = tcl3.choisirDeuxiemeCritereListe();

		//Vérification du titre de la page pour créer un type de critère
		creertype3.assertTitleCritere();
		System.out.println("Pas de test 12 - modifier un critère - modification du nom");

		//Modificationd du champ nom
		creertype3.modifierChampNom("Critères - Test bouton 2");
		
		//Vérification de l'enregistrement du titre de critères 2
		creertype3.assertModifierEnregistrementTitreCritere2();

		System.out.println("Pas de test 13 - modifier un critère - modification du nom");

		//Clique sur le bouton sauver et continuer
		creertype3.clickSauverContinuer();
		
		//Vérification d el'enregistrement
		creertype3.assertEnregistrementCritere2();
		//Vérification du titre de la page après la modification du critère
		creertype3.assertModifierEnregistrementTitreCritere2();

		System.out.println("Pas de test 14 - Retour page d'administration des critères ");
		
		//Clique sur le bouton d'annulation du type de critère
		TypeCritereListPage tcl4 = creertype3.boutonAnnulerTypeCritere();
		
		//Vérification de la présence du titre de la page des types de critères
		tcl4.assertTitle();
		
		//Verification de l'ajout du critère 2 dans le tableau des types de critères
		tcl4.assertCritereTestBoutonTableau2();
		
		System.out.println("Pas de test 15 - Supprimer un critère - Pop-up de confirmation");
		//Clique sur la pubelle pour supprimer le critère 2
		tcl4.clickSuppressionCritere2();
		
		//Vérification de la présence du pop up de confirmation
		tcl4.assertPopUpConfirmation2();
		System.out.println("Pas de test 16 - Supprimer un critère - Bouton[Annuler]");
		
		//Clique sur le bouton annuler du pop up
		tcl4.clickPopUpAnnuler();
		
		//Vérification de l'ajout du critère 2 dans le tableau
		tcl4.assertCritereTestBoutonTableau2();

		System.out.println("Pas de test 17 - Supprimer un critère - Pop up de confirmation");
		
		//Suppression du critère 2
		tcl4.clickSuppressionCritere2();
		
		//Vérification de la présence des boutons annuler, OK, et vérification de la page
		tcl4.assertPopUpConfirmation2();
		
		System.out.println("Pas de test 18 - Supprimer un critère - Bouton[OK]");
		
		//Clique sur le bouton OK du pop up de confirmation
		tcl4.clickPopUpOK();
		
		//Confirmation de la suppression du critère de test - 2
		tcl4.assertConfirmationSuppressionCritere2();	

		
	}	
	
	
}