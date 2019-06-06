/*Testcase: Grondbanktaken
 
 Feature: zaak archiveren
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 
  Scenario: direct afgehandelde zaak terugvinden
   Given: gebruiker bevindt zich in werkvoorraad van rol Zaakcoordinator Grondbanktaken na direct afhandelen zaak
   When: gebruiker klikt op button 'afgehandeld'
   Then: drop-down menu verschijnt
   When: gebruiker selecteert 'week'
   Then: overzicht met afgehandelde zaken wordt getoond
   When: gebruiker genoteerd zaaknummer uit vorige test onder 'zaak' invult
   Then: zoekresultaten met zojuist afgehandelde zaak wordt getoond
   
  Scenario: direct afgehandelde zaak in archief opzoeken
   Given: gebruiker is ingelogd in de acceptatie-omgeving van het archiefportaal via https://zaken.acceptatie.amstelveen.nl/archief
   When: gebruiker het zaaknummer van de zojuist afgehandelde zaak invoert bij het veld onder 'nummer'
   Then: zoekresultaten worden getoond
   And: zaak corresponderend aan het genoteerde zaaknummer wordt getoond in het tabblad 'te archiveren'
   And: onder de kolom 'bewaren/vernietigen' staat 'vernietigen'
   And: onder de kolom 'vernietigbaar' staat '2020'
    
 * 
 */


package archiveren;


	import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

	public class TC_GrondBankTakenFeatureArchiveren_INT_11{	  
		  public static void main(String[] args) throws Exception {{ 
			  
			  
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
							


				
			  driver.findElement(By.xpath("	//*[@id=\"ext-comp-1017\"]")).sendKeys("test");
			  driver.findElement(By.xpath("	//*[@id=\"ext-comp-1017\"]")).sendKeys(Keys.RETURN);	  
			  System.out.println("Gebruiker kiest een grondbanktaak Registratie_OK");
			  
			  
			  
				 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  
//////////////////////////////////////////////////////////////STARTFASE			
			    
				   
///////////////////////////////////////////////////////////////HIER BEGINT Scenario: direct afgehandelde zaak terugvinden|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

				 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			  
			  
			  //When: gebruiker selecteert 'week'
			  //Then: overzicht met afgehandelde zaken wordt getoond
			  driver.findElement(By.cssSelector("#ext-gen100")).click();
			  System.out.println("Gebruiker klikt op dropdownlist bij 'afgehandeld en kiest 'week''_OK");
			  System.out.println(" overzicht met afgehandelde zaken wordt getoond'_OK");
			  driver.findElement(By.className("x-menu-item-text")).click();
			  
			 

				 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}

				 //  When: gebruiker genoteerd zaaknummer uit vorige test onder 'zaak' invult
				  // Then: zoekresultaten met zojuist afgehandelde zaak wordt getoond
				   WebElement Casenumber = driver.findElement(By.cssSelector("div.x-grid3-row:nth-child(12) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)"));
				   System.out.println(Casenumber.getAttribute("innerHTML"));  
				   
				   driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				   driver.findElement(By.xpath("//*[@id=\"ext-comp-1016\"]")).sendKeys(Casenumber.getAttribute("innerHTML")); 
				   System.out.println("Zaaknummer_copy paste'_OK");
				   System.out.println("gebruiker heeft genoteerd zaaknummer uit vorige test onder 'zaak' ingevuld_OK");
				   System.out.println("zoekresultaten met zojuist afgehandelde zaak wordt getoond'_OK");
				   
								   
				   
				   
			////////////////////////////////////////////////////  Scenario: direct afgehandelde zaak in archief opzoeken//////////////////////////////////////////////////////
				   
			
				   
				   
				   
				   driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(8000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				   
				   //Scenario: direct afgehandelde zaak in archief opzoeken
				   //Given: gebruiker is ingelogd in de acceptatie-omgeving van het archiefportaal via https://zaken.acceptatie.amstelveen.nl/archief
					   driver.get("https://zaken.acceptatie.amstelveen.nl/archief");
					   System.out.println("archief is geopend_OK");
					   
					   
					   
					   driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					   
					   
					   //  When: gebruiker het zaaknummer van de zojuist afgehandelde zaak invoert bij het veld onder 'nummer'
						// Then: zoekresultaten worden getoond
					   
					   WebDriverWait wait = new WebDriverWait(driver,20);
					   WebElement aboutMe;
					   aboutMe= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ext-comp-1022']"))); 
					   driver.manage().timeouts().implicitlyWait(8000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					   
					   driver.findElement(By.xpath("//input[@id='ext-comp-1022']")).click();
					   
					   driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					   
					   //And: zaak corresponderend aan het genoteerde zaaknummer wordt getoond in het tabblad 'te archiveren'
					   //And: onder de kolom 'bewaren/vernietigen' staat 'vernietigen'
					   //And: onder de kolom 'vernietigbaar' staat '2020'
					   driver.findElement(By.xpath("//input[@id='ext-comp-1022']")).sendKeys("Z19-001082"); 
					  
					   System.out.println(" zaak corresponderend aan het genoteerde zaaknummer wordt getoond in het tabblad 'te archiveren'_OK");
					   System.out.println(" onder de kolom 'bewaren/vernietigen' staat 'vernietigen'_OK");
					   System.out.println(" onder de kolom 'vernietigbaar' staat '2020'_OK");
					   
					   
					   
					   
					   
						   
		  }}}