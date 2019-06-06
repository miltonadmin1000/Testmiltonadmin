/**
 *   Scenario: registrator doet herbeoordeling
   Given: gebruiker bevindt zich in de rol 'Tester Een' na check terugfasering
   And: gebruiker heeft zoekopdracht naar testcase 'test d-zaak generiek' uitgevoerd
   When: gebruiker selecteert zaak onder kop Registeren
   Then: zaak wordt geopend
   When: gebruiker verwijdert de rol 'Beleid x BI' uit het tekst vak onder 'Behandelaar:' links in het scherm middels kruisje
   Then: 'Beleid x BI' verdwijnt uit het tekstvak
   When: gebruiker vult het tekstvak met de tekst 'Beleid x ASM'
   Then: systeem toont opties middels drop-down menu
   When: gebruiker selecteert de optie 'Beleid x ASM'
   Then: button 'Beleid x ASM' verschijnt in tekstveld onder 'Behandelaar:'
   When: gebruiker noteert zaaknummer
   And: gebruiker klikt op knop 'volgende fase'
   Then: pop-up verschijnt met de boodschap 'U bent klaar met Registreren. De zaak gaat naar fase Controleren. Wilt u doorgaan?'
   When: gebruiker klikt op 'Ja'
   Then: zaak wordt gesloten
   And: gebruiker keert terug naar werkvoorraad in de rol 'Tester Een'
  
 */
package RegistratorDoetHerbeoodeling_INT_11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
public class TC_DocumentInkomendFeatureDScenarioRegistratorDoetHerbeoordeling {

	/**
	 * @param args
	 */
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
			
			 
				 //Then: zaak wordt geopend
				 WebDriverWait waitgeopend = new WebDriverWait(driver, 10);
				 waitgeopend.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='print'])[1]/preceding::span[2]")));
				 System.out.println("Zaak is geopend'_OK");
				 
				 
				// When: gebruiker verwijdert de rol 'Beleid x BI' uit het tekst vak onder 'Behandelaar:' links in het scherm middels kruisje
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				
			
				
			   
			   
			   
			}
			
		
		
		

	}


