
/* Testcase: Grondbanktaken
 
 Feature: zaak hervatten
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 Background: gebruiker bevindt zich in 'geannuleerde zaken' scherm van rol Zaakcoordinator Grondbanktaken na annuleren zaak
 
  Scenario: geannuleerde testzaak hervatten
   When: gebruiker opent zojuist geannuleerde zaak met corresponderend zaaknummer
   

And: gebruiker klikt op knop 'zaak' rechtsboven
   Then: drop-down menu verschijnt met opties voor zaak
   When: gebruiker selecteert optie 'zaak hervatten'
   Then: pop-up verschijnt getiteld 'Zaak hervatten'
   When: gebruikt vult in het veld 'Geef aan waarom u de zaak wilt hervatten' de tekst 'TESTHervatten' in
   And: gebruiker klikt op 'OK'
   And: gebruiker sluit zaak
   Then: gebruiker komt terug in overzicht geannuleerde zaken terecht
   When: gebruiker klikt op knop 'actueel'
   Then: testzaak corresponderend aan genoteerd zaaknummer staat in lijst met actuele zaken onder het kopje 'Behandelen'
	    * 
	 */

	package hervatten;
	
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class TC_GrondBankTakenFeatureZaakHervatten_INT_8 {

		 public static void main(String[] args)throws Exception { {
				
			  
			 //Java kiest Firefox alls webdriver		  
			  System.setProperty("webdriver.gecko.driver","G:\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			  
			  //Selenium driver kiest voor firefox browser
			  WebDriver driver = new FirefoxDriver();
			  driver.manage().window().maximize();
			  
			  
			  //Acceptatie omgeving wordt geopend
			  driver.get("https://zaken.acceptatie.amstelveen.nl/login");
			  	  
			  
			  //Inloggen in acceptatie omgeving
			  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("G5888");
			  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("3z2vQ900");
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
				  driver.findElement(By.xpath("/html/body/div[16]/div/div[14]")).click();
				  System.out.println("Zaakcoördinator Grondbanktaken - amstelveen is gekozen_OK");
				  
							  
				//And: gebruiker vult het veld 'betreft' met 'test'	 
				 driver.findElement(By.name("ext-comp-1017")).sendKeys("test");
				  System.out.println("test is ingevuld_OK");
				  
				  
			
				  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS) ;
				  try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				  
				  
				  
				  //-------------------------
				 //Zaakcoördinator Grondbanktaken - amstelveen, kiest zaak
				  
				  driver.findElement(By.cssSelector("div.x-grid3-row:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).click();
				  System.out.println("Registratie Grondbanktaken is geopend_OK");
				  
				  
				  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				  
				 // When: gebruiker klikt op knop 'zaak' rechtsboven 
				  //Then: drop-down menu verschijnt met opties voor zaak
				   
				 driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em" )).click();
				   
				   System.out.println("dropdown zaak geklikt");
				   
				   	
				   
				   
				  
				  //kiezen annuleren
				  driver.findElement(By.xpath("//*[@id=\"ext-comp-1130\"]")).click();	
				  System.out.println("zaak annuleren is geklikt");
				  
				  driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   
				  driver.findElement(By.className("ext-mb-textarea")).sendKeys("TESTAnnuleren");
				  System.out.println("textvlak ingevuld met TESTAnnuleren");
				
				  //And: gebruiker klikt op 'OK'
				   driver.findElement(By.cssSelector(".x-panel-fbar .x-toolbar-cell:nth-of-type(1) [type]")).click();
				   
				     
				    System.out.println("OK button werkt _OK");
				     System.out.println("systeem gaat terug naar overzicht werkvoorraad Behandelaar Grondbanktaken_OK");
				     
				     driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     
					   
					   
						//And: gebruiker selecteert in het drop-down menu de rol 'Behandelaar Grondbanktaken' 
						// Then: alle zaken voor Behandelaar Grondbanktaken verschijnen
					      WebElement drpdwnCGBT= driver.findElement(By.xpath("//*[@id=\"ext-gen95\"]"));
					      JavascriptExecutor jsedrpdwnCGBT =  (JavascriptExecutor)driver;
					      jseBGBT.executeScript("arguments[0].click();", drpdwnCGBT );
					      driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
						  driver.findElement(By.xpath("/html/body/div[16]/div/div[14]")).click();
						  System.out.println("ZaakCoordinatorGrondbanktaken ziet alle zaken_OK");
		 	
						  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
						   try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		 				   						 
						 // klik op geannuleerd
						  // And: gebruiker klikt op knop 'geannuleerd'
	   					   //Then: testzaak corresponderend aan genoteerd zaaknummer verschijnt in lijst met geannuleerde zaken
						   
						  driver.findElement(By.xpath("//*[@id=\"ext-gen102\"]")).click(); //*[@id="ext-gen102"]
						  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
						  try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			 				  
						  //geannuleerde zaak kiezen
						  driver.findElement(By.cssSelector("div.x-grid3-row:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).click();
						 
						  System.out.println("geannuleerde zaak is gekozen");
						  
						  //------------------------------
						  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
						   try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
					
							e.printStackTrace();
						}
						  
						   //---------------------
						  // When: gebruiker klikt op knop 'zaak' rechtsboven 
					  //Then: drop-down menu verschijnt met opties voor zaak
					  driver.findElement(By.cssSelector("#ext-gen1706")).click();
					  System.out.println("dropdown zaak geklikt");
					  
					  
					  
					  

					  driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS) ;
					  try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					  
					
					  
					
					  driver.findElement(By.cssSelector(".x-menu-list .x-menu-list-item:nth-of-type(6) .x-menu-item-text")).click();
					  System.out.println("zaak hervatten is geklikt");
				
					  

					  
					driver.findElement(By.cssSelector(".ext-mb-textarea")).sendKeys("TESTHervatten");
					  System.out.println("textvlak ingevuld met TESTHervatten!!!");
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					  //OK knop geklikt
					  driver.findElement(By.xpath("/html/body/div[59]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")).click();
					  System.out.println("zaak is hervat");
			
					  
					  
					//  And: gebruiker sluit zaak
					//   Then: gebruiker komt terug in overzicht geannuleerde zaken terecht
					  driver.findElement(By.cssSelector("#ext-gen1704")).click();//*[@id="ext-gen555"]
					  System.out.println("zaak afgesloten_ok");
					
					
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					  
					  
					  
					  
					//   When: gebruiker klikt op knop 'actueel'
					  driver.findElement(By.cssSelector(".x-panel-tbar-noborder .x-toolbar-left .x-toolbar-cell:nth-of-type(3) [type]")).click();
					  System.out.println("knop actuel ingedrukt_OK");
					  
					  //#ext-gen557
					  
					  
					//   Then: testzaak corresponderend aan genoteerd zaaknummer staat in lijst met actuele zaken onder het kopje 'Behandelen'
					  
					  
					  
					  
					  
		 }
		
		 }
		
		 }
		}

	
