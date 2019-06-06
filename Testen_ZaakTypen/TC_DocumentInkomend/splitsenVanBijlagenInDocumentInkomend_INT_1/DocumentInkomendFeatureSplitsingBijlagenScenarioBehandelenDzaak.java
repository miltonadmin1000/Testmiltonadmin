/**
 *  Scenario: behandelen D-zaak
   Given: gebruiker is ingelogd in de acceptatie-omgeving
   And: gebruiker bevindt zich in de rol 'Behandelaar Document Inkomend'
   When: gebruiker zoekt de aangemaakte testzaak door 'Test splitsen bijlagen' in te vullen in het veld 'betreft'
   Then: systeem toont zoekresultaten
   When: gebruiker klikt op de zaak onder het kopje 'Registereren'
   Then: systeem opent zaak
   When: gebruiker opent zaakdossier met de knop '<<' naast het kopje 'zaak dossier'
   Then: systeem opent zaakdossier
   And: gebruiker ziet 'Ingekomen email' staan in zaakdossier
   When: gebruiker vult links bij 'Vermoedelijk zaaktype' in 'Grondbanktaken'
   And: gebruiker drukt op enter
   Then: systeem toont mogelijkheid 'Grondbanktaken' in drop-down menu
   When: gebruiker kiest 'Grondbanktaken'
   Then: in het vakje 'Behandelaar:' komt 'Behandelaar Grondbanktaken' te staan
   When: gebruiker klikt links bovenin op de knop 'volgende fase'
   Then: systeem toont pop-up 'Naar fase CONTROLEREN'
   When: gebruiker klikt op 'Ja'
   Then: groen vinkje voor 'Registeren' links verschijnt
   When: gebruiker klikt op knop 'volgende fase'
   Then: pop-up 'Naar fase AFGEHANDELD' wordt getoond
   When: gebruiker klikt op 'OK'
   Then: zaak wordt afgesloten
   And: gebruiker keert terug naar de werkvoorraad van 'mijn zaken'
   
 */
package splitsenVanBijlagenInDocumentInkomend_INT_1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import InloggenAccept.InloggenAcceptatieOmgeving_Milton;
import InloggenAccept.InloggenAcceptatieOmgeving_tester01;

/**
 * @author G5888
 *
 */
public class DocumentInkomendFeatureSplitsingBijlagenScenarioBehandelenDzaak  {

	
	
public static void main(String[] args) {

	System.out.println("======================================================START TEST==============================================");
	 //Java kiest Firefox alls webdriver		  
	  System.setProperty("webdriver.gecko.driver","G:\\Desktop\\automation\\geckodriver-v0.24.0-win64\\geckodriver.exe");
	  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  
	  //Selenium driver kiest voor firefox browser
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  
	  
	  //Acceptatie omgeving wordt geopend
	  driver.get("https://zaken.acceptatie.amstelveen.nl/login");
		  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tst01");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tester01");
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
      driver.findElement(By.xpath("/html/body/div/form/button")).click();
	   System.out.println("gebruiker is ingelogd in de acceptatie omgeving");
	   //driver checkt als gebruiker is gauthoriseerd		  
	   if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[1]/div[2]")) != null){
		  System.out.println("Webpagina is OK");
	  }
	  else{
		  System.out.println("Webpagina is niet OK");
   }
	
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ext-comp-1017']"))).sendKeys("Test splitsen bijlagen");
    System.out.println("betreft veld gevonden");
	

	
	
System.out.println("======================================================EINDE TEST==============================================");



}}