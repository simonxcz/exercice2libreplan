package Autom3.libreplan2;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class TypeAvancementPage extends RessourcesPage {

	public TypeAvancementPage(WebDriver driver) {
		super(driver);
	}


	public void isDisplayed_with_try_catch(String info, WebElement wl, String message_error) throws Exception{  // function personnelle, is affiché
		try {
			Thread.sleep(2000);
			Assert.assertTrue(wl.isDisplayed());
			System.out.println(info + "  OK!");
		} catch(Exception e) {
			System.out.println("KO !! " + message_error);
			
		}

	}

	public void isEmpty_with_try_catch(String info, WebElement wl, String message_error) throws Exception{  // function personnelle, is vide
		try {
			Assert.assertTrue(wl.getText().isEmpty());
			System.out.println(info + "  OK!");
		} catch(Exception e) {
			System.out.println("KO !! " + message_error);
			throw e;
		}

	}

	public void isSelected_with_try_catch(String info, WebElement wl, String message_error) throws Exception{  // function personnelle, is Cochee
		try {
			Assert.assertTrue(wl.isSelected());
			System.out.println(info + "  OK!");
		} catch(Exception e) {
			System.out.println("KO !! " + message_error);
			throw e;
		}

	}

	public void is_not_Selected_with_try_catch(String info, WebElement wl, String message_error) throws Exception{  // function personnelle, is Cochee
		try {
			Assert.assertFalse(wl.isSelected());
			System.out.println(info + "  OK!");
		} catch(Exception e) {
			System.out.println("KO !! " + message_error);
			throw e;
		}

	}

	public void my_clear_and_write(WebElement wl, String text) {
		wl.clear();
		wl.sendKeys(text);
	}
	
	//----------------------------------  2  -------------------------------------------

	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-header' and contains(.,\"Types d'avancement Liste\")]")
	WebElement titre_de_la_page; // titre de la page
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']")
	WebElement ava_table; //la table
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//div[@class='z-column-cnt' and contains(., 'Nom')]")
	WebElement ava_tabl_colonne_nom; // colonne nom
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//div[@class='z-column-cnt' and contains(., 'Activé')]")
	WebElement ava_tabl_colonne_active; // colonne active
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//div[@class='z-column-cnt' and contains(., 'Prédéfini')]")
	WebElement ava_tabl_colonne_predefini; // colonne Prédéfini
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//div[@class='z-column-cnt' and contains(., 'Opérations')]")
	WebElement ava_tabl_colonne_acive; // colonne Opérations
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//td[@class='z-button-cm' and contains(.,'Créer')]")
	WebElement ava_bouton_creer; // bouton creer

	public void resultatAttenduAvaCT1PT2() throws Exception {  //Résultat Attendu "Ava_CT1_Pas 2"
		isDisplayed_with_try_catch(" Affichage de la page -Types d'avancement Liste-", titre_de_la_page, "La page n'est pas affichée");
		isDisplayed_with_try_catch(" Affichage d'un tableau", ava_table, "La table n'est pas présente");
		isDisplayed_with_try_catch("   colonne 'nom'", ava_tabl_colonne_nom, "colonne 'nom' n'est pas présente");
		isDisplayed_with_try_catch("   colonne 'active'", ava_tabl_colonne_active, "colonne 'active' n'est pas présente");
		isDisplayed_with_try_catch("   colonne 'predefini'", ava_tabl_colonne_predefini, "colonne 'predefini' n'est pas présente");
		isDisplayed_with_try_catch("   bouton 'créer'", ava_bouton_creer, "bouton 'créer' n'est pas présente");
	}
	
	//----------------------------------  3  -------------------------------------------

	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-header' and contains(.,\"Créer Type d'avancement\")]")
	WebElement ava_titre_de_la_page_creer_type_avancement; // titre de la page
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//div[@class='z-tabs-header']//span[contains(.,'Modifier')]")
	WebElement ava_titre_table_modifier; // un tableau intitulé "Modifier" avec les éléments suivants
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//div[@class='z-tabpanels']//span[contains(.,\"Nom d'unité\")]/following::input[1]")
	WebElement ava_champ_nom_unite; // Nom d'unité
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//div[@class='z-tabpanels']//span[contains(.,\"Actif\")]/following::input[1]")
	WebElement ava_checkbox_actif; // Actif
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//div[@class='z-tabpanels']//span[contains(.,'Valeur maximum par défaut')]/following::input[1]")
	WebElement ava_champ_valeur_par_defaut; // Valeur maximum par défaut
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//div[@class='z-tabpanels']//span[contains(.,\"Précision\")]/following::input[1]")
	WebElement ava_champ_precision; // Précision Précision : champ de saisie avec pour valeur par défaut "0,1000"
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//div[@class='z-tabpanels']//span[contains(.,\"Type\")]/following::input[1]")
	WebElement ava_champ_type; // Type : Valeur non modifiable "User"
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//div[@class='z-tabpanels']//span[contains(.,\"Pourcentage\")]/following::input[1]")
	WebElement ava_champ_pourcentage; // Pourcentage : case à cocher décochée par défaut
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//td[.='Enregistrer']")
	WebElement ava_bouton_enregistrer; // [Enregistrer]
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//td[.='Sauver et continuer']")
	WebElement ava_bouton_sauver_et_continuer; // [Sauver et continuer]
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-cnt-noborder']//td[.='Annuler']")
	WebElement ava_bouton_annuler; // [Annuler]

	public void my_select_it(WebElement wl) {
		if (!wl.isSelected()) { // si element n'est pas sélectionné
			wl.click(); // cliquer pour le sélectionné
		}
	}

	public void is_equals_with_try_catch(String info, WebElement wl, String equal_text, String message_error) throws Exception{
		try {
			String a = wl.getText();
			Assert.assertEquals(a, equal_text);
			System.out.println(info + "  OK!");
		} catch(Exception e) {
			System.out.println("KO !! " + message_error);
			throw e;
		}
	}



	public void resultatAttenduAvaCT1PT3() throws Exception {  //Résultat Attendu "Ava_CT1_Pas 3"
		isDisplayed_with_try_catch(" Affichage de la page -Créer Type avancement-", ava_titre_de_la_page_creer_type_avancement, "La page n'est pas affichée"); //Affichage de la page "Créer Type d'avancement"0
		isDisplayed_with_try_catch(" Affichage de la page -Créer Type avancement-", ava_titre_table_modifier, "La page n'est pas affichée"); //Affichage de la page "Créer Type d'avancement"
		isEmpty_with_try_catch(" Le champs 'nom' est vide ", ava_champ_nom_unite, "Le champs n'est pas vide"); //Nom d'unité : champ de saisie non renseigné
		isSelected_with_try_catch(" 'Actif' est cochée par défaut", ava_checkbox_actif,"'Actif' n'est pas cochée par défaut");  // Actif : case à cocher cochée par défaut
//		is_equals_with_try_catch("Valeur maximum par défaut est 100,00", ava_champ_valeur_par_defaut,"100,00","Valeur par défaut n'est pas 100,00"); //Valeur maximum par défaut : champ de saisie avec pour valeur par défaut "100,00"
//		is_equals_with_try_catch("Type : Valeur non modifiable 'User'", ava_champ_type,"User", "Valeur par défaut n'est pas 100,00"); // Type : Valeur non modifiable "User"
		isDisplayed_with_try_catch(" Bouton Enregister", ava_bouton_enregistrer, "bouton 'Enregistrer' n'est pas présent");
		isDisplayed_with_try_catch(" Bouton Sauver et Continuer", ava_bouton_sauver_et_continuer, "bouton 'Sauver et Continuer' n'est pas présent");
		isDisplayed_with_try_catch(" Bouton Annuler", ava_bouton_annuler, "bouton 'Annuler' n'est pas présent");

	}
	
	//----------------------------------  4  -------------------------------------------

	@FindBy(how = How.XPATH, using ="//div[@class='message_INFO']//span[contains(.,'Type d'avancement \"Type avancement - Test 2\" enregistré')]")
	WebElement ava_message_info; // item dans le table Nom : Type avancement - Test 1
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 1')]")
	WebElement ava_tr_test_1; // item dans le table Nom : Type avancement - Test 1
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 1')]/following::input[1]")
	WebElement ava_tr_test_1_active; // colonne Nom : Type avancement - Test 1
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 1')]/following::input[2]")
	WebElement ava_tr_test_1_predefini; // colonne Prédéfini : Type avancement - Test 1
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 1')]/../../following::span[@title='Modifier'][1]")
	WebElement ava_tr_test_1_operation_icon_modifier; // Opérations : colonne contenant une icône "Modifier"
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 1')]/../../following::span[@title='Supprimer'][1]")
	WebElement ava_tr_test_1_operation_icon_supprimer; // Opérations : colonne contenant une icône "Supprimer"



	//---------- method personnelle --------//
	public void is_Editable_with_try_catch(String info, WebElement wl, String message_error) throws Exception {
		try {
			Assert.assertTrue(wl.isEnabled());
			System.out.println(info + "  OK!");
		} catch(Exception e) {
			System.out.println("KO !! " + message_error);
			throw e;
		}
	}

	public void is_Not_Editable_with_try_catch(String info, WebElement wl, String message_error) throws Exception {
		try {
			Assert.assertFalse(wl.isEnabled());
			System.out.println(info + "  OK!");
		} catch(Exception e) {
			System.out.println("KO !! " + message_error);
			throw e;
		}
	}
	// -----------------------------------//

	public void resultatAttenduAvaCT1PT4() throws Exception {  //Résultat Attendu "Ava_CT1_Pas "
		Thread.sleep(2000);
		isDisplayed_with_try_catch(" Affichage de la page -Types d'avancement Liste-", titre_de_la_page, "La page n'est pas affichée"); // Retour sur la page "Types d'avancement Liste" sur laquelle :
		Thread.sleep(2000);
		isDisplayed_with_try_catch(" le message suivant est affiché :'Type avancement - Test 1' enregistré", ava_message_info, "La page n'est pas affichée"); // - le message suivant est affiché : "Type d'avancement "Type avancement - Test 1" enregistré"
		Thread.sleep(2000);
		isDisplayed_with_try_catch(" Type avancement - Test 1 est affiché", ava_tr_test_1, "Type avancement - Test 1 n'est pas affichée dans la table"); // Nom : Type avancement - Test 1
		//is_not_Selected_with_try_catch("Activé : Case décochée", ava_tr_test_1_active, "Activé : Case est cochée !"); // Activé : Case décochée
		Thread.sleep(2000);
		is_Not_Editable_with_try_catch(" Activé : Case décochée et non modifiable", ava_tr_test_1_active, "Activé : Case décochée et modifiable !"); // Activé : Case non modifiable
		//is_not_Selected_with_try_catch("Activé : Case décochée", ava_tr_test_1_predefini, "Activé : Case est cochée !");//Prédéfini : Case décochée
		Thread.sleep(2000);
		is_Not_Editable_with_try_catch(" Activé : Case décochée et non modifiable", ava_tr_test_1_predefini, "Activé : Case décochée et modifiable !"); //Prédéfini : case non modifiable
		Thread.sleep(2000);
		isDisplayed_with_try_catch(" Bouton 'Modifier' est présent", ava_tr_test_1_operation_icon_modifier, "Bouton 'Modifier' n'est pas present !");//Opérations : colonne contenant une icône "Modifier" et "Supprimer"
		Thread.sleep(2000);
		isDisplayed_with_try_catch(" Bouton 'Supprimer' est présent", ava_tr_test_1_operation_icon_supprimer, "Bouton 'Supprimer' n'est pas present !");//Opérations : colonne contenant une icône "Modifier" et "Supprimer"

	}

	// ------------------------------- 5 ---------------------------------- 
	 	//pas de function, meme fonction que Pas 3
	
	
	//-------------------------------- 6 ------------------------------------	
	
	@FindBy(how = How.XPATH, using ="//div[@class='z-tabpanels' and contains(@id,'x4')]//tbody//span[contains(.,'Valeur maximum par défaut')]/following::input[1]")
	WebElement ava_champ_valeur_maximum_par_defaut; // checkbox pourcentage

	public void resultatAttenduAvaCT1PT6() throws Exception { //Le champ de saisie "Valeur maximum par défaut" est grisé et non modifiable.
		
		is_Not_Editable_with_try_catch(" Le champ de saisie 'Valeur maximum par défaut' est grisé et non modifiable", ava_champ_valeur_maximum_par_defaut, "Le champ de saisie 'Valeur maximum par défaut' est modifiable");
	}
	
    //----------------------------------  7  -------------------------------------------
	@FindBy(how = How.XPATH, using ="//div[@class='z-window-embedded-header' and contains(.,\"Modifier Type d'avancement: Type avancement - Test 2\")]")
	WebElement ava_titre_de_la_page_modifier_type_avancement; // titre de la page
	
	public void resultatAttenduAvaCT1PT7() throws Exception { //Affichage du message suivant "Type d'avancement "Type d'avancement - Test 2" enregistré"
		isDisplayed_with_try_catch(" Le titre de la page est \"Modifier Type d'avancement: Type d'avancement - Test 2", ava_titre_de_la_page_modifier_type_avancement, "Error");	// Le titre de la page est "Modifier Type d'avancement: Type d'avancement - Test 2
	}

	//----------------------------------  8  -------------------------------------------
	public void resultatAttenduAvaCT1PT8() throws Exception { //Retour sur la page "Types d'avancement Liste".
		Thread.sleep(1000);
		isDisplayed_with_try_catch(" Affiche la page 'Types d'avancement Liste'" , titre_de_la_page, "La page n'est pas affiché !");
	}


	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 2')]")
	WebElement ava_tr_test_2; // item dans le table Nom : Type avancement - Test 1
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 2')]/following::input[1]")
	WebElement ava_tr_test_2_active; // colonne Nom : Type avancement - Test 1
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 2')]/following::input[2]")
	WebElement ava_tr_test_2_predefini; // colonne Prédéfini : Type avancement - Test 1
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 2')]/../../following::span[@title='Modifier'][1]")
	WebElement ava_tr_test_2_operation_icon_modifier; // Opérations : colonne contenant une icône "Modifier"
	@FindBy(how = How.XPATH, using ="//div[contains(@id, 'k4') and @class='clickable-rows z-grid']//span[contains(.,'Type avancement - Test 2')]/../../following::span[@title='Supprimer'][1]")
	WebElement ava_tr_test_2_operation_icon_supprimer; // Opérations : colonne contenant une icône "Supprimer"

	
	//----------------------------------   9  -------------------------------------------
	public void resultatAttenduAvaCT1PT9() throws Exception { //Le type d'avancement créé est présent dans le tableau avec les informations suivantes :
		Thread.sleep(1000);
		isDisplayed_with_try_catch(" Affichage de la page -Types d'avancement Liste-", titre_de_la_page, "La page n'est pas affichée"); // Retour sur la page "Types d'avancement Liste" sur laquelle :
		isDisplayed_with_try_catch(" Type avancement - Test 2 est affiché", ava_tr_test_2, "Type avancement - Test 2 n'est pas affichée dans la table"); // Nom : Type avancement - Test 2
		isSelected_with_try_catch(" Activé : Case cochée", ava_tr_test_1_active, "Activé : Case est décochée !"); // Activé : Case cochée
		is_Not_Editable_with_try_catch(" Activé : Case décochée et non modifiable", ava_tr_test_2_active, "Activé : Case décochée et modifiable !"); // Activé : Case non modifiable
		//is_not_Selected_with_try_catch("Activé : Case décochée", ava_tr_test_1_predefini, "Activé : Case est cochée !");//	Prédéfini : Case décochée
		is_Not_Editable_with_try_catch(" Activé : Case décochée et non modifiable", ava_tr_test_2_predefini, "Activé : Case décochée et modifiable !"); //Prédéfini : case non modifiable
		isDisplayed_with_try_catch(" Bouton 'Modifier' est présent", ava_tr_test_2_operation_icon_modifier, "Bouton 'Modifier' n'est pas present !");//Opérations : colonne contenant une icône "Modifier" et "Supprimer"
		isDisplayed_with_try_catch(" Bouton 'Supprimer' est présent", ava_tr_test_2_operation_icon_supprimer, "Bouton 'Supprimer' n'est pas present !");//Opérations : colonne contenant une icône "Modifier" et "Supprimer"

	}

}
