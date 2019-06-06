/**
 * Scenario: D-zaak registeren voor zaaktype Beleid
   Given: gebruiker heeft zojuist nieuwe D-zaak aangemaakt middels bovenstaand scenario
   And: gebruiker bevindt zich in de werkvoorraad 'mijn zaken' van de persoonlijke rol van de gebruiker (dus de 'naam' van de gebruiker)
   When: gebruiker zoekt in kolom 'betreft' naar de tekst 'test d-zaak generiek'
   Then: zoekresultaten worden getoond
   When: gebruiker selecteert zaak onder kop 'Registreren'
   Then: zaak wordt geopend
   When: gebruiker vult in tekstvak onder 'Vermoedelijk zaaktype:' linksboven de tekst 'Beleid'
   And: gebruiker drukt op enter
   Then: drop-down met opties wordt getoond
   When: gebruiker selecteert de optie 'Beleid' met subtekst 'Het opstellen van beleid'
   When: gebruiker verwijdert 'Behandelaar Document inkomend' uit het veld 'Behandelaar' middels het kruisje
   And: gebruiker vult in het veld 'Behandelaar' de tekst 'Beleid X BI' in
   Then: systeem geeft mogelijkheden in drop-down
   When: gebruiker selecteert de enige optie 'Beleid x BI'
   Then: 'Beleid x BI' vakje wordt ingevoegd in het tekst vak van 'Behandelaar'
   When: gebruiker klikt links bovenin op 'volgende fase'
   Then: pop-up verschijnt met de boodschap 'U bent klaar met Registreren. De zaak gaat naar fase Controleren. Wilt u doorgaan?'
   When: gebruiker klikt op 'Ja'
   Then: zaak wordt gesloten en gebruiker keert terug naar werkvoorraad van Behandelaar Document inkomend
  
 */
package DzaakRegistrerenVoorZaakTypeBeleid;

import java.sql.Driver;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;
import javax.xml.soap.Text;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author G5888
 *
 */
public class TC_DocumentInkomendScenarioDzaakRegisterenVoorZaaktypeBeleid {

	/**
	 * @param args
	 */
	//Scenario: D-zaak registeren voor zaaktype Beleid
	// Given: gebruiker heeft zojuist nieuwe D-zaak aangemaakt middels bovenstaand scenario
	// And: gebruiker bevindt zich in de werkvoorraad 'mijn zaken' van de persoonlijke rol van de gebruiker (dus de 'naam' van de gebruiker)
	public static void main(String[] args) {
		
		 System.out.println("============================================START TEST================================================================");
		
		
		 //Java kiest Firefox alls webdriver		  
		 System.setProperty("webdriver.gecko.driver","G:\\Desktop\\automation\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 
		 //Selenium driver kiest voor firefox browser
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 
		 
		 //Acceptatie omgeving wordt geopend
		 driver.get("https://zaken.acceptatie.amstelveen.nl/login");
		 	  
		 
		 //Inloggen in acceptatie omgeving
		 driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tst01");
		 driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tester01");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		 driver.findElement(By.xpath("/html/body/div/form/button")).click();
		//compare the actual title with the expected title

		 System.out.println("gebruiker is ingelogd in de acceptatie omgeving");
		 
		 //driver checkt als gebruiker is gauthoriseerd		  

		 if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[1]/div[2]")) != null){
			  		  

			  System.out.println("Webpagina is OK");
		 }
		 else{
			  System.out.println("Webpagina is niet OK");
		 }

		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   //And: gebruiker heeft zoekopdracht naar testcase 'test d-zaak generiek' uitgevoerd
		    WebDriverWait wait = new WebDriverWait(driver, 10);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='zaken'])[2]/preceding::input[21]")));
			  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='zaken'])[2]/preceding::input[21]")).sendKeys("test d-zaak generiek");
			  System.out.println("gebruiker vult in het veld 'Betreft' onder titel 'Betreft' de tekst in ' 'test d-zaak generiek'_OK");
			    
			 
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
			 // When: gebruiker selecteert zaak onder kop Registeren
		     WebDriverWait waitRegistreer = new WebDriverWait(driver, 10);
		     waitRegistreer.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test d-zaak generiek'])[1]/preceding::div[1]")));
			 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='test d-zaak generiek'])[1]/preceding::div[1]")).click();
			 System.out.println("gebruiker selecteert zaak onder kop Registeren'_OK");
			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  
			 //Then: zaak wordt geopend
			 WebDriverWait waitgeopend = new WebDriverWait(driver, 10);
			 waitgeopend.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='print'])[1]/preceding::span[2]")));
			 System.out.println("Zaak is geopend'_OK");
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  
			 
			 
			 
			 
			 //When: gebruiker vult in tekstvak onder 'Vermoedelijk zaaktype:' linksboven de tekst 'Beleid'
			  driver.findElement(By.name("initiatiezaaktypeonderwerp")).sendKeys("Beleid");
			  System.out.println("gebruiker vult in tekstvak onder 'Vermoedelijk zaaktype:' linksboven de tekst 'Beleid'_OK");
			  driver.findElement(By.name("initiatiezaaktypeonderwerp")).sendKeys(Keys.ENTER);
			  System.out.println("gebruiker drukt op enter_OK");
			  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  driver.findElement(By.xpath("//div[@id='ext-gen968']/div[3]/div")).click();
			  try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  driver.findElement(By.xpath("//div[@id='ext-gen247']/div[1]")).click();
			  
			  try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			//------------------------------------------------------------------------------------------------------
			 // And: gebruiker vult in het veld 'Behandelaar' de tekst 'Beleid X BI' in
			  driver.findElement(By.xpath("//div[@id='ext-gen247']/div[2]")).click();
			  System.out.println("gebruiker vult in het veld 'Behandelaar' de tekst 'Beleid X BI' in_OK");
			  try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  //Then: 'Beleid x BI' vakje wordt ingevoegd in het tekst vak van 'Behandelaar'
			  driver.findElement(By.xpath("//div[@id='ext-gen245']/ul/li/input")).sendKeys("Beleid x BI");  
			  driver.findElement(By.xpath("//div[@id='ext-gen245']/ul/li/input")).sendKeys(Keys.ENTER);
			  System.out.println("'Beleid x BI' vakje wordt ingevoegd in het tekst vak van 'Behandelaar'_OK");
			  
			  
			  
			  //When: gebruiker klikt links bovenin op 'volgende fase'
			  driver.findElement(By.xpath("//button[text()='volgende fase']")).click();
			  try {
					Thread.sleep(1000);
				} catch (InterruptedException e4) {
					
					e4.printStackTrace();
				}
			 // Then: pop-up verschijnt met de boodschap 'U bent klaar met Registreren. De zaak gaat naar fase Controleren. Wilt u doorgaan?'
			  // When: gebruiker klikt op 'Ja'
			  driver.findElement(By.xpath("//button[text()='Ja']")).click();
			  System.out.println("pop-up verschijnt met de boodschap 'U bent klaar met Registreren. De zaak gaat naar fase Controleren. Wilt u doorgaan?_OK");
			  System.out.println(" gebruiker klikt op 'Ja'_OK ");
			  try {
					Thread.sleep(2000);
				} catch (InterruptedException e4) {
					
					e4.printStackTrace();
				}
			  
			  
			 // Then: zaak wordt gesloten en gebruiker keert terug naar werkvoorraad van Behandelaar Document inkomend
			  driver.findElement(By.xpath("//ul/li[7]/a[1]")).click();
			 System.out.println("============================================EINDE TEST================================================================");
			  
			  
			  
			  
	    }       		  
			  
			  
			  
			  
			  
			  
		
			  
			  
			  
			  
				}
	 
			  
			  
	

