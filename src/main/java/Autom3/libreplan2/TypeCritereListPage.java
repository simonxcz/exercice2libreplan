package Autom3.libreplan2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Outils.Highlighter;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
public class TypeCritereListPage extends RessourcesPage {

	//Bouton creer ressource
	@FindBy(how = How.XPATH, using ="//table/descendant::td[contains(.,'Créer')]")
	WebElement button_creer_ressources;

	//Bouton de supression du critère 2
	@FindBy(how = How.XPATH, using ="(//img[contains(@src,'borrar')])[2]")
	WebElement suppression_critere_2;

	//Bouton annuler de la pop up
	@FindBy(how = How.XPATH, using ="(//td[contains(text(),'Annuler')])[2]")
	WebElement pop_up_bouton_annuler;

	//Bouton OK de la pop up
	@FindBy(how = How.XPATH, using ="//td[contains(text(),'OK')]")
	WebElement pop_up_bouton_ok;

	//Liste des titres du tableau de la page des types de critères
	@FindBy(how = How.XPATH, using ="//div[@class='z-column-cnt' and contains(.,'Nom')]")
	WebElement table_titre_nom;

	//Titre "code" de la table des types de critères
	@FindBy(how = How.XPATH, using ="//div[@class='z-column-cnt' and contains(.,'Code')]")
	WebElement table_titre_code;

	//Titre "type" de la table des types de critères
	@FindBy(how = How.XPATH, using ="//div[@class='z-column-cnt' and contains(.,'Type')]")
	WebElement table_titre_type;

	//Titre "Activé" de la table des types de critères
	@FindBy(how = How.XPATH, using ="//div[@class='z-column-cnt' and contains(.,'Activé')]")
	WebElement table_titre_active;

	//Titre "Opérations" de la table des types de critères
	@FindBy(how = How.XPATH, using ="//div[@class='z-column-cnt' and contains(.,'Opérations')]")
	WebElement table_titre_operations;

	//Titre de la page de stypes de critères
	@FindBy(how = How.XPATH, using ="//div[contains(text(),'Types de critères Liste')]")
	WebElement type_critere_titre;

	//Bouton annuler
	@FindBy(how = How.XPATH, using ="//td[@class='z-button-cm' and contains(.,'Annuler')]")
	WebElement bouton_annuler;

	//Champ pour l'ajout de "critère test bouton" dans le tableau
	@FindBy(how = How.XPATH, using ="//span[@title='Critère - Test bouton']")
	WebElement presence_critere_test_bouton;
	
	//Champ pour l'ajout de "critère test bouton 2" dans le tableau
	@FindBy(how = How.XPATH, using ="//span[@title='Critère - Test bouton' and contains(text(),'Critères - Test bouton 2')]")
	WebElement presence_critere_test_bouton2;
	
	//Message confirmation du critère 2
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Supprimer Type de critère \"Critères - Test bouton 2\". Êtes-vous sûr ?')]")
	WebElement message_confirmation_suppression_2;

	//Message suppression du critère 2
	@FindBy(how = How.XPATH, using ="//span[contains(text(),'Critères - Test bouton 2')]")
	WebElement message_critere_2_suppression_confirmation;



	public TypeCritereListPage(WebDriver driver) {
		super(driver);	
	}


	/* 
	 * @throws InterruptedException
	 */
	public CreerTypeCriterePage clickButtonCreer() throws InterruptedException {
		Thread.sleep(2000);
		Highlighter.highLightElement(driver, button_creer_ressources);
		button_creer_ressources.click();
		return PageFactory.initElements(driver, CreerTypeCriterePage.class);
	}

	public void clickSuppressionCritere2() throws InterruptedException {
		Thread.sleep(2000);
		suppression_critere_2.click();
	}

	public void clickPopUpAnnuler() throws Exception {
		Thread.sleep(2000);
		Highlighter.highLightElement(driver, this.pop_up_bouton_annuler);
		pop_up_bouton_annuler.click();
	}

	
	
	public void clickPopUpOK() throws Exception {
		Thread.sleep(2000);
		Highlighter.highLightElement(driver, this.pop_up_bouton_ok);
		pop_up_bouton_ok.click();
	}

	
	/**
	 * Méthode de vérification de la présence des éléments de  la page types de critères 
	 * @throws Exception
	 */
	public void assertTypeCritereListePage() throws Exception {
		try {
			Assert.assertTrue("Vérification présence bouton créer", this.button_creer_ressources.isDisplayed());
			
		} catch(AssertionError e) {
			System.out.println("La présence du bouton créer n'est pas vérifier");
			throw e;
		}

		try {
			Assert.assertTrue("Vérification présence titre nom du tableau", this.table_titre_nom.getText().equals("Nom"));
			
		} catch(Exception e) {
			System.out.println("La présence du titre de la colonne \'Nom\' de la table n'est pas vérifiée");
			throw e;
		}

		try {
			Assert.assertTrue("Vérification présence titre code du tableau", this.table_titre_code.getText().equals("Code"));
		} catch(AssertionError e) {
			System.out.println("La présence du titre de la colonne \'Code\' de la table n'est pas vérifiée");
			throw e;
		}

		try {
			Assert.assertTrue("Vérification présence titre type du tableau", this.table_titre_type.getText().equals("Type"));
		}catch(AssertionError e) {
			System.out.println("La présence du titre de la colonne \'Type\' de la table n'est pas vérifiée");
			throw e;
		}

		try {
			Assert.assertTrue("Vérification présence titre active du tableau", this.table_titre_active.getText().equals("Activé"));
		}catch(AssertionError e) {
			System.out.println("La présence du titre de la colonne \'Activé\' de la table n'est pas vérifiée");
			throw e;
		}

		try {
			Assert.assertTrue("Vérification présence titre opération du tableau", this.table_titre_operations.getText().equals("Opérations"));
		}catch(AssertionError e) {
			System.out.println("La présence du titre de la colonne \'Opérations\' de la table n'est pas vérifiée");
			throw e;
		}

	}
	
	/**
	 * Méthode de vérification de la présence du titre du Types de critères
	 * @throws Exception
	 */
	public void assertTitle() throws Exception {
		Thread.sleep(4000);
		try {
			
			Assert.assertTrue("Vérification présence titre Types de critères Liste", this.titre_type_de_criteres.isDisplayed());
		}catch(AssertionError e) {
			System.out.println("La présence du titre du titre \'Types de critères Liste\' n'est pas vérifiée");
			throw e;
		}
	}

	
	
	
	/**
	 * Méthode de vérification de la non-présence du bouton "Annuler"
	 * @throws InterruptedException
	 */
	public void assertFalseBoutonAnnuler() throws InterruptedException {
		Thread.sleep(2000);
		try {
			Assert.assertFalse("Le bouton annuler n'est pas présent", this.bouton_annuler.isDisplayed());
		}catch(AssertionError e) {
			System.out.println("La présence du titre du titre \'Types de critères Liste\' n'est pas vérifiée");
			throw e;
		}
	}
	
	/**
	 * Méthode de confirmation de la présence du "Critère - Test bouton" dans le tableau
	 * @throws Exception
	 */
	public void assertCritereTestBoutonTableau() throws Exception {
		Thread.sleep(2000);
		try {
			Highlighter.highLightElement(driver, this.presence_critere_test_bouton);
			Assert.assertTrue("Ajout à la liste de \'Critère - Test bouton \'", this.presence_critere_test_bouton.isDisplayed());
		}catch(AssertionError e) {
			System.out.println("Le \'Critère - Test bouton \' n'a pas été rajouté à la liste");
			throw e;
		}
	}
	
	/**
	 * Méthode de confirmation du "Critère - Test bouton 2 dans le tableau des types de critères"
	 * @throws Exception
	 */
	public void assertCritereTestBoutonTableau2() throws Exception {
		Thread.sleep(2000);
		try {
			Highlighter.highLightElement(driver, this.presence_critere_test_bouton2);
			Assert.assertTrue("Ajout à la liste de \'Critère - Test bouton 2\'", this.presence_critere_test_bouton2.isDisplayed());
		}catch(AssertionError e) {
			System.out.println("Le \'Critère - Test bouton \' n'a pas été rajouté à la liste");
			throw e;
		}
	}
	
	
	/**
	 * Méthode de confirmation de la non modification de "Critère - Test bouton" dans le tableau
	 * @throws Exception
	 */
	public void assertNonModification() throws Exception {
		Thread.sleep(2000);
		try {
			Assert.assertTrue("Non modification du titre du critère", this.presence_critere_test_bouton.getText().equals("Critère - Test bouton"));
		} catch (AssertionError e) {
			System.out.println(" \'Critère - Test bouton\' a été modifié dans le tableau");
			throw e;
		}
	}
	
	
	/**
	 * Méthode de confirmation de la suppression du message 
	 * @throws Exception
	 */
	public void assertPopUpConfirmation2() throws Exception {
		Thread.sleep(2000);
		try {
			Highlighter.highLightElement(driver, this.message_confirmation_suppression_2);
			Assert.assertTrue("Pop : confirmation suppression", this.message_confirmation_suppression_2.getText().equals("Supprimer Type de critère \"Critères - Test bouton 2\". Êtes-vous sûr ?"));
		} catch (Exception e) {
			System.out.println("Le message de confirmation de suppression de la pop up est incorrect ou ne s'est pas afficher.");
			throw e;
		}
			
		try {
			Assert.assertTrue("Présence du bouton annuler", this.pop_up_bouton_annuler.isDisplayed());
		} catch (Exception e) {
			System.out.println("Le bouton \'Annuler\' nest pas présent");
			throw e;
		}
			
		try {
			Assert.assertTrue("Présence du bouton Ok", this.pop_up_bouton_ok.isDisplayed());
		} catch (Exception e) {
			System.out.println("Le bouton \'Ok\' nest pas présent");
			throw e;
		}

	}
	
	/**
	 * Méthode de confirmation de la suppression du "critère - Test bouton 2" dans le tableau des types de critères
	 * @throws InterruptedException
	 */
	public void assertConfirmationSupression2() throws InterruptedException {
		Thread.sleep(2000);
		try {
			Assert.assertFalse("Suppression du \'Critère - Test bouton 2\'", this.presence_critere_test_bouton2.isDisplayed());
		}catch(AssertionError e) {
			System.out.println("Le \'Critère - Test bouton 2\' n'a pas été supprimé.");
			throw e;
		}
	}
	
	/**
	 * Méthode de confirmation de la suppression du "critère - Test bouton 2" dans le tableau des types de critères
	 * @throws Exception
	 */
	public void assertConfirmationSuppressionCritere2() throws Exception {
		Thread.sleep(2000);
		try {
			Assert.assertTrue("Message confirmation suppression critère 2", this.message_critere_2_suppression_confirmation.isDisplayed());
		} catch (Exception e) {
			System.out.println("Le message de confirmation de suppression du critère 2 ne s'est pas affiché!");
			throw e;
		}
	}
	

}
