package GrondBankTaken;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import kadaver.TC_Feature_ZaakAanmakenKadaver_INT;

/*
//Feature: tenant
bacckground: And: kolom 'organisatie' is ingesteld in werkvoorraad van gebruiker

 Scenario: gebruiker maakt zaak aan voor Amstelveen
     Given: gebruiker is ingelogd in de acceptatie-omgeving   
	 When: gebruiker klikt op tab 'een nieuwe zaak starten'
	 And: gebruiker klikt op '+' achter Grondbanktaken onder kopje Wijkbeheer
	 Then: registratieformulier 'registratie_dms_intern' wordt geopend
	 When: gebruiker selecteert bij 'gericht aan' de optie Gemeente Amstelveen
	 And: gebruiker vult het veld 'betreft' met 'test2'
	 And: gebruiker vult bij 'zoek medewerker, afdeling, overlegorgaan' met 'grond'
	 Then: een drop-down menu verschijnt met opties
	 When: gebruiker selecteert 'Behandelaar Grondbanktaken'
	 And: gebruiker selecteert bij 'Kies hier de gemeente' de optie Amstelveen
	 And: gebruiker klikt op 'volgende' onderin het scherm
	 Then: het volgende tabblad van het registratieformulier wordt getoond
	 When: gebruiker klikt op 'controleer' onderin het scherm
	 Then: pop-up van bevestiging van registratieformulier verschijnt
	 When: gebruiker klikt op 'bevestigen'
	 And: gebruiker klikt op 'OK'
	 And: gebruiker klikt op tab 'mijn zaken'
	 And: gebruiker selecteert in het drop-down menu de rol 'Behandelaar Grondbanktaken'
	 Then: alle zaken voor Behandelaar Grondbanktaken verschijnen
	 When: gebruiker kijkt bij de regel van de zaak met als 'betreft' de tekst 'test' onder de kolom 'organisatie'
	 Then: in dit veld staat de tekst 'amstelveen'
	 
	 */

public class TC_FeatureTenantGebruikerMaaktZaakAanVoorAalsMeer_INT_1 extends TC_Feature_ZaakAanmakenKadaver_INT {
	
	
	  
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

	  System.out.println("gebruiker is ingelogd");
	  
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
	  
	  //When: gebruiker selecteert bij 'gericht aan' de optie Gemeente Amstelveen(default)
	  //And: gebruiker vult het veld 'betreft' met 'test'	 
	  driver.findElement(By.xpath("//*[@id=\"ext-comp-1148\"]")).sendKeys("test");
	  System.out.println("'test' is ingevuld_OK");
	  
	
	 //Then: een drop-down menu verschijnt met opties	  
	  driver.findElement(By.xpath("//*[@id=\"ext-comp-1162\"]")).sendKeys("grond");
	System.out.println("grond is ingevuld_OK");
	 
	 //When: gebruiker selecteert 'Behandelaar Grondbanktaken'
	  driver.findElement(By.xpath(" /html/body/div[25]/div/div[12]")).click();
	  System.out.println("Behandelaar GrondBanktaken is gekozen_OK");
	  
	  
//------------------------------	
	  	  
	     //And: gebruiker drukt op knop volgende
		 driver.findElement(By.xpath("//button[text()='volgende']")).click();
		 
		 System.out.println("knopje 'volgende' werkt prima_OK");
		 
		 
		 
	    
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
		  System.out.println("mijn zaken ");
		
		  
		//And: gebruiker selecteert in het drop-down menu de rol 'Behandelaar Grondbanktaken' 
		// Then: alle zaken voor Behandelaar Grondbanktaken verschijnen
	     WebElement drpdwnBGBT= driver.findElement(By.xpath("//*[@id=\"ext-gen95\"]"));
	     JavascriptExecutor jseBGBT =  (JavascriptExecutor)driver;
	     jseBGBT.executeScript("arguments[0].click();", drpdwnBGBT );
	     driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
	     
	     
	     //---------------------------------------------------------------------------------------------------------
	     
	     
		  driver.findElement(By.name("ext-comp-1033")).sendKeys("Zaakcoördinator Grondbanktaken - amstelveen");
		  System.out.println("BehandelaarGrondbanktaken ziet alle zaken");
		  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		  
		  
		  
		  try {
			Thread.sleep(4000);
		} catch (InterruptedException e4) {
			
			e4.printStackTrace();
		}
		  
		  
		//When: gebruiker kijkt bij de regel van de zaak met als 'betreft' de tekst 'test2' onder de kolom 'organisatie'
		// Then: in dit veld staat de tekst 'amstelveen'
		  
		  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='mag wijzigen'])[1]/following::input[3]")).sendKeys("test");
		  driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='mag wijzigen'])[1]/following::input[3]")).sendKeys(Keys.RETURN);	  
		  System.out.println("Test_OK");
		
		  
		  try {
				Thread.sleep(4000);
			} catch (InterruptedException e4) {
				
				e4.printStackTrace();
			}
		  
		  driver.quit();
		  
	  }}
	  }


