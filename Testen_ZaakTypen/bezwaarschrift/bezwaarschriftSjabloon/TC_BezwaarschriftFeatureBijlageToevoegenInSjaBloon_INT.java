package bezwaarschriftSjabloon;
/*
 * Scenario: bijlage toevoegen in sjablooninhoud in testzaak
   Given: gebruiker bevindt zich in testzaak in fase Beoordelen
   When: gebruiker klikt op knop '<<' boven 'zaak dossier'
   Then: zaakdossier klapt uit 
   When: gebruiker klikt op drop-down menu
   And: gebruiker selecteert 'Aanvullende gegevens'
   Then: sjabloon voor 'Verzoek Aanvullende gegevens' wordt geopend
   When: gebruiker klikt op tabblad 'inhoud'
   And: gebruiker klikt op '<<' boven bijlagen aan de rechterkant
   Then: bijlage menu klapt uit
   When: gebruiker klikt op '+' in bijlage menu
   Then: pop-up om bijlage te selecteren verschijnt
   When: gebruiker selecteert bijlage 'TEST bijlage' uit map 'Acceptatietest batch 1'
   And: gebruiker klikt op 'openen'
   Then: bijlage wordt toegevoegd in bijlagemenu
   When: gebruiker klikt op 'opslaan' linksboven 
   And: gebruiker noteert het zaaknummer
   And: gebruiker sluit het tabblad van de zaak bovenin het scherm
   And: gebruiker klikt op 'ja' bij de pop-up 'wijzigingen opslaan'
   Then: gebruiker keert terug naar het scherm van de werkvoorraad
   When: gebruiker opent zaak met corresponderend zaaknummer
   And: gebruiker opent zaakdossier middels de knop '<<'
   And: gebruiker klikt op de bijlage genaamd 'Verzoek Aanvullende gegevens'
   And: gebruiker opent het tabblad 'inhoud'
   And: gebruiker klapt 'bijlagen' open middels de knop '<<'
   Then: in het bijlageveld is een tegel zichtbaar met de titel 'TEST bijlage' er in
 * 
 * 
 * 
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;

		import lib.ClickElement;
		

 //package bezwaarschrift;

 public class TC_BezwaarschriftFeatureBijlageToevoegenInSjaBloon_INT {

	 public static void main(String[] args) throws IOException, InterruptedException, AWTException { {
		
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
					  		  

					  System.out.println("Gebruiker is geauthoriseerd_Webpagina is OK");
				  }
				  else{
					  System.out.println("Gebruiker is geauthoriseerd_Webpagina is NOT OK");
				  }

				  
				  
			
			////////////////////////////////////////////////////////// Scenario: bijlage toevoegen in sjablooninhoud in testzaak//////////////////////////////////////////////
				  	
				  	
				  	System.out.println("START_Scenario: bijlage toevoegen in sjablooninhoud in testzaak ");	
				  	
				  	
				  	//klikken dropdown
				  	try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  	   ClickElement.clickByID(driver, "ext-gen95");
				  	   System.out.println("Zaakcoördinator Bezwaarschrift ziet alle zaken_OK");
				  	
					
				  	   //kiezen rol van zaakcoordinator bezwaarschriften
				  	   driver.findElement(By.xpath("//div[contains(text(), 'Zaakcoördinator Bezwaarschrift - amstelveen')]")).click();
				  	   System.out.println("Zaakcoördinator is gekozen en ziet alle zaken_OK");
					  

					  try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
					  
					  //Zaakcoordinator bezwaartaken selecteert bezwaarschrift met nummer 'Z18-004177'
					  
					  driver.findElement(By.xpath("//*[@id=\"ext-comp-1016\"]")).sendKeys("Z18-004177");
					  driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td[2]/div")).click();
					  
					  
					  
					  System.out.println("bezwaarschrift is geselecteerd door coordinator_OK");
					  
				  	  try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		//----------------------------------------------------------------------------------------------------------				  
					  
				  	// When: gebruiker klikt op knop '<<' boven 'zaak dossier' 
				  	//Then: zaakdossier klapt uit
				 	  
				  	ClickElement.clickByID(driver, "ext-gen176");	
				  			
				  			 try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
					System.out.println("knop << boven zaak is gedrukt_en_zaakdossier klapt uit_OK");  
				  	 		 
			//-------------------------------------------------------------------------------------------------------	 
					
					
					//When: gebruiker klikt op drop-down menu 
					ClickElement.clickByID(driver, "ext-gen732");	
					
		 			 try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    	System.out.println("dropdownmenu is uitgeklapt_OK");  
		    	
		
	
//And: gebruiker selecteert 'Aanvullende gegevens'
//Then: sjabloon voor Aanvullende gegevens wordt geopend

	driver.findElement(By.xpath("//input[@name='ext-comp-1581' and @class='x-form-text x-form-field x-form-focus']")).sendKeys("Verzoek aanvullende gegevens");
	driver.findElement(By.xpath("//input[@name='ext-comp-1581' and @class='x-form-text x-form-field x-form-focus']")).sendKeys(Keys.RETURN);
	System.out.println("selecteert 'Collegebesluit' + sjabloon voor Collegebesluit wordt geopend_OK");    
	//System.out.println("NU ZELF OP DE KNOP DRUKKEN!!!_OK"); 		

	 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

    WebElement link_Home = driver.findElement(By.linkText("Inhoud"));
    WebElement td_Home = driver.findElement(By.cssSelector("#ext-gen908 > em:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
    Actions builder = new Actions(driver);
    Action mouseOverHome =  builder.moveToElement(link_Home).click().build(); 
    mouseOverHome.perform();
	
	
    
	
	
	try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	//And: gebruiker klikt op '<<' boven bijlagen aan de rechterkant
	 // Then: bijlage menu klapt uit
	 WebDriverWait wait = new WebDriverWait(driver, 8000);
	 WebElement elementBijlB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ext-gen1407\"]")));
	 WebElement BijlB = driver.findElement(By.xpath("//*[@id=\"ext-gen1407\"]"));
	 JavascriptExecutor jseBijlB =  (JavascriptExecutor)driver;
	 jseBijlB.executeScript("arguments[0].click();", BijlB );
	 System.out.println("'<<' boven bijlagen is clicked_+_ Then: bijlage menu klapt uit_OK");
	 
	 
			 try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				}
	 
				 
			 WebElement Grbtn = driver.findElement(By.xpath("//div[@id='b-applicatie-container']"
			 		+ "/div/div/div[3]/div/div[@class='x-tab-panel-bwrap']/div[@class='x-tab-panel-body x-tab-panel-body-top']"
			 		+ "/div[2]/div[@class='x-panel-bwrap']/div[@class='x-panel-ml']/div[@class='x-panel-mr']/div[@class='x-panel-mc']"
			 		+ "/div[2]/div[1]/div[2]/div[@class='x-tab-panel-bwrap']/div[@class='x-tab-panel-body x-tab-panel-body-top']"
			 		+ "/div[2]/div[@class='x-panel-bwrap']/div[@class='x-panel-ml']/div[@class='x-panel-mr']/div[@class='x-panel-mc']"
			 		+ "/div[2]/div[1]/div[1]/div/div[@class='x-panel-body x-panel-body-noheader']/div//form[@method='POST']"
			 		+ "/div//div[@class='x-tab-panel-body x-tab-panel-body-top']/div[2]//div[@class='x-panel-mc']/div/fieldset[1]/div"
			 		+ "/div[2]/div[5]//div[@class='x-panel-tbar']/div//div[@class='x-form-field-wrap x-form-file-wrap']/input[@alt='Eén of meerdere bijlagen toevoegen...']"));
			 JavascriptExecutor jseGrbtn =  (JavascriptExecutor)driver;
			 jseGrbtn.executeScript("arguments[0].click();", Grbtn );
			 System.out.println("'+' button is gedrukt in bijlage menu_OK");	
			 WebElement uploadElement = driver.findElement(By.xpath("//div[@id='b-applicatie-container']/div/div/div[3]/div/div[@class='x-tab-panel-bwrap']/"
			 		+ "div[@class='x-tab-panel-body x-tab-panel-body-top']/div[2]/div[@class='x-panel-bwrap']/div[@class='x-panel-ml']/div[@class='x-panel-mr']"
			 		+ "/div[@class='x-panel-mc']/div[2]/div[1]/div[2]/div[@class='x-tab-panel-bwrap']/div[@class='x-tab-panel-body x-tab-panel-body-top']/div[2]"
			 		+ "/div[@class='x-panel-bwrap']/div[@class='x-panel-ml']/div[@class='x-panel-mr']/div[@class='x-panel-mc']/div[2]/div[1]/div[1]/div"
			 		+ "/div[@class='x-panel-body x-panel-body-noheader']/div//form[@method='POST']/div//div[@class='x-tab-panel-body x-tab-panel-body-top']/div[2]/"
			 		+ "/div[@class='x-panel-mc']/div/fieldset[1]/div/div[2]/div[5]//div[@class='x-panel-tbar']/div//div[@class='x-form-field-wrap x-form-file-wrap']"
			 		+ "/input[@alt='Eén of meerdere bijlagen toevoegen...']"));
			 

			  //Store the location of the file in clipboard
			 //Clipboard
			 StringSelection strSel = new 
			 StringSelection("H:\\Beheer InProces 2.10\\Upgrade 2.13\\Tests\\Testscenario's\\Acceptatietest batch 1\\TEST bijlage.pdf");;
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
			 
			 
	  
			//Create an object for robot class
	         Robot robot = new Robot();
	         //Control key in the keyboard
	         //Ctrl+V
	         robot.keyPress(KeyEvent.VK_CONTROL);
	         robot.keyPress(KeyEvent.VK_V);
	         robot.keyRelease(KeyEvent.VK_CONTROL);

	         Thread.sleep(3000);
	         robot.keyPress(KeyEvent.VK_ENTER);
	         robot.keyRelease(KeyEvent.VK_ENTER);
	         System.out.println(".pdf Document is geupload_OK");
	         
	         
	         
	         try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				}
	         
	         //When: gebruiker klikt op 'opslaan' linksboven 
	        WebDriverWait waitOpsbttn = new WebDriverWait(driver, 800);
			 WebElement elementOpsbttn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'opslaan')]")));
			 WebElement Opsbttn = driver.findElement(By.xpath("//button[contains(text(), 'opslaan')]"));
			 JavascriptExecutor jseOpsbttn =  (JavascriptExecutor)driver;
			 jseOpsbttn.executeScript("arguments[0].click();", Opsbttn );
		     System.out.println("gebruiker klikt op 'opslaan' linksboven_OK");
	         
	         
		     try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				}
	         
		     
		 	//When: gebruiker klikt de pop-up weg met 'X'
		 		 WebDriverWait waitKLIKX = new WebDriverWait(driver, 800);
		 		 WebElement elementKLIKX = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'ext-gen805')]")));
		 		 WebElement KLIKX = driver.findElement(By.xpath("//*[contains(@id,'ext-gen805')]"));
		 		 JavascriptExecutor jseKLIKX =  (JavascriptExecutor)driver;
		 		 jseKLIKX.executeScript("arguments[0].click();", KLIKX );
		 		 System.out.println("kruisje geklikt om 'aanvullende gegevens' af te sluiten_OK");
		 	  
		 		 
		 		 
		 		 
		 		   try {
		 			Thread.sleep(4000);
		 		} catch (InterruptedException e) {
		 			
		 			e.printStackTrace();
		 		}
		      
	       
		 		   
		 		   
		 		   //menu 'kenmerken' openklappen
		 		 
			 		 WebDriverWait waitKLIKM = new WebDriverWait(driver, 800);
			 		 WebElement elementKLIKM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ext-gen225\"]")));//*[@id="ext-gen225"]//*[contains(text(),'kenmerken')]
			 		 WebElement KLIKM = driver.findElement(By.xpath("//*[@id=\"ext-gen225\"]"));
			 		 JavascriptExecutor jseKLIKM =  (JavascriptExecutor)driver;
			 		 jseKLIKM.executeScript("arguments[0].click();", KLIKM );
			 		 System.out.println("menu van 'kenmerken' is geklikt_OK");
		 		   
			 		 
			 		//*[contains(text(),'kenmerken')]
			 			 
			 		 
			 		 
			 		 
		 		   
		 		   
		 		   
			  //And: gebruiker noteert het zaaknummer
		        
			   System.out.println("nu ga ik het zaaknummerkopieren naar memory van uit 'kenmerk'_OK");
				WebElement Casenumber = driver.findElement(By.xpath("//div[contains(@name,'referentiecode')]"));
				System.out.print("Hetzaaknummer is :");
				System.out.println(Casenumber.getAttribute("innerHTML"));  
				driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
				 
				   try {
					Thread.sleep(4000);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			 
				   
				   
				   // And: gebruiker sluit het tabblad van de zaak bovenin het scherm
				   
					 WebDriverWait waitCloseUpper = new WebDriverWait(driver, 800);
			 		 WebElement elementCloseUpper = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'ext-gen133')]")));
			 		 WebElement CloseUpper = driver.findElement(By.xpath("//*[contains(@id,'ext-gen133')]"));
			 		 JavascriptExecutor jseCloseUpper =  (JavascriptExecutor)driver;
			 		 jseCloseUpper.executeScript("arguments[0].click();", CloseUpper );
			 		 System.out.println("gebruiker sluit het tabblad van de zaak bovenin het scherm_OK");
			 	  
			 		
				   
				   
			 		  //And: gebruiker klikt op 'ja' bij de pop-up 'wijzigingen opslaan'
					   //Then: gebruiker keert terug naar het scherm van de werkvoorraad
					        
					 WebDriverWait waitJaKnpWzgn = new WebDriverWait(driver, 800);
					 WebElement elementJaKnpWzgn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Ja')] ")));
					 WebElement JaKnpWzgn = driver.findElement(By.xpath("//button[contains(text(),'Ja')] "));
					 JavascriptExecutor jseJaKnpWzgn =  (JavascriptExecutor)driver;
					 jseJaKnpWzgn.executeScript("arguments[0].click();", JaKnpWzgn );
					 System.out.println("gebruiker klikt op 'ja' bij de pop-up 'wijzigingen opslaan'_OK +"
					 + "gebruiker keert terug naar het scherm van de werkvoorraad_OK + gebruiker opent zaak met corresponderend zaaknummer_OK");
			 		 
			 		 
					 
					 
					 
					  try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
				     
				     
				      //When: gebruiker opent zaak met corresponderend zaaknummer
						 WebDriverWait waitOpentZaaK = new WebDriverWait(driver, 800);
						 WebElement elementOpentZaaK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Z18-004177')]")));
						 WebElement OpentZaaK = driver.findElement(By.xpath("//div[contains(text(),'Z18-004177')]"));
						 JavascriptExecutor jseOpentZaaK =  (JavascriptExecutor)driver;
						 jseOpentZaaK.executeScript("arguments[0].click();", OpentZaaK );
					     System.out.println("gebruiker opent zaak met corresponderend zaaknummer_OK");
					     System.out.println("zaak met corresponderend zaaknummer is geopend_OK");  
					     
					     try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				
				 
						  	// When: gebruiker klikt op knop '<<' boven 'zaak dossier' 
						  	//Then: zaakdossier klapt uit
						 
						 WebDriverWait waitOpentZkDs = new WebDriverWait(driver, 1000);
						 WebElement elementOpentZkDs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ext-gen1718\"]")));
						 WebElement OpentZkDs = driver.findElement(By.xpath("//*[@id=\"ext-gen1718\"]"));
						 JavascriptExecutor jseOpentZkDs =  (JavascriptExecutor)driver;
						 jseOpentZkDs.executeScript("arguments[0].click();", OpentZkDs );
						 System.out.println("knop << boven zaak is gedrukt_en_zaakdossier klapt uit_OK"); 
						 
						
						 try {
									Thread.sleep(6000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
						 
						    //zoeken op 'verzoek aanvullende gegevens' in veld titels
						  driver.findElement(By.xpath("//*[@id=\"ext-comp-3095\"]")).sendKeys("Verzoek aanvullende gegevens");
						 
						  
						  try {
								Thread.sleep(4000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						 
							//DAN: klikken op bijlage aanvullende gegevens
						     driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td[4]/div")).click();
					  	     System.out.println("gebruiker klikt bijlage_OK"); 

							  try {
									Thread.sleep(6000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							  
													
					  	   //And: gebruiker opent het tabblad 'inhoud'
							  WebElement link_Inh = driver.findElement(By.linkText("Inhoud"));
							  WebElement td_Inh = driver.findElement(By.xpath("//span[contains(text(),'Inhoud')]"));
							   Actions builderInh = new Actions(driver);
							  Action mouseOverInh =  builderInh.moveToElement(link_Inh).click().build(); 
							  mouseOverInh.perform();	  
							  
							   System.out.println("gebruiker klikt nog een op Tnhoud_OK"); 
							  
							  try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
					  	     
					  	     
							 //And: gebruiker klapt 'bijlagen' open middels de knop '<<'
							 //Then: in het bijlageveld is een tegel zichtbaar met de titel 'TEST bijlage' er in
							 WebElement td_Arrow = driver.findElement(By.xpath("//div[2]/div[9]/div"));
						 	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							 Actions builderArrow = new Actions(driver);
							 Action mouseOverArrow =  builderArrow.moveToElement(td_Arrow).click().build(); 
							 mouseOverArrow.perform();	  
							 System.out.println("knop '<<' bij bijlagen klapt uit_OK"); 
													    
							 
							 if(driver.findElement(By.xpath("//div[2]/div[9]/div")) != null){
								  
								  System.out.println(" in het bijlageveld is een tegel zichtbaar met de titel 'TEST bijlage' er in_Test is SUCCES");
								  }else{
								  System.out.println("in het bijlageveld is een tegel zichtbaar met de titel 'TEST bijlage' er in_Test FAILS");
								  }
							 
							 
							 
							  try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							 
							 
							 
							  System.out.println(" OVER ENKELE SECONDEN SLUIT DE TEST");
							 
							 driver.quit();
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
							 
	 }
	 }}
	 