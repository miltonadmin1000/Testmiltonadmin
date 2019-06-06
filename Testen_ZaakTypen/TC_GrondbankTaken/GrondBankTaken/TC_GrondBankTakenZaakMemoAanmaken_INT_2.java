package GrondBankTaken;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * Testcase: Grondbanktaken
 
 Feature: zaak memo aanmaken
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 
  Scenario: memo aanmaken in testzaak
   Given: gebruiker opent zaak in tabblad 'mijn zaken' met waarde 'test' in kolom 'betreft'
   When: gebruiker klikt op tabblad 'memo' rechts bovenin zaak
   Then: tabblad voor invoeren memo opent
   When: gebruiker klikt op knop 'toevoegen'
   Then: pop-up voor indienen memo opent
   When: gebruiker vult in veld 'Onderwerp' de tekst 'TSTOnderwerp' in
   And: gebruiker vult in veld onderaan pop-up de tekst 'TSTArea' in
   And: gebruikt klikt op knop 'OK'
   Then: pop-up sluit zich
   And: in veld onder tabbladen bevindt zich een regel met zojuist gemaakte memo
   And: in bovenste regel van het memo staat achteraan het onderwerp 'TSTOnderwerp'
   And: in onderste regel van het memo staat de tekst 'TSTArea'
 */



import org.openqa.selenium.Keys;
import kadaver.TC_Feature_ZaakAanmakenKadaver_INT;

/*Testcase: Grondbanktaken
 
 Feature: zaak memo aanmaken
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 
  Scenario: memo aanmaken in testzaak
   Given: gebruiker opent zaak in tabblad 'mijn zaken' met waarde 'test' in kolom 'betreft'
   When: gebruiker klikt op tabblad 'memo' rechts bovenin zaak
   Then: tabblad voor invoeren memo opent
   When: gebruiker klikt op knop 'toevoegen'
   Then: pop-up voor indienen memo opent
   When: gebruiker vult in veld 'Onderwerp' de tekst 'TSTOnderwerp' in
   And: gebruiker vult in veld onderaan pop-up de tekst 'TSTArea' in
   And: gebruikt klikt op knop 'OK'
   Then: pop-up sluit zich
   And: in veld onder tabbladen bevindt zich een regel met zojuist gemaakte memo
   And: in bovenste regel van het memo staat achteraan het onderwerp 'TSTOnderwerp'
   And: in onderste regel van het memo staat de tekst 'TSTArea'


	 */

public class TC_GrondBankTakenZaakMemoAanmaken_INT_2  {
	
	
	  
	  public static void main(String[] args) { {
	
		  
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

	  
	  //gebruiker drukt op de knop nieuwe zaak starten
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div[1]/ul/li[4]/a[2]/em/span/span")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	  System.out.println("icoontje_voor_nieuwe_zaak_starten_werkt_OK");
		 
	
	  
	//gebruiker klikt op '+' achter Grondbanktaken onder kopje Wijkbeheer
	  //registratieformulier 'registratie_dms_intern' wordt geopend
	  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Onderhouden'])[1]/following::img[1]")).click();
	  System.out.println("formulier registratie is goed geladen");
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
	  System.out.println("Het formulier registratie dms is goed geladen_OK");
	  
	  
	  
	  
	  
	  //----------------------------
	  
	  //When: gebruiker selecteert bij 'gericht aan' de optie Gemeente Amstelveen(default)
	  //And: gebruiker vult het veld 'betreft' met 'test'	 
	  	driver.findElement(By.xpath("//*[@id=\"ext-comp-1148\"]")).sendKeys("test");
	  
	  
	
	 //Then: een drop-down menu verschijnt met opties	  
	  	driver.findElement(By.xpath("//*[@id=\"ext-comp-1162\"]")).sendKeys("grond");
	  	System.out.println("De value 'grond' is ingevoerd_OK");
	 
	  	
	  	
	  	
	  	
	  	
	 //When: gebruiker selecteert 'Behandelaar Grondbanktaken'
	  	driver.findElement(By.xpath(" /html/body/div[25]/div/div[12]")).click();
	  	System.out.println("Behandelaar Grondbanktaken' is gelesecteerd als waarde_OK");
	  /////////////////////////////////////////////////////////////////////////////////////////////
	 
	  	 //And: gebruiker selecteert bij 'Kies hier de gemeente' de optie Aalsmeer
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Locatie'])[1]/preceding::img[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Kies hier de gemeente :'])[1]/following::input[1]")).sendKeys("Amstelveen");
	     System.out.println("Aalsmeer is gekozen als gemeente_OK");
		
	
	 
	     try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		 
		  //And: gebruiker drukt op knop volgende
		//And: gebruiker drukt op knop volgende
			 driver.findElement(By.xpath("//button[text()='volgende']")).click();
			 System.out.println("knopje 'volgende' werkt prima_OK");
			 
			 
	  	  
	  //
			   try {
					Thread.sleep(4000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		//Then: het volgende tabblad van het registratieformulier wordt getoond
		// When: gebruiker klikt op 'controleer' onderin het scherm
			  //And: gebruiker drukt op knop volgende
			 driver.findElement(By.xpath("//button[text()='controleer']")).click();
			 
			 System.out.println("knopje 'controleer' werkt prima_OK");
			 
			 
			 
	    
			  
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			 
				//then:gebruiker klikt op knopje_bevestige
				
				driver.findElement(By.xpath("//button[text()='bevestigen']")).click();
				System.out.println("knopje bevestigen_OK");
				
				 //  When: gebruiker klikt op 'OK'
				   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
				   driver.findElement(By.xpath("//button[text()='OK']")).click();
				    System.out.println("'OK' knopje' bij afsluiten_OK ");
					 	
				    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e3) {
						
						e3.printStackTrace();
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
		  
		  
		  
		  
		  
		  
		  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='mag wijzigen'])[1]/following::input[3]")).sendKeys("test");
		  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='mag wijzigen'])[1]/following::input[3]")).sendKeys(Keys.RETURN);	  
		  System.out.println("Test_OK");
		
		  
		  try {
				Thread.sleep(4000);
			} catch (InterruptedException e4) {
				
				e4.printStackTrace();
			}
	      
		   
		   
		  //Gebruiker opent een grondbanktaak
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[2]/div")).click();
		  //driver.findElement(By.cssSelector("div.b-row-signaal-:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).click();
		  
		  		
		  System.out.println("Registratie Grondbanktaken is geopend_OK");
		  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		
		  // When: gebruiker klikt op tabblad 'memo' rechts bovenin zaak
		  //Then: tabblad voor invoeren memo opent
		  driver.findElement(By.cssSelector(".b-icoon-commentaar")).click();
		  System.out.println("Memo is geopend_OK");
		  
		  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  
		  
		  
		  
		  //When: gebruiker klikt op knop 'toevoegen'
		  //Then: pop-up voor indienen memo opent
		   driver.findElement(By.xpath("//button[text()='toevoegen']")).click();
		  driver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS) ;
			  
			  
			  
			  
			  
			  //---------
			  
		    //When: gebruiker vult in veld 'Onderwerp' de tekst 'TSTOnderwerp' in
		    driver.findElement(By.xpath("//*[@id=\"ext-comp-1873\"]")).sendKeys("TSTOnderwerp");
		    
		    System.out.println("TSTOnderwerp is ingevuld_OK");
		    
		    
		    driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		  //And: gebruiker vult in veld onderaan pop-up de tekst 'TSTArea' in
		    		    
		    driver.findElement(By.xpath("//*[@id=\"ext-gen4\"]")).click();
		    driver.findElement(By.xpath("//*[@id=\"ext-gen4\"]")).sendKeys("TSTArea");
		    
		    System.out.println("TSTArea is ingevuld_OK");
		   
	      
		     
		 //   driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
				   
			   
			   
			   //And: gebruikt klikt op knop 'OK'
			 //Then: pop-up sluit zich   
			 driver.findElement(By.xpath("//button[text()='ok']")).click();
			 
			
			//in veld onder tabbladen bevindt zich een regel met zojuist gemaakte memo
			 System.out.println("memo is ingevuld en opgeslagen_OK");
		   
			  if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/div[1]/div")) != null){
				  
				  System.out.println("'in veld onder tabbladen bevindt zich een regel met zojuist gemaakte memo'_Test is succes");
				  }else{
				  System.out.println("'in veld onder tabbladen bevindt zich een regel met zojuist gemaakte memo'_Test FAILED");
				  }
			
			
					  }
		  
	  }}
			
			
			
			
			
	
		  