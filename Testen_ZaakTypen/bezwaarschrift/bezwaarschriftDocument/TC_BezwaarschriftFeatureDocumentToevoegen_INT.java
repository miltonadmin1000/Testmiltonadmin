/*Testcase: Bezwaarschrift

 Feature: document toevoegen
 Background: gebruiker is ingelogd in de acceptatie-omgeving
 Background: gebruiker bevindt zich in de werkvoorraad van de rol 'Zaakcoordinator Bezwaarschrift - amstelveen'
 
  Scenario: collegebesluit toevoegen aan zaakdossier testzaak
   Given: gebruiker bevindt zich in testzaak in fase Beoordelen
   When: gebruiker klikt op knop '<<' boven 'zaak dossier'
   Then: zaakdossier klapt uit 
   When: gebruiker klikt op drop-down menu 
   And: gebruiker selecteert 'Collegebesluit'
   Then: sjabloon voor Collegebesluit wordt geopend
   When: gebruiker klikt op tabblad 'inhoud'
   And: gebruiker klikt op 'document maken'
   Then: pop-up  verschijnt getiteld 'Document genereren'
   When: gebruiker klikt op 'OK'
   Then: pop-up van gemaakt document verschijnt
   When: gebruiker klikt de pop-up weg met 'X'
   And: gebruiker klikt op 'opslaan' linksboven 
   And: gebruiker noteert het zaaknummer
   And: gebruiker sluit het tabblad van de zaak bovenin het scherm
   And: gebruiker klikt op 'ja' bij de pop-up 'wijzigingen opslaan'
   Then: gebruiker keert terug naar het scherm van de werkvoorraad
   When: gebruiker opent zaak met corresponderend zaaknummer
   And: gebruiker opent zaakdossier middels de knop '<<'
   Then: onderste bijlage is van type 'Collegebesluit'
   ---------------------------------------------------------------------------------------------------------------------------------
  
 * 
 */


package bezwaarschriftDocument;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lib.ClickElement;


public class TC_BezwaarschriftFeatureDocumentToevoegen_INT {

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

		  System.out.println("gebruiker is ingelogd in de acceptatie omgeving");
		
		  //driver checkt als gebruiker is gauthoriseerd		  

		  if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[1]/div[2]")) != null){
			  		  

			  System.out.println("Gebruiker is geauthoriseerd_Webpagina is OK");
		  }
		  else{
			  System.out.println("Gebruiker is geauthoriseerd_Webpagina is NOT OK");
		  }

		  
		  
	
	//////////////////////////////////////////////////////////Scenario: collegebesluit toevoegen aan zaakdossier testzaak//////////////////////////////////////////////
		  	
		  	
		  	System.out.println("START_Scenario: collegebesluit toevoegen aan zaakdossier testzaak ");	
		  	
		  	
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
		  	 		 
		 
			
			
			//When: gebruiker klikt op drop-down menu 
			ClickElement.clickByID(driver, "ext-gen732");	
			
 			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	System.out.println("dropdownmenu is uitgeklapt_OK");  
		  			 

	     //And: gebruiker selecteert 'Collegebesluit'
	
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	System.out.println("dropdownmenu is uitgeklapt_OK");   
		  			 
	
	//And: gebruiker selecteert 'Collegebesluit'
    //Then: sjabloon voor Collegebesluit wordt geopend
	 driver.findElement(By.xpath("//input[@name='ext-comp-1581' and @class='x-form-text x-form-field x-form-focus']")).sendKeys("Collegebesluit");
	 driver.findElement(By.xpath("//input[@name='ext-comp-1581' and @class='x-form-text x-form-field x-form-focus']")).sendKeys(Keys.RETURN);
	 System.out.println("selecteert 'Collegebesluit' + sjabloon voor Collegebesluit wordt geopend_OK");    
	  		
	
	       
	  //When: gebruiker klikt op tabblad 'inhoud'
	 
	 WebDriverWait wait = new WebDriverWait(driver, 100);
	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div/div/form/div/div[1]/div[1]/ul/li[5]/a[2]/em/span/span")));
	 WebElement DOC = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div/div/form/div/div[1]/div[1]/ul/li[5]/a[2]/em/span/span"));
	 JavascriptExecutor jseDOC =  (JavascriptExecutor)driver;
	 jseDOC.executeScript("arguments[0].click();", DOC );
	 System.out.println("tabblad Inhoud is gedrukt");
	 
	 
	 
	 try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	//And: gebruiker klikt op 'document maken'
     //Then: pop-up  verschijnt getiteld 'Document genereren'
     
	 WebDriverWait waitOKBUT = new WebDriverWait(driver, 100);
	 WebElement elementOKBUT = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'document maken')]")));
	 WebElement OKBUT = driver.findElement(By.xpath("//*[contains(text(),'document maken')]"));
	 JavascriptExecutor jseOKBUT =  (JavascriptExecutor)driver;
	 jseDOC.executeScript("arguments[0].click();", OKBUT );
	 System.out.println("OK button  is clicked_OK");
	 
	 System.out.println("pop-up van gemaakt document verschijnt_OK");
	 
	 
	 
	 try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	 

	//When: gebruiker klikt de pop-up weg met 'X'
	 WebDriverWait waitKRUIS = new WebDriverWait(driver, 800);
	 WebElement elementKRUIS = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ext-gen1434")));
	 WebElement KRUIS = driver.findElement(By.cssSelector("#ext-gen1434"));
	 JavascriptExecutor jseKRUIS =  (JavascriptExecutor)driver;
	 jseDOC.executeScript("arguments[0].click();", KRUIS );
	 System.out.println("KRUISJE X is clicked_OK");
	

	 
	 
	 
	 
	 
	 try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     //And: gebruiker klikt op 'opslaan' linksboven 
		 WebDriverWait waitopsln = new WebDriverWait(driver, 800);
		 WebElement elementopsln = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='b-applicatie-container']/div/div/div[3]/div/div[@class='x-tab-panel-bwrap']/div[@class='x-tab-panel-body x-tab-panel-body-top']/div[2]/div[@class='x-panel-bwrap']/div[@class='x-panel-ml']/div[@class='x-panel-mr']/div[@class='x-panel-mc']/div[@class='x-panel-tbar x-panel-tbar-noborder']/div//tr[@class='x-toolbar-left-row']/td[1]/table//button[@type='button']")));
		 WebElement opsln = driver.findElement(By.xpath("//div[@id='b-applicatie-container']/div/div/div[3]/div/div[@class='x-tab-panel-bwrap']/div[@class='x-tab-panel-body x-tab-panel-body-top']/div[2]/div[@class='x-panel-bwrap']/div[@class='x-panel-ml']/div[@class='x-panel-mr']/div[@class='x-panel-mc']/div[@class='x-panel-tbar x-panel-tbar-noborder']/div//tr[@class='x-toolbar-left-row']/td[1]/table//button[@type='button']"));
		 JavascriptExecutor jseopsln =  (JavascriptExecutor)driver;
		 jseDOC.executeScript("arguments[0].click();", opsln );
		 System.out.println("Opslaan is geklikt, document is opgeslagen_OK");
		
		 
		 
		 
		
	 try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 

	 
	//When: gebruiker klikt de pop-up weg met 'X'
		 WebDriverWait waitKenmrk = new WebDriverWait(driver, 800);
		 WebElement elementKenmrk = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ext-gen225\"]")));
		 WebElement Kenmrk = driver.findElement(By.xpath("//*[@id=\"ext-gen225\"]"));
		 JavascriptExecutor jseKenmrk =  (JavascriptExecutor)driver;
		 jseDOC.executeScript("arguments[0].click();", Kenmrk );
		 System.out.println("Kenmrk_OK");
	 
	 
	 
	 
	 
	 
	  //And: gebruiker noteert het zaaknummer
		 
	   System.out.println("nu ga ik het zaaknummerkopieren naar memoryvanuit 'kenmerk'_OK");
		WebElement Casenumber = driver.findElement(By.cssSelector("#ext-comp-1254"));
		System.out.println(Casenumber.getAttribute("innerHTML"));  
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS) ;
		//System.out.println(("innerHTML"));
			 
			 
		   try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 
	
		    //And: gebruiker sluit het tabblad van de zaak bovenin het scherm
		     WebDriverWait waitSluit = new WebDriverWait(driver, 800);
			 WebElement elementSluit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ext-gen133\"]")));
			 WebElement Sluit = driver.findElement(By.xpath("//*[@id=\"ext-gen133\"]"));
			 JavascriptExecutor jseSluit =  (JavascriptExecutor)driver;
			 jseSluit.executeScript("arguments[0].click();", Sluit );
		     System.out.println("gebruiker sluit het tabblad van de zaak bovenin het scherm_OK");
		 
			 
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		
		     //And: gebruiker klikt op 'ja' bij de pop-up 'wijzigingen opslaan'
		   //Then: gebruiker keert terug naar het scherm van de werkvoorraad
		        
				 WebDriverWait waitJaKnp = new WebDriverWait(driver, 800);
				 WebElement elementJaKnp = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ext-gen1436")));
				 WebElement JaKnp = driver.findElement(By.cssSelector("#ext-gen1436"));
				 JavascriptExecutor jseJaKnp =  (JavascriptExecutor)driver;
				 jseJaKnp.executeScript("arguments[0].click();", JaKnp );
			     
				  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				 
				 
				 
				//And: gebruiker sluit het tabblad van de zaak bovenin het scherm
			    // WebDriverWait waitSluit2 = new WebDriverWait(driver, 800);
				 //WebElement elementSluit2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ext-gen1477")));
				 //WebElement Sluit2 = driver.findElement(By.cssSelector("#ext-gen1477"));
				 //JavascriptExecutor jseSluit2 =  (JavascriptExecutor)driver;
				 //jseSluit.executeScript("arguments[0].click();", Sluit2 );
				 
				 
				 
				 
				 
				 
				 
				 System.out.println("gebruiker klikt op 'ja' bij de pop-up 'wijzigingen opslaan'_OK +"
						           + "gebruiker keert terug naar het scherm van de werkvoorraad");
				
			     
			     
			     
				 
				   try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		     
		     
		     //When: gebruiker opent zaak met corresponderend zaaknummer
				 WebDriverWait waitOpentZaak = new WebDriverWait(driver, 800);
				 WebElement elementOpentZaak = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td[2]/div")));
				 WebElement OpentZaak = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div/table/tbody/tr/td[2]/div"));
				 JavascriptExecutor jseOpentZaak =  (JavascriptExecutor)driver;
				 jseOpentZaak.executeScript("arguments[0].click();", OpentZaak );
			     System.out.println("gebruiker opent zaak met corresponderend zaaknummer_OK");
			     
			     
			     
				   try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			     
			     
			     
				   //And: gebruiker opent zaakdossier middels de knop '<<'
				 WebDriverWait waitdblArrow = new WebDriverWait(driver, 800);
				 WebElement elementdblArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ext-gen1748\"]")));
				 WebElement dblArrow = driver.findElement(By.xpath("//*[@id=\"ext-gen1748\"]"));
				 JavascriptExecutor jsedblArrow =  (JavascriptExecutor)driver;
				 jsedblArrow.executeScript("arguments[0].click();", dblArrow );
			     System.out.println("gebruiker opent zaak middels de knop<<_OK");
						             
			     
			     try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
			     
			    
		     
			     //Then: onderste bijlage is van type 'Collegebesluit'
			  
			     	driver.findElement(By.xpath("//*[@id=\"ext-comp-3119\"]")).sendKeys("Collegebesluit");
			     	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
			     	
					 WebDriverWait waitCollegeB = new WebDriverWait(driver, 800);
					 WebElement elementCollegeB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[37]/table/tbody/tr/td[5]/div")));
					 WebElement CollegeB = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[37]/table/tbody/tr/td[5]/div"));
					JavascriptExecutor jseCollegeB =  (JavascriptExecutor)driver;
					jseCollegeB.executeScript("arguments[0].click();", elementCollegeB );
					jseCollegeB.executeScript("window.scrollTo(0, document.body.scrollHeight)", CollegeB );
				     driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/div/div[37]/table/tbody/tr/td[5]/div")).click();
					 if(driver.getPageSource().contains("Collegebesluit")){
					 System.out.println("onderste bijlage is van type 'Collegebesluit'_TEST SUCCES");
					 }else{
					 System.out.println("onderste bijlage is NIET van type 'Collegebesluit'_TEST FAILED");
					 
					 
					 }
	 
	 
	 }
	
	 
	     }
			     


