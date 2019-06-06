/*Testcase: Grondbanktaken
 
 Feature: zaak annuleren
 Background: gebruiker(zaakcoordinator) is ingelogd in de acceptatie-omgeving
 Background: gebruiker bevindt zich in testzaak
 
  Scenario: testzaak annuleren
   When: gebruiker noteert zaaknummer
   And: gebruiker klikt op knop 'zaak' rechtsboven
   Then: drop-down menu verschijnt met opties voor zaak
   When: gebruiker selecteert optie 'zaak annuleren'
   Then: pop-up verschijnt getiteld 'Zaak annuleren'
   When: gebruikt vult in het veld 'Geef aan waarom u de zaak wilt annuleren' de tekst 'TESTAnnuleren' in
   And: gebruiker klikt op 'OK'
   Then: systeem gaat terug naar overzicht werkvoorraad Behandelaar Grondbanktaken
   When: gebruiker selecteert in drop-down menu met rollen de rol 'Zaakcoordinator Grondbanktaken - amstelveen'
   And: gebruiker klikt op knop 'geannuleerd'
   Then: testzaak corresponderend aan genoteerd zaaknummer verschijnt in lijst met geannuleerde zaken
    * 
 */

package zaakAnnuleren;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC_GrondbanktakenFeatureZaakAnnuleren_INT_7 {

	 public static void main(String[] args)throws Exception { {
			
		  
		 //Java kiest Firefox alls webdriver		  
		  System.setProperty("webdriver.gecko.driver","G:\\Desktop\\automation\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		  
		  //Selenium driver kiest voor firefox browser
		  WebDriver driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  
		  
		  //Acceptatie omgeving wordt geopend
		  driver.get("https://zaken.acceptatie.amstelveen.nl/login");
		  	  
		  
		  //Inloggen in acceptatie omgeving
		  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("G5888");
		  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Bainats@ams1000");
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
		  
		  
			//And: gebruiker selecteert in het drop-down menu de rol 'Behandelaar Grondbanktaken' 
			// Then: alle zaken voor Behandelaar Grondbanktaken verschijnen
		     WebElement drpdwnBGBT= driver.findElement(By.xpath("//*[@id=\"ext-gen95\"]"));
		     JavascriptExecutor jseBGBT =  (JavascriptExecutor)driver;
		     jseBGBT.executeScript("arguments[0].click();", drpdwnBGBT );
		     driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		     
		     
			  driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys("Zaakcoördinator Grondbanktaken - amstelveen");
			   driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys(Keys.RETURN);
			 // System.out.println("BehandelaarGrondbanktaken ziet alle zaken");
			 
			  
			  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			  
			  //hier even teruggaan naar een andere rol zodat hij goed refreshed
			   WebElement drpdwnBGBT1= driver.findElement(By.xpath("//*[@id=\"ext-gen95\"]"));
			   JavascriptExecutor jseBGBT1 =  (JavascriptExecutor)driver;
			   jseBGBT1.executeScript("arguments[0].click();", drpdwnBGBT1 );
			   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys(Keys.RETURN);
			  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			 
			  										  
			  driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys("Zaakcoördinator Grondbanktaken - amstelveen");
			   driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys(Keys.RETURN);
			  System.out.println("BehandelaarGrondbanktaken ziet alle zaken");

			  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			  try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
				  
			  
			 //Zaakcoördinator Grondbanktaken - amstelveen, kiest zaak
			  driver.findElement(By.cssSelector("div.x-grid3-row:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).click();
			  System.out.println("Registratie Grondbanktaken is geopend_OK");
			  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			  
			  
			  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//kenmerken open geklikt om zaaknummer te kopieren
			   driver.findElement(By.xpath(" //span[text()='kenmerken']")).click();
				
			
			   
			   
			   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   WebElement Casenumber = driver.findElement(By.xpath(" //div[text()=' referentiecode']"));
			   System.out.println(Casenumber.getAttribute("innerHTML"));  
			   
			   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			   /*
			
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			 //gebruiker zoekt zaak op en klikt erop
			      driver.findElement(By.xpath("//button[text()='zaak']")).click();
				  System.out.println("Dropdown zaak geklikt_OK"); 
			  
			   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;   
			      try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
			      
			       
			     
			 //When: gebruiker selecteert optie 'zaak annuleren'
			  driver.findElement(By.xpath("//span[text()='zaak annuleren']")).click();
			  System.out.println("Fase annuleren geklikt_OK");
			  
			  
			   
			  driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			   //Then: pop-up verschijnt met de boodschap 'Geef aan waarom u terug wilt naar de fase Behandelen'
				 //When: gebruiker vult in 'test' in textbox
				      
				  driver.findElement(By.xpath("//textarea[@class='ext-mb-textarea']")).click();    
				  driver.findElement(By.xpath("//textarea[@class='ext-mb-textarea']")).sendKeys("TESTAnnuleren");
				  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				  System.out.println("'TESTAnnuleren'is  ingevuld_OK"); 
				  
				  try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  			  
			  		   
			  
			    //And: gebruiker klikt op 'OK'
			      driver.findElement(By.xpath("//button[text()='OK']")).click();
				  try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  		
			  
			  
				  
			  
			      System.out.println("systeem gaat terug naar overzicht werkvoorraad Behandelaar Grondbanktaken_OK");
			     
			     driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   

				    //And: gebruiker klikt op 'geannuleerd'
				      driver.findElement(By.xpath("//button[text()='geannuleerd']")).click();
					System.out.println("gebruiker klikt op geannuleerd");
				      
				      
				      try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				   
				   System.out.println("EINDE TEST");
			*/	   
				   
	 }
	
	 }}
	
	

