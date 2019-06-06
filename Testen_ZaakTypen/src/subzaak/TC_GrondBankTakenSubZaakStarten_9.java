
/* Testcase: Grondbanktaken
 
 Feature: subzaak starten
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 Background: gebruiker bevindt zich in testzaak van rol Zaakcoordinator Grondbanktaken na hervatten zaak
 
  Scenario: geannuleerde testzaak hervatten
   When: gebruiker klikt op tabblad 'planning' bovenin
   Then: tabblad planning opent zich
   When: gebruiker opent drop-down menu naast 'Start subzaak'
   And: gebruiker selecteert 'document uitgaand'
   Then: pop-up getiteld 'Start Document Uitgaand' opent zich
   When: gebruikt vult het veld 'betreft' met de tekst 'TESTBetreft'
   And: gebruiker selecteert in het deel 'selecteer de documenten voor deelzaak Document Uitgaand' het document met type 'Registratie'
   And: gebruiker klikt op 'ok'
   Then: in 'planning' tabblad verschijnt een regel onder het kopje 'Verzenden' met 'zaaktype' ingevuld als 'Document uitgaand'
	    * 
	 */

	package subzaak;
	
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

	public class TC_GrondBankTakenSubZaakStarten_9 {

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
				  System.out.println("textvlak ingevuld");
				  
				  driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS) ;
				   try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				   driver.findElement(By.cssSelector(".x-panel-fbar .x-toolbar-cell:nth-of-type(1) .x-btn-tc")).click();
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
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  
						   //---------------------
						  // When: gebruiker klikt op knop 'zaak' rechtsboven 
					  //Then: drop-down menu verschijnt met opties voor zaak
					  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/em")).click();
					  System.out.println("dropdown zaak geklikt");
					  
					  //-----------------
					  //Pauze
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
					   
					   //--------------------------------------------------------------------------------------------------------------
					  
					  //klikken knop hervatten
					  //driver.findElement(By.xpath("//*[@id=\"ext-gen947\"]")).click();//*[@id="ext-gen947"]
					  
					  //driver.findElement(By.xpath("//body/div[73]/ul[@class='x-menu-list']/li[@class='x-menu-list-item']/a[@href='#']/span[@class='x-menu-item-text']")).click();
					  
					  
					  driver.findElement(By.cssSelector(".x-menu-list .x-menu-list-item:nth-of-type(6) .x-unselectable")).click();
					  
					  System.out.println("zaak hervatten is geklikt");
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
					
					   
					   
					   
					   
					   
					   
					   //-------------------------------------------
					   
					   
					   
					   
					   
					  
					 //Hervatten reden invullen
					driver.findElement(By.xpath("//textarea[@class='ext-mb-textarea']")).sendKeys("TESTHervatten");
					  System.out.println("textvlak ingevuld met TESTHervatten!!!");
					  
					
					  
					  
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					  //op OK knop klikken
					  driver.findElement(By.xpath("/html/body/div[59]/div[2]/div[2]/div/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]")).click();
					  System.out.println("zaak is hervat_ OK");
						  
					  
					  
					  
					  
					  //--------------------------------------------//--------------------------------//-------------------------------------------------//------------------------------------
					  
					  //  When: gebruiker klikt op tabblad 'planning' bovenin
					  // Then: tabblad planning opent zich
 				    
					  
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
					   
					   
				     WebElement TAB = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/ul/li[4]/a[2]/em/span/span"));
				     JavascriptExecutor jsTAB = (JavascriptExecutor)driver;
				     jsTAB.executeScript("arguments[0].click();", TAB );
				     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				      System.out.println("tab planning opent zich_OK");
				      
				      
				      
				      
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				      
				      
					  
					  //When: gebruiker opent drop-down menu naast 'Start subzaak'
					  
					  WebElement drpdwnnaTAB = driver.findElement(By.cssSelector(".x-panel-tbar-noheader [src]"));
					     JavascriptExecutor jsdrpdwnnaTAB = (JavascriptExecutor)driver;
					     jsTAB.executeScript("arguments[0].click();", drpdwnnaTAB );
					     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					      System.out.println("gebruiker opent drop-down menu naast 'Start subzaak");
					  
					      
					
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
					  //And: gebruiker selecteert 'document uitgaand'
					  // Then: pop-up getiteld 'Start Document Uitgaand' opent zich
					  
					     WebElement docSelect = driver.findElement(By.cssSelector("div.x-combo-selected:nth-child(1)"));
					     JavascriptExecutor jsdocSelect = (JavascriptExecutor)driver;
					     jsdocSelect.executeScript("arguments[0].click();", docSelect );
					     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					     System.out.println("pop-up getiteld 'Start Document Uitgaand' opent zich_OK");

					
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   
					   
					   
					   
					  //When: gebruikt vult het veld 'betreft' met de tekst 'TESTBetreft'
					  driver.findElement(By.name("betreft")).sendKeys("TESTBetreft");
					  System.out.println("text TESTBetreft is ingevuld_OK");
				
					  
		
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
		 
		 
					  // And: gebruiker selecteert in het deel 'selecteer de documenten voor deelzaak Document Uitgaand' het document met type 'Registratie'
					 
					    
					     if ( !driver.findElement(By.cssSelector(".x-grid3-row-checker")).isSelected() )
					     {
					         driver.findElement(By.cssSelector(".x-grid3-row-checker")).click();
					     }
					  
					     System.out.println("documenten in pop_up zijn geselecteerd_OK");
		
					  
					  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
					   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
					  
					   
					     
					   //And: gebruiker klikt op 'ok'
					
						  
					  
					  if ( !driver.findElement(By.cssSelector(".x-resizable-pinned .x-toolbar-cell:nth-of-type(1) [type]")).isSelected() )
					    {
						         driver.findElement(By.cssSelector(".x-resizable-pinned .x-toolbar-cell:nth-of-type(1) [type]")).click();
					    }
					  
					     System.out.println("OK is geklikt_OK");
		
					  
					     // Then: in 'planning' tabblad verschijnt een regel onder het kopje 'Verzenden' met 'zaaktype' ingevuld als 'Document uitgaand'
					  
					     if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/div")) != null){
							  
							  System.out.println("in 'planning' tabblad verschijnt een regel onder het kopje 'Verzenden' met 'zaaktype' ingevuld als 'Document uitgaand'_Test is succes");
							  }else{
							  System.out.println("in 'planning' tabblad verschijnt NIET een regel onder het kopje 'Verzenden' met 'zaaktype' ingevuld als 'Document uitgaand'_Test FAILED");
							  }
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
		 }
		
		 }}
		
		
		 

	
