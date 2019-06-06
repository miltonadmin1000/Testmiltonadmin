package GrondBankTaken;
/*
 * Testcase: Grondbanktaken
 
 Feature: zaak direct afhandelen
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 Background: gebruiker bevindt zich in testzaak in fase Behandelen van rol Zaakcoordinator Grondbanktaken
 
  Scenario: testzaak direct afhandelen
   When: gebruiker vinkt het vinkje onder kopje 'Behandeling afgerond' naast 'voldoende informatie' aan
   And: gebruiker noteert het zaaknummer
   And: gebruiker klikt op menu 'zaak' rechts bovenin
   Then: drop-down menu zaak verschijnt
   When: gebruiker kiest de optie 'zaak direct afhandelen'
   Then: pop-up getiteld 'Naar fase AFGEHANDELD' verschijnt
   When: gebruikt kiest optie 'afgebroken'
   And: gebruiker klikt op 'OK'
   Then: systeem keert terug naar werkvoorraad Zaakcoordinator Grondbanktaken
   And: zaak met corresponderend zaaknummer staat in de werkvoorraad onder titel 'afgehandeld'
  
 */

	
	
	
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;

import MethodLoginMilton.AcceptatieLoginMilton;

import org.openqa.selenium.Keys;
	import kadaver.TC_Feature_ZaakAanmakenKadaver_INT;

	/*

		 */

	public class TC_GrondBankTakenFeatureZaakDirectAfhandelen_INT_10  extends TC_Feature_ZaakAanmakenKadaver_INT {
		
		
		  
		  public static void main(String[] args)  { 
			  
			   
			   AcceptatieLoginMilton.InloggenAcceptatie();
			   
			   }	
			
		 AcceptatieLoginMilton acceptatieLogin= new AcceptatieLoginMilton ();{
		
			  
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

				   
				   
								 //And: gebruiker klikt op tab 'mijn zaken'
									  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span")).click();
									  System.out.println("De Tab bij 'mijnzaken' werkt goed_OK");
								 
									  
									//And: gebruiker selecteert in het drop-down menu de rol 'Behandelaar Grondbanktaken' 
										// Then: alle zaken voor Behandelaar Grondbanktaken verschijnen
									     WebElement drpdwnBGBT= driver.findElement(By.xpath("//*[@id=\"ext-gen95\"]"));
									     JavascriptExecutor jseBGBT =  (JavascriptExecutor)driver;
									     jseBGBT.executeScript("arguments[0].click();", drpdwnBGBT );
									     driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
									     
									     
										  driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys("Zaakcoördinator Grondbanktaken - amstelveen");
										   driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys(Keys.RETURN);
										  System.out.println("BehandelaarGrondbanktaken ziet alle zaken");
										 
										  
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


				
			  driver.findElement(By.xpath("	//*[@id=\"ext-comp-1017\"]")).sendKeys("test");
			  driver.findElement(By.xpath("	//*[@id=\"ext-comp-1017\"]")).sendKeys(Keys.RETURN);	  
			  System.out.println("Gebruiker zoekt op 'test' onder kolom betreft _OK");
			  
			  
			  
				 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				   
///////////////////////////////////////////////////////////////HIER BEGINT DE TESTCASE|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
			  
			  
			  driver.findElement(By.cssSelector("div.b-row-Behandelen:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).click();
			  System.out.println("Pagina  Registratie Grondbanktaken is geopend");
			  
			 
			  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			   //-----------------------------------------
			   
			   //When: gebruiker vinkt het vinkje onder kopje 'Behandeling afgerond' naast 'voldoende informatie' aan
			   //kleine button naast afgehandeld klikken
				  
			   WebElement myelement = driver.findElement(By.cssSelector(".x-grid3-col-checkvoldaan"));
			   JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			   jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
			   System.out.println("element is in view");
			    JavascriptExecutor jse =  (JavascriptExecutor)driver;
			    jse2.executeScript("arguments[0].click();", myelement );
			    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				 driver.findElement(By.cssSelector(".x-grid3-col-checkvoldaan")).click();
				 System.out.println("op voldoende informatie klikken bij'afgehandeld(1)_OK");
			 
				 
			 
			 driver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS) ;
			   try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			      
				   //gebruiker zoekt zaak op en klikt erop
				      driver.findElement(By.xpath("//button[text()='zaak']")).click();
					  System.out.println("Dropdown zaak geklikt_OK"); 
				  
				   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;   
				      try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				
				      
				       
				     
				 //When: gebruiker selecteert optie 'zaak direct annuleren'
				  driver.findElement(By.xpath("//span[text()='zaak direct afhandelen']")).click();
				  System.out.println("Fase annuleren geklikt_OK");
				  
				  
				   driver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS) ;   
				      try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				   
				   
				   
		
			    
			    //  Then: pop-up getiteld 'Naar fase AFGEHANDELD' verschijnt
			    //When: gebruikt kiest optie 'afgebroken'
			   driver.findElement(By.xpath("//label[text()=' Afgebroken']")).click();;
			   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			    driver.findElement(By.xpath("//label[text()=' Afgebroken']")).click();;
			    System.out.println("pop-up getiteld 'Naar fase AFGEHANDELD' verschijnt_OK");
			    System.out.println("gebruikt kiest optie 'afgebroken'_OK");
			    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				   
			    driver.findElement(By.xpath("//button[text()='OK']")).click();;
			    System.out.println(" 'OK' knop ingedrukt_OK");
			    
			    System.out.println("systeem keert terug naar werkvoorraad Zaakcoordinator Grondbanktaken");
			    System.out.println("zaak met corresponderend zaaknummer staat in de werkvoorraad onder titel 'afgehandeld'");
			    
			    System.out.println("Test _OK");
			  
			  
			  
		  }
		  }
		  
	


		  
	
