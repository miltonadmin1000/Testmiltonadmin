package kadaver;
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

public class TC_Feature_ZaakAanmakenKadaver_INT {

		  
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
		  driver.findElement(By.xpath("//span[@class='x-tab-strip-text b-icoon-toevoegen']")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		  System.out.println("icoontje_voor_nieuwe_zaak_starten_werkt_OK");
			 
		
		  
		  //gebruiker drukt op de knop nieuwe zaak registreren bij onderwerp Kadavers
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[6]/div[2]/div[2]/table/tbody/tr/td[8]/div/img")).click();
		  System.out.println("formulier lp_lp00000126 is goed geladen");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  System.out.println("Het formulier _registratie_lp00000126_is_geladen");
		   
		 
		  
		  //Hoe is de melding ontvangen?_TELEFOON_done
		  System.out.println("Medlding is per telefoon ontvangen");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  
		  
		  
		  	  
		  
		  // Afzender_PERSOON
		    
		  driver.findElement(By.xpath("//*[@id=\"ext-gen714\"]")).click();
		  System.out.println("Gebruiker heeft als afzender persoon gekozen ");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  

		  // Afzender_PERSOON
		    
		  driver.findElement(By.xpath("//*[@id=\"ext-gen716\"]")).click();
		  System.out.println("Gebruiker heeft als afzender persoon gekozen ");
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  
		    //Naam afzender_VEEN		
		  
		    driver.findElement(By.xpath("//*[@id=\"ext-comp-1151\"]")).sendKeys("Veen");//*[@id="ext-comp-1168"] //*[@id="ext-comp-1151"]
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		     driver.findElement(By.xpath("//*[@id=\"ext-comp-1151\"]")).sendKeys(Keys.RETURN);
		    
		    
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		    
		    driver.findElement(By.xpath("/html/body/div[26]/div/div[6]/span")).click(); 
		    System.out.println("Gebruiker kies 'Van Veen' als klant");
		    
		  //*[@id="ext-comp-1151"]
		  //*[@id="ext-comp-1151"]
		  
		  
		 	    
		    //Gebuiker klikt voor dood dier vis_rdbtn
		    WebElement vis = driver.findElement(By.id("ext-gen848"));
		     JavascriptExecutor jsevis = (JavascriptExecutor)driver;jsevis.executeScript("arguments[0].click();", vis );
		     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		     System.out.println("Gebruiker kiest  Vis als dood dier");
	    
		     
	       // gebruiker kiest bij 'waar ligt het dode dier?'de optie In het groen
  		       WebElement  DoodDier = driver.findElement(By.id("ext-gen874"));
		      JavascriptExecutor jseDoodDier = (JavascriptExecutor)driver;
		      jseDoodDier.executeScript("arguments[0].click();", DoodDier  );
		      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		      System.out.println("Kadaver vis ligt in het groen");
		
		   //gebruiker vult bij 'kunt u de plek waar het dode dier ligt toelichten?' test in
		     driver.findElement(By.xpath("//*[@id=\"ext-comp-1241\"]")).sendKeys("Test");
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		      System.out.println("Test is ingevuld als text");

			 
			//gebruiker selecteert het boxje 'adres overnemen van afzender'
			 driver.findElement(By.id("ext-comp-1484")).click();
		      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		      System.out.println("Loactie is overgenomen van afzender");
		      

			 
			//  locatieblok wordt gevuld met adresgegevens van A. Veen
			//	When: gebruiker kiest bij 'is er sprake van direct gevaar?' de optie Nee
			//	And: gebruiker kiest bij 'wil de inwoner digitaal berichten ontvangen en versturen?' de optie Niet van toepassing
		      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		      driver.findElement(By.xpath("//*[@id=\"ext-gen571\"]")).sendKeys(Keys.RETURN);
		      System.out.println("Loactie is overgenomen van afzender, er is geen sprake van gevaar en digitaal bericht is niet van toepassing");
		  
			   //And: de gebruiker klikt op de button Controleer
			   //Then: pop-up verschijnt met overzicht van de ingevulde gegevens
			   //When: gebruiker klikt op Bevestigen
		      driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		  	   driver.findElement(By.xpath(" //*[@id=\"ext-gen1271\"]")).sendKeys(Keys.RETURN);
		   
		  	   //And: gebruiker klikt op Ok
			   driver.findElement(By.xpath("//*[@id=\"ext-gen1313\"]")).click();
		  	
		  	   ////////////////////////PART TWO: Hier ga je als coordinator het dossier opzoeken.//////////////////////////////////////////////////////////////////////////////////
			   
			   
			  // Then: gebruiker ziet zaak met hudige datum in overzicht mijn zaken van rol Zaakcoordinator Kadavers onder kopje Beoordelen
		  
			   driver.findElement(By.xpath(" /html/body/div[1]/div/div/div[3]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span")).click();
			    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
			    driver.findElement(By.xpath(" //*[@id=\"ext-gen95\"]")).click();
			    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
	   
	  
			    
			  //gebruiker kiest coordinator  
			     WebElement drpdwnCoordinator= driver.findElement(By.xpath("/html/body/div[30]/div/div[15]"));
			     JavascriptExecutor jsedrpdwnCoordinator = (JavascriptExecutor)driver;
			     jsedrpdwnCoordinator.executeScript("arguments[0].click();", drpdwnCoordinator );
			     driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
	  			    		     		     		
			     
				 //Datum field selecteren
				driver.findElement(By.name("ext-comp-1050"));	
			    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
			     Calendar calendar = Calendar.getInstance();
			     Date today = calendar.getTime();
				  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
			     calendar.add(Calendar.DAY_OF_YEAR, -1);
			     Date tomorrow = calendar.getTime();
			         
			     DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			     String todayAsString = dateFormat.format(today);
			 	 driver.findElement(By.name("ext-comp-1050")).sendKeys((todayAsString));
			 		 	
			 	System.out.println("Einde test");
			 			 		
			 	driver.manage().timeouts().implicitlyWait(300000,TimeUnit.SECONDS) ;
			     
			 	//driver.close();
			 	
			    	}
			     }

			        ///////////////////////////////////////////////////////////////////////////END///////////////////////////////////////////////////////////////////////////
//VERWACHTE TESTRESULTAAT:	  
//1.OUTPUT: PDF MET REGISTRATIE
//2.LIJST VOOR COORDINATOR VAN DEZE REGISTRATIES VOOR KADAVER VOOR VANDAAG
	  
	  
	  
	  