package Autom3.libreplan2;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Outils.Highlighter;

public class ConnexionTest {
	WebDriver driver;

	@Test
	public CalendarPage  libreplanTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
	
		//driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
		driver.get("http://localhost:8180/libreplan/common/layout/login.zul");
		//Agrandir la fenêtre
		driver.manage().window().maximize();
		//Création d'une instance de la classe LoginPage
		LoginPage logpage = new LoginPage(driver);
		Highlighter.highLightElement(driver, logpage.getUtilisateur_field());
		Highlighter.highLightElement(driver, logpage.getMot_de_passe_login_field());
	
		//Wait pour être sûr de cliquer sur le bouton
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return logpage.clickSubmitButton();
	}
	
}