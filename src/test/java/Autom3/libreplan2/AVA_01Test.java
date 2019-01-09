package Autom3.libreplan2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AVA_01Test {

	@Test
	public void test() throws Exception {
		
		System.out.println("Pas de test 1 - Connexion");	//Connexion à l'application
		ConnexionTest pageLogin = new ConnexionTest();		//Accession à la page calender
		CalendarPage pageAccueil = pageLogin.libreplanTest();		//Vérification de la page calendar
		pageAccueil.assertCalendrier();

		System.out.println("Pas de test 2 - Accès à la page d'administration des critères");
		TypeAvancementPage pageAvancement = pageAccueil.clickOngletRessourcesItemTypeAvancement();
		pageAvancement.resultatAttenduAvaCT1PT2();

		System.out.println("Pas de test 3");
		pageAvancement.ava_bouton_creer.click(); // cliquer sur le bouton 'Click'
		pageAvancement.resultatAttenduAvaCT1PT3();

		System.out.println("Pas de test 4");
		pageAvancement.ava_champ_nom_unite.clear();
		pageAvancement.ava_champ_nom_unite.sendKeys("Type avancement - Test 1");
		//pageAvancement.ava_checkbox_actif ;
		pageAvancement.ava_champ_valeur_par_defaut.clear();
		pageAvancement.ava_champ_valeur_par_defaut.sendKeys("10,00");
		//pageAvancement.ava_champ_pourcentage.
		pageAvancement.ava_bouton_enregistrer.click();
		pageAvancement.resultatAttenduAvaCT1PT4();

		System.out.println("Pas de test 5");
		pageAvancement.ava_bouton_creer.click(); // cliquer sur le bouton 'Click'
		Thread.sleep(1000);
		pageAvancement.isDisplayed_with_try_catch(" Affichage de la page -Créer Type avancement",pageAvancement.ava_titre_de_la_page_creer_type_avancement, "La page n'est pas affiché");

		System.out.println("Pas de test 6");
		pageAvancement.ava_champ_nom_unite.sendKeys("Type avancement - Test 2");  //Renseigner le champ "Nom d'unité" avec la valeur "Type avancement - Test 2"
		pageAvancement.ava_champ_pourcentage.click(); //2 - Cocher la case "Pourcentage"
		Thread.sleep(1000);
		pageAvancement.resultatAttenduAvaCT1PT6();

		System.out.println("Pas de test 7");
		pageAvancement.ava_bouton_sauver_et_continuer.click(); //Pour les autres champs du tableau "Modifier", laisser les valeurs par défaut puis cliquer sur le bouton [Sauver et continuer]
		pageAvancement.resultatAttenduAvaCT1PT7();

		System.out.println("Pas de test 8");
		pageAvancement.ava_bouton_annuler.click(); //Cliquer sur le bouton [Annuler].
		pageAvancement.resultatAttenduAvaCT1PT8();

		System.out.println("Pas de test 9");
		pageAvancement.resultatAttenduAvaCT1PT9();


	}

}


