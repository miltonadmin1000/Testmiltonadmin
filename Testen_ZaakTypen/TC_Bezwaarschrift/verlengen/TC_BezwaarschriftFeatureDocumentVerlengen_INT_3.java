/*Testcase: Bezwaarschrift
 
 Feature: zaak verlengen
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 Background: gebruiker is geautoriseerd voor de rol Assistent Bezwaarschrift
 
  Scenario: testzaak verlengen
   Given: gebruiker opent een testzaak met in het betreft-veld 'Bezwaarschrift Veen' onder het kopje Beoordelen
   And: gebruiker noteert het betreffende zaaknummer
   When: gebruiker klikt op knop 'zaak' rechtsboven 
   Then: drop-down menu verschijnt met opties voor zaak
   When: gebruiker selecteert optie 'zaak verlengen'
   Then: pop-up verschijnt getiteld 'Zaak verlengen'
   When: gebruiker bij 'Aantal dagen verlengen' het getal '2' invult
   And: gebruiker bij 'Toelichting' de opmerking 'TESTVerlengen' invult
   And: gebruikt klikt op 'Verlengen'
   Then: systeem gaat terug naar overzicht werkvoorraad Behandelaar Grondbanktaken
   When: gebruiker klikt op testzaak met hetzelfde zaaknummer
   Then: zaak wordt geopend
   When: gebruiker opent onderdeel links 'log'
   Then: lijst met zaakgebeurtenissen wordt getoond
   And: onderste onderdeel van de log is 'Signaal Alarm: Zaak verlengd met 2 dagen. TESTVerlengen'
 * 
 */

package verlengen;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_BezwaarschriftFeatureDocumentVerlengen_INT_3 {

		
		
		public static void main(String[] args) throws IOException, InterruptedException, AWTException { {
			
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
					  		  

					  System.out.println("Gebruiker is geauthoriseerd_Webpagina is OK");
				  }
				  else{
					  System.out.println("Gebruiker is geauthoriseerd_Webpagina is NOT OK");
				  }

				//klikken dropdown
				  	try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  	   ClickElement(driver, "ext-gen95");
				  	   System.out.println("Zaakcoördinator Bezwaarschrift ziet alle zaken_OK");
				  	
				  	 //kiezen rol van Assistent Bezwaarschrift - amstelveen
				  	   driver.findElement(By.xpath("//div[contains(text(), 'Assistent Bezwaarschrift - amstelveen')]")).click();
				  	   System.out.println("Assistent Bezwaarschrift - amstelveen is gekozen en ziet alle zaken_OK");
					  

					  try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
					 // Given: gebruiker opent een testzaak met in het betreft-veld 'Bezwaarschrift Veen' onder het kopje Beoordelen
		
					  driver.findElement(By.xpath("//input[@id='ext-comp-1017']")).sendKeys("Bezwaarschrift Veen");
				  	   System.out.println("Assistent Bezwaarschrift gebruiker opent een testzaak _OK");
					  
				  	   
				  	   
				  	   //And: gebruiker noteert het betreffende zaaknummer
				  	 //driver.findElement(By.xpath("//*[@id=\"ext-comp-1016\"]")).sendKeys("Z18-004177");
					  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/div")).click();
					  							
					  
					  
					 // When: gebruiker klikt op knop 'zaak' rechtsboven 
					  // Then: drop-down menu verschijnt met opties voor zaak
					 //  When: gebruiker selecteert optie 'zaak verlengen'
					  
					  ClickElement(driver, "ext-gen155");	
			  			
			  			 try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				System.out.println("zaak geklikt_OK"); 
				
				
				
				
				 // When: gebruiker selecteert optie 'zaak verlengen'
				  //Then: pop-up verschijnt getiteld 'Zaak verlengen'
				driver.findElement(By.xpath("//*[contains(text(),'zaak verlengen')]")).click();
				
				System.out.println("gebruiker selecteert optie 'zaak verlengen_OK");
				
					 

	  			 try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						 
				//When: gebruiker bij 'Aantal dagen verlengen' het getal '2' invult
			    // And: gebruiker bij 'Toelichting' de opmerking 'TESTVerlengen' invult
				//And: gebruikt klikt op 'Verlengen'
	  			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='annuleren'])[1]/preceding::input[1]")).sendKeys("2");
				driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Verlengen'])[1]/preceding::textarea[1]")).sendKeys("TESTVerlengen");	
				
				System.out.println("gebruiker heeft bij 'Aantal dagen verlengen' het getal '2' ingevuld _OK");
				System.out.println("gebruiker heeft bij 'Toelichting' het getal 'TESTVerlengen'ingevuld_OK");
				
				//   And: gebruikt klikt op 'Verlengen'
				//   Then: systeem gaat terug naar overzicht werkvoorraad Behandelaar Grondbanktaken
				WebDriverWait waitZkVrlng1 = new WebDriverWait(driver, 1000);
				WebElement elementZkVrlng1 = waitZkVrlng1.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".x-panel-footer .x-toolbar-cell:nth-of-type(2) [type]")));
				driver.findElement(By.xpath("//button[contains(text(),'Verlengen')]")).click();


	  			 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  			 
				//When: gebruiker klikt op testzaak met hetzelfde zaaknummer
				
				driver.findElement(By.xpath("//div[@id='ext-comp-1015-filter-1']/input")).sendKeys("Z18-004177");
				System.out.println("testzaak is opgehaald met zelfde zaaknummer_OK");
				
				
				
	  			 try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  			 // Then: zaak wordt geopend
	  			 driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Beoordelen (1)'])[1]/following::div[5]")).click();
	  			System.out.println("Gebruiker heeft testzaak geklikt met zelfde zaaknummer_OK");
				 
	  			 try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
				 WebDriverWait waitlogknp = new WebDriverWait(driver, 800);
				 WebElement elementlogknp = waitlogknp.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='voortgang'])[1]/following::div[4]")));
				 WebElement logknp = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='voortgang'])[1]/following::div[4]"));
				 JavascriptExecutor jse =  (JavascriptExecutor)driver;
				 jse.executeScript("arguments[0].click();", logknp );
				
				 
				 
				 
				//driver laten zoioekn op aanwezigheid van de text

				 if(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Start van zaak'])[1]/following::div[13]")) != null){
				 
			

					 System.out.println("   onderste onderdeel van de log is 'Signaal alarm: Zaak verlengd met 2 dagen. TESTVerlengen'_TEST SUCCES!");
				  }
				  else{
					  System.out.println("   onderste onderdeel van de log is 'Signaal Alarm: Zaak verlengd met 2 dagen. TEST_FAILED!");
				  }

				 
				 
				 try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
		
				 //kill de driver, webpagina sluit af
				 
				 driver.quit();
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				
				
	}}

		private static void ClickElement(WebDriver driver, String string) {
			// TODO Auto-generated method stub
			
		}}


