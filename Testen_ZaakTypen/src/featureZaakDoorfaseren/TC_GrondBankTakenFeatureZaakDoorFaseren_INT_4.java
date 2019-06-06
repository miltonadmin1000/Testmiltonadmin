package featureZaakDoorfaseren;

	
	

/*
	 * Testcase: Grondbanktaken
	 
	 Feature: zaak doorfaseren
	 Background: gebruiker is ingelogd in de acceptatie-omgeving
	 Background: gebruiker bevindt zich in testzaak(de Coordinator grondbanktaken)
	 
	  Scenario: zaak naar volgende fase brengen
	   When: gebruiker klikt onder kopje 'Behandeling afgerond (1)' op het vinkje naast 'voldoende informatie'
	   And: gebruiker klikt op 'volgende fase'
	   Then: po-up verschijnt met de vraag 'U bent klaar met Behandelen. De zaak gaat naar fase Afhandelen. Wilt u doorgaan?'
	   When: gebruiker klikt op 'Ja'
	   Then: groen vinkje verschijnt voor het woord 'Behandelen'
	   And: mogelijkheid om 'voldoende informatie' aan te vinken onder kopje 'Afgehandeld' verschijnt
	 
	 */

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.Keys;


	public class TC_GrondBankTakenFeatureZaakDoorFaseren_INT_4 {
		
			  
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
						   
			  //----------------------------------------------------------------- 
			   
			    //And: gebruiker klikt op tab 'mijn zaken'
				  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span")).click();
				  System.out.println("De Tab bij 'mijnzaken' werkt goed_OK");
			 
				  
				//And: gebruiker selecteert in het drop-down menu de rol 'Behandelaar Grondbanktaken' 
					// Then: alle zaken voor Behandelaar Grondbanktaken verschijnen
				     WebElement drpdwnBGBT= driver.findElement(By.xpath("//*[@id=\"ext-gen95\"]"));
				     JavascriptExecutor jseBGBT =  (JavascriptExecutor)driver;
				     jseBGBT.executeScript("arguments[0].click();", drpdwnBGBT );
				     driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				     
				     
					  driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys("Zaakco�rdinator Grondbanktaken - amstelveen");
					   driver.findElement(By.xpath("//input[contains(@name,'ext-comp-1033')]")).sendKeys(Keys.RETURN);
					  System.out.println("BehandelaarGrondbanktaken ziet alle zaken");
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			
			  
			//When: gebruiker kijkt bij de regel van de zaak met als 'betreft' de tekst 'test' onder de kolom 'organisatie'
			  driver.findElement(By.xpath("	//*[@id=\"ext-comp-1017\"]")).sendKeys("test");
			  driver.findElement(By.xpath("	//*[@id=\"ext-comp-1017\"]")).sendKeys(Keys.RETURN);	  
			  System.out.println(" gebruiker kijkt bij de regel van de zaak met als 'betreft' de tekst 'test onder de kolom 'organisatie'_OK");
			  		  	
			  	
			  	 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			//---------------------------------------------------------------------------------------------------------------------------	
				  
	  //Gebruiker opent een grondbanktaak
	  driver.findElement(By.cssSelector(("div.b-row-Behandelen:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)"))).click();
	  	 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 System.out.println("gebruiker opent een grondbbanktaak");
		 
		 
		 
		 driver.manage().timeouts().implicitlyWait(6000,TimeUnit.SECONDS) ;
		   try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		  //op voldoende informatie klikken bij'behandeling afgeronf(1)'
		 
			
		   WebElement myelement = driver.findElement(By.cssSelector(".b-row-invalid > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(7) > div:nth-child(1)"));
		   JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		   jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
		   System.out.println("element is in view");
		    JavascriptExecutor jse =  (JavascriptExecutor)driver;
		    jse2.executeScript("arguments[0].click();", myelement );
		    driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			 driver.findElement(By.cssSelector(".b-row-invalid > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(7) > div:nth-child(1)")).click();
			 System.out.println("op voldoende informatie klikken bij'afgehandeld(1)_OK");
		 
		 
		 
		 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		   
		 
		   //volgende fase klikken
			  driver.findElement(By.xpath("//button[text()='volgende fase']")).click();
			 System.out.println("gebruiker klikt op knop'volgende fase'_OK");
			  
			 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
			   try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		   
			//naar fase afhandelen?
				  driver.findElement(By.xpath("//button[text()='Ja']")).click();
				  
					 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
					   System.out.println("dukken op knop ja bij 'naar fase afhandelen?''OK'_OK");
		   
		   
		 
		 
		 driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  
		 
		  
	
		// And: mogelijkheid om onder kopje '  2. Afgehandeld (1)' aan te vinken of er 'voldoende informatie' is verschijnt_Checkpoint
		  
		   if(driver.getPageSource().contains("mogelijkheid om onder kopje '  2. Afgehandeld (1)' aan te vinken of er 'voldoende informatie' is verschijnt")){
						 System.out.println("''_Test SUCCES!");
						 }else{				  {
						 System.out.println("mogelijkheid om onder kopje '  2. Afgehandeld (1)' aan te vinken of er 'voldoende informatie' is verschijnt NIET_Test FAILED");
							  
							  

						 
						 
						 System.out.println("Driver sluit website af in enkel seconden");
						 
						   try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						 
						 driver.quit();
						 
						 
			        
			      
			        
			        
			        
			    }

						 }}    }}
		  
	
	

	
					  
		  

		


