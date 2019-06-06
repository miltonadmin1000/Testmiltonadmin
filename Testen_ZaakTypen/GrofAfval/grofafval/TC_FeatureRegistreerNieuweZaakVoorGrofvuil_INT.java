/*

Feature: registreer een nieuwe zaak voor grofvuil 

 Scenario: Gebruiker registreert nieuwe zaak
  Given: Open firefox browser
  And: Start applicatie met https://zaken.acceptatie.amstelveen.nl/   
  When: Gebruiker vult geldig Gebruikersnaam en Wachtwoord in  
  Then: Gebruiker zou met succes moeten inloggen
  When: Gebruiker klikt op tab een nieuwe zaak starten
  And: Gebruiker klikt op knopje nieuwe zaak registreren bij onderwerp Centrale beheertaken
  And: Gebruiker kiest  bij "<Meldt u dit voor Aalsmeer?>"
  And: Gebruiker selecteert "<Hoe is de melding ontvangen?>" 
  And: Gebruiker kiest "<afzender>"
  And: Gebruiker vult in "<naam>" + ENTER
  And: Gebruiker vinkt aan 'adres overnemem van gebruiker'
  And: gebruiker kiest "<soort afval>"
  Then: keuzeopties gerelateerd aan soort melding worden getoond 
  When: "<huishoudelijkmelding>" is gekozen  
  And: gebruiker kiest "<keuze ophaaldatum>"
  
  And: gebruker kiest omvang in "<kubieke meter>"
  And: gebruiker selecteert "<Heeft u Amstelveenpas?>"
  And: gebruiker klikt controleer knopje
  Then: pdf brief verschijnt als pop-up
 

*/




package grofafval;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC_FeatureRegistreerNieuweZaakVoorGrofvuil_INT {

		  
	  public static void main(String[] args) {
		  
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
		  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("3z2vQ900");
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
		  driver.findElement(By.xpath("//span[@class='x-tab-strip-text b-icoon-toevoegen']")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		  System.out.println("icoontje_voor_nieuwe_zaak_starten_werkt_OK");
			 
		
		  
		  //gebruiker drukt op de knop nieuwe zaak registreren bij Centrale beheertaken
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[3]/div[2]/div/table/tbody/tr/td[8]/div/img")).click();
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  System.out.println("Het formulier _registratie_b0521_is_geladen");
		  
		  		  
		  //Melding is NIET voor Aalsmeer
		    
		  driver.findElement(By.name("aalsmeermelding")).sendKeys("nee");//done
		  driver.findElement(By.name("aalsmeermelding")).sendKeys(Keys.RETURN);
		  
		  
		  //Hoe is de melding ontvangen?_TELEFOON_done
		  System.out.println("Medlding is per telefoon ontvangen");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  
		  // Afzender_PERSOON
		    
		  driver.findElement(By.xpath("//*[@id=\"ext-gen716\"]")).click();
		  System.out.println("Gebruiker heeft als afzender persoon gekozen ");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  
		    //Naam afzender_VEEN		
		  
		    driver.findElement(By.xpath("//*[@id=\"ext-comp-1168\"]")).sendKeys("Veen");//*[@id="ext-comp-1168"] 
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		     driver.findElement(By.xpath("//*[@id=\"ext-comp-1168\"]")).sendKeys(Keys.RETURN);
		    
		    
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		    
		    driver.findElement(By.xpath("/html/body/div[26]/div/div[6]/span")).click(); 
		    System.out.println("Gebruiker kies 'Van Veen' als klant");
		  
				     
		  		     
			//gebruiker selecteert het boxje 'adres overnemen van afzender'_done
			 driver.findElement(By.xpath("//*[@id=\"ext-comp-1493\"]")).click();
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     System.out.println("Locatie is overgenomen van afzender");
		     
		      
		     	// gebruiker kiest bij soort afval voor Huishoudelijk Brandbaar_done
			    WebElement HB = driver.findElement(By.id("ext-gen955"));
			     JavascriptExecutor jsHB = (JavascriptExecutor)driver;
			     jsHB.executeScript("arguments[0].click();", HB );
			     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			     System.out.println("Gebruiker kiestHuishoudelijk brandbaar");
		  
			     // gebruiker kiest bij Huishoudelijk Brandbaar_voor papier en karton_done
				  WebElement HBPK = driver.findElement(By.id("ext-gen975"));
				  JavascriptExecutor jsHBPK = (JavascriptExecutor)driver;
				  jsHB.executeScript("arguments[0].click();", HBPK );
				   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				   System.out.println("papier en karton is gekozen als huishoudelijk brandbaar afval");
				     
					 //Datum selecteren in dropdownlist_done
				
				   driver.findElement(By.xpath("//*[@id=\"ext-gen1059\"]")).click();
				   driver.findElement(By.xpath("/html/body/div[30]/div/div[3]")).click();
				   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
				   
	          //  And: gebruker kiest omvang in 1 voor "<kubieke meter>"				  
				   driver.findElement(By.id("ext-gen1065")).click();
				   driver.findElement(By.xpath("/html/body/div[32]/div/div[1]")).click();  
				   driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
				   
				   // gebruiker selecteert "<Heeft u Amstelveenpas?>_NEE...dit is de default value
				   //And: de gebruiker klikt op de button Controleer
				   //Then: pop-up verschijnt met overzicht van de ingevulde gegevens
				   //When: gebruiker klikt op Bevestigen
			      driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
			  	  driver.findElement(By.xpath("//*[@id=\"ext-gen571\"]")).sendKeys(Keys.RETURN);
			  	  driver.findElement(By.xpath("//*[@id=\"ext-gen1417\"]")).click();				
				  driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS) ;
				
				  //er verschijn tweer een pop up met een text voor dank voor uw aanvraag etc...
				 //gebruiker klik op OK knop
				   driver.findElement(By.xpath("//*[@id=\"ext-gen1457\"]")).click();	
				   
				   
				   
	/////////////////////////////////////////////////////////////////////////PART TWO///////////////////////////////////////////
			
				   
				   // Then: gebruiker ziet zaak met hudige datum in overzicht mijn zaken van rol Zaakcoordinator Kadavers onder kopje Beoordelen
					  
				   driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span")).click();
				    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
				    driver.findElement(By.xpath("//*[@id=\"ext-gen95\"]")).click();
				    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  
				
				    
				  //gebruiker kiest coordinator  
				     WebElement drpdwnBGrfV= driver.findElement(By.xpath("/html/body/div[32]/div/div[1]"));
				     JavascriptExecutor jsedrpdwnBGrfV = (JavascriptExecutor)driver;
				     jsedrpdwnBGrfV.executeScript("arguments[0].click();", drpdwnBGrfV );
				     driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		  			    		     		     		
				          
					//Datum field selecteren
					driver.findElement(By.name("ext-comp-1050"));	
				    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
				     Calendar calendar = Calendar.getInstance();
				     Date today = calendar.getTime();
					  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
				     calendar.add(Calendar.DAY_OF_YEAR, 0);
				     Date tomorrow = calendar.getTime();
				         
				     DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				     String todayAsString = dateFormat.format(today);
				 	 driver.findElement(By.name("ext-comp-1050")).sendKeys((todayAsString));
				 		 	
				 	System.out.println("Einde test");
				 			 		
				 	driver.manage().timeouts().implicitlyWait(300000,TimeUnit.SECONDS) ;
				     
				 	//driver.close();
				 	
				    	}




				        ///////////////////////////////////////////////////////////////////////////END///////////////////////////////////////////////////////////////////////////
	//VERWACHTE TESTRESULTAAT:	  
	//1.OUTPUT: PDF MET REGISTRATIE
	//2.LIJST VOOR COORDINATOR VAN DEZE REGISTRATIES VOOR KADAVER VOOR VANDAAG
		  
		  
		  
		  
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
				   
	  }

