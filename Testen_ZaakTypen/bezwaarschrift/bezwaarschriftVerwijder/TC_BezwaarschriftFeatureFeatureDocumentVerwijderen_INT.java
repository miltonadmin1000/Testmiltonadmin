/*
 * Testcase: Bezwaarschrift

 Feature: document verwijderen
 Background: gebruiker bevindt zich in testzaak Bezwaarschrift na toevoegen document
 
  Scenario: Collegevoorstel uit testzaak verwijderen
   When: gebruiker klikt op knop '<<' boven 'zaak dossier'
   Then: zaakdossier klapt uit 
   When: gebruiker klikt op het document met type 'Collegevoorstel'
   And: gebruiker sleept dit document naar de 'prullenbak' rechts onderin
   Then: pop-up verschijnt getiteld 'Verwijderen?' met de tekst 'Weet u zeker dat u zaak-document xx wilt verwijderen?'
   When: gebruiker klikt op 'Ja'
   And: gebruiker noteert het zaaknummer bovenin het tabblad
   And: gebruiker klikt op 'opslaan' linksboven 
   And: gebruiker sluit het tabblad van de zaak bovenin het scherm
   And: gebruiker klikt op 'ja' bij de pop-up 'wijzigingen opslaan'
   Then: gebruiker keert terug naar het scherm van de werkvoorraad
   When: gebruiker opent zaak met corresponderend zaaknummer
   And: gebruiker opent zaakdossier middels de knop '<<'
   Then: geen document met type 'Collegevoorstel' is zichtbaar in het zaakdossier
 * 
 */
package bezwaarschriftVerwijder;

		import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService.Builder;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.ClickElement;


public class TC_BezwaarschriftFeatureFeatureDocumentVerwijderen_INT {

	public static void main(String[] args) throws InterruptedException, TimeoutException, InvalidSelectorException {
		
		
		
		
		
		
						 
				
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

						  
						  
					
					//////////////////////////////////////////////////////////Scenario: Bijlage toevoegen In Sjabloon testzaak//////////////////////////////////////////////
						  	
						  	
						  	System.out.println("START_Scenario:Collegevoorstel uit testzaak verwijderen ");	
						  	
						  	
						  	//klikken dropdown
						  	try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						  	   ClickElement.clickByID(driver, "ext-gen95");
						  	   System.out.println("Zaakcoördinator Bezwaarschrift ziet alle zaken_OK");
						  	
							
						  	   //kiezen rol van zaakcoordinator bezwaarschriften
						  	   driver.findElement(By.xpath("//div[contains(text(), 'Zaakcoördinator Bezwaarschrift - amstelveen')]")).click();
						  	   System.out.println("Zaakcoördinator is gekozen en ziet alle zaken_OK");
							  

							  try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							  
							  
							  //Zaakcoordinator bezwaartaken selecteert bezwaarschrift met nummer '	'
							  
							  driver.findElement(By.xpath("//*[@id=\"ext-comp-1016\"]")).sendKeys("Z18-004177");
							  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td[2]/div")).click();
							  
							  
							  
							  System.out.println("bezwaarschrift is geselecteerd door coordinator_OK");
							  
						  	  try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				//----------------------------------------------------------------------------------------------------------				  
							  
						  	// When: gebruiker klikt op knop '<<' boven 'zaak dossier' 
						  	//Then: zaakdossier klapt uit
						 	  
						  	ClickElement.clickByID(driver, "ext-gen176");	
						  			
						  			 try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
							System.out.println("knop << boven zaak is gedrukt_en_zaakdossier klapt uit_OK");  
							
							
							
							
							//When: gebruiker klikt op drop-down menu 
							ClickElement.clickByID(driver, "ext-gen732");	
							
				 			 try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				    	System.out.println("dropdownmenu is uitgeklapt_OK");  
				    	
				
			
		//When: gebruiker klikt op het document met type 'Collegevoorstel'
			driver.findElement(By.xpath("//input[@name='ext-comp-1581' and @class='x-form-text x-form-field x-form-focus']")).sendKeys("Collegebesluit");
			driver.findElement(By.xpath("//input[@name='ext-comp-1581' and @class='x-form-text x-form-field x-form-focus']")).sendKeys(Keys.RETURN);
			System.out.println("Zaaksysteem toont collebesluitOverzicht_OK");    
				

			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

			 //---------------------------------------------------//---------------------------//------------------------

			   // And: gebruiker sluit het tabblad van de zaak bovenin het scherm
			   
				 WebDriverWait wait = new WebDriverWait(driver, 800);
		 		 WebElement elementkruisjeAfsl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]"
		 		 		+ "/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/ul/li[6]/a[1]")));
		 		 WebElement kruisjeAfsl = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]"
		 		 		+ "/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/ul/li[6]/a[1]"));
		 		 JavascriptExecutor jsekruisjeAfsl =  (JavascriptExecutor)driver;
		 		 jsekruisjeAfsl.executeScript("arguments[0].click();", kruisjeAfsl );
		 		 System.out.println("gebruiker sluit het tabblad van de zaak bovenin het scherm_OK");
		 	   
				 //----------------------------------//---------------------------------//-----------------------------------------------
		 		 
		 		   //Titel field selecteren
					driver.findElement(By.name("ext-comp-1573"));	
				    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
				    driver.findElement(By.name("ext-comp-1573")).sendKeys(("Collegebesluit"));
//--------------------------------------//-------------------------------//-----------------------------------------------------------				 	
				    try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    //hier ga je de zaak naar de vuilnisbak drag en droppen
				   // driver.manage().deleteAllCookies();
				    Actions action = new Actions(driver);
				    action.clickAndHold(driver.findElement(By.cssSelector("div.x-grid3-row:nth-child(34) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(4) > div:nth-child(1)"))).moveToElement(driver.findElement(By.id("ext-comp-1104")))
		             //.release()
		             .build()
		             .perform();
				      
				    
				    //System.out.println("zaak is in prullenmand geplaatst_OK");
	
				
				    
				    
				    
	

	
	
}
}						
						








