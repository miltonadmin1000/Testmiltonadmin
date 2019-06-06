/**
 *  
  Scenario: medewerker checkt kopie aan in zaaksysteem
   Given: gebruiker is ingelogd in de acceptatie-omgeving als 'tst01' na check mail
   When: gebruiker klikt op de tab 'zoeken' 
   Then: overzicht met zoekschermen wordt getoond
   When: gebruiker selecteert de tab 'Zoeken kopie aan' 
   Then: overzicht met alle zaken 'kopie aan' wordt getoond
   When: gebruiker vult in het zoekvakje onder kolom 'Documentnummer' het genoteerde zaaknummer in
   Then: zoekresultaten worden getoond
   And: systeem toont de betreffende zaak met als 'betreft' de tekst 'test kopie aan' 
 *  
 */
package scenario_MedewerkerChecktKopieAanInZaaksysteem;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author G5888
 *
 */
public class Scenario_MedewerkerChecktKopieAanInZaaksysteem {

	public static void main(String[] args) {
		
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
			  System.out.println("test01 is succesvol ingelogd");
		   }
		  else{
			  System.out.println("Webpagina is niet OK");
		  
		  }
 


}}		
	
	