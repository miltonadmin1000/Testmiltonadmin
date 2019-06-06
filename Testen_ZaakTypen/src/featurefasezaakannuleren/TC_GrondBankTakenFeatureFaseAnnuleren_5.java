/*Testcase: Grondbanktaken

 Feature: fase annuleren
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 Background: gebruiker bevindt zich in testzaak na doorfaseren zaak
  
  Scenario: fase Afhandelen annuleren
   When: gebruiker klikt op knop 'zaak' rechtsboven 
   Then: drop-down menu verschijnt met opties voor zaak
   When: gebruiker selecteert optie 'fase annuleren'
   Then: pop-up verschijnt met de boodschap 'Geef aan waarom u terug wilt naar de fase Behandelen'
   When: gebruiker vult in 'test' in textbox
   And: gebruikt klikt op 'OK'
   Then: groen vinkje voor 'Behandelen' is weg
   And: mogelijkheid om onder kopje 'Behandeling afgerond (1)' aan te vinken of er 'voldoende informatie' is verschijnt
 * * 
 */



package featurefasezaakannuleren;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import MethodLoginMilton.AcceptatieLoginMilton;

public class TC_GrondBankTakenFeatureFaseAnnuleren_5 {
	
	{
		  
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
	  	System.out.println("Icoontje_voor_nieuwe_zaak_starten_werkt_OK");
		 
	  
	  //gebruiker klikt op '+' achter Grondbanktaken onder kopje Wijkbeheer
	  //registratieformulier 'registratie_dms_intern' wordt geopend
	  	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Onderhouden'])[1]/following::img[1]")).click();
	  	System.out.println("knopje voor een nieuwe zaak anmaken werkt_OK");
	  	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
	  	System.out.println("Formulier Z19-000664_registratie_dms_intern is goed geladen");
	  
	  //When: gebruiker selecteert bij 'gericht aan' de optie Gemeente Amstelveen(default)
	  //And: gebruiker vult het veld 'betreft' met 'test'	 
	  	driver.findElement(By.xpath("//*[@id=\"ext-comp-1148\"]")).sendKeys("test");
	  	 System.out.println("'test' is ingevuld als zoekterm _OK");
	  	
	  
	  
	
	 //Then: een drop-down menu verschijnt met opties	  
	  	driver.findElement(By.xpath("//*[@id=\"ext-comp-1162\"]")).sendKeys("grond");
	  	System.out.println("'grond' is ingevuld als zoekterm_OK");
	 
	 //When: gebruiker selecteert 'Behandelaar Grondbanktaken'
	  	driver.findElement(By.xpath(" /html/body/div[25]/div/div[12]")).click();
	  	System.out.println("Behandelaar Grondbaktaken' is gelesecteerd in dropdownlist_OK");
	  
	 	  

				  
			
		   	 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;

		     try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
		  	
		  	
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
		  
		  	
		  	
		  	 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			  
			//Gebruiker opent een grondbanktaak
	
		 driver.findElement(By.cssSelector(("div.b-row-Behandelen:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)"))).click();
		
		 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
	
	
	
	 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
	   try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	
	   
	  //kleine button naast afgehandeld klikken
	  
	   WebElement myelement = driver.findElement(By.cssSelector(".b-row-invalid > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(7) > div:nth-child(1)"));
	   JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	   jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
	   System.out.println("element is in view");
	    JavascriptExecutor jse =  (JavascriptExecutor)driver;
	    jse2.executeScript("arguments[0].click();", myelement );
	    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		 driver.findElement(By.cssSelector(".b-row-invalid > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(7) > div:nth-child(1)")).click();
		 System.out.println("op voldoende informatie klikken bij'afgehandeld(1)_OK");
	 
	 
	 
	 driver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS) ;
	   try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	   
	  
	  
	 
	  
	  //klikken op button volgende fase 
	   
	   driver.findElement(By.xpath("//button[text()='volgende fase']")).click();
	   System.out.println("Gebruiker klikt op knop naar 'Volgende fase' _OK");
	  
	   driver.manage().timeouts().implicitlyWait(4000,TimeUnit.SECONDS) ;   
	      try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    
	      
	      //Gebruiker klikt op knop 'OK' bij vraag 'naar fase afgehandeld?'
			 driver.findElement(By.xpath("//button[text()='Ja']")).click();
		  System.out.println("OK bttn_OK");
	      
	
	   
	   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;   
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		   
	      
	      //-------------------------------------  
	
	      
		   //gebruiker zoekt zaak op en klikt erop
	      driver.findElement(By.xpath("//button[text()='zaak']")).click();
		  System.out.println("Dropdown zaak geklikt_OK"); 
	  
	   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;   
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
	      
	      
	     
	 //When: gebruiker selecteert optie 'fase annuleren'
	  driver.findElement(By.xpath("//span[text()='fase annuleren']")).click();
	  System.out.println("Fase annuleren geklikt_OK");
	  
	  
	   driver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS) ;   
	      try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	  
	  //Then: pop-up verschijnt met de boodschap 'Geef aan waarom u terug wilt naar de fase Behandelen'
	 //When: gebruiker vult in 'test' in textbox
	      
	  driver.findElement(By.xpath("//textarea[@class='ext-mb-textarea']")).click();    
	  driver.findElement(By.xpath("//textarea[@class='ext-mb-textarea']")).sendKeys("test");
	  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
	  System.out.println("test ingevuld_OK"); 
	  
	  try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	 
	  //And: gebruikt klikt op 'OK'
	  // Then: groen vinkje voor 'Behandelen' is weg
	 
	    driver.findElement(By.xpath("//button[text()='OK']")).click(); 
	  
	  System.out.println("groen vinkje voor 'Behandelen' is weg_OK");
	  
	  
	  // And: mogelijkheid om onder kopje 'Behandeling afgerond (1)' aan te vinken of er 'voldoende informatie' is verschijnt
	  
	  if(driver.getPageSource().contains("1. Behandeling afgerond (1)")){
		  System.out.println("'1. Behandeling afgerond (1)'_ is present_Test is succes");
		  }else{
		  System.out.println("'1. Behandeling afgerond (1)'_ is NOT present_Test failed");
		  }
	  
	
	  
	  }
}
	  
