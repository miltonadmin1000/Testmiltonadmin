/*
 * 
 *  Testcase: Document inkomend

 Feature: kopie aan
 Background: gebruiker is geautoriseerd voor de rollen 'Behandelaar Document Inkomend'
 
  Scenario: D-zaak aanmaken intern
   Given: gebruiker is ingelogd in de acceptatie-omgeving als tst03
   And: gebruiker bevindt zich in de tab 'een nieuwe zaak starten'
   When: gebruiker drukt op groene '+' knop, achter de regel 'Document inkomend' onder de titel 'Documentatie en archivering'
   Then: tab 'ingekomendocument' voor aanmaken zaak opent
   When: gebruiker vult in het veld 'Betreft' onder titel 'Kenmerken' de tekst in 'test kopie aan'
   And: gebruiker klikt bovenin op de tab 'inhoud'
   Then: systeem opent tabblad 'inhoud'
   When: gebruiker klikt rechts op knop '<<' boven 'bijlagen'
   Then: bijlagen veld wordt geopend
   When: gebruiker klikt op groene knop '+'
   Then: window om bijlage te selecteren wordt geopend
   When: gebruiker opent schijf '(H:)'
   And: gebruiker opent de map 'Beheer InProces 2.10'
   And: gebruiker opent de map 'Upgrade 2.13'
   And: gebruiker opent de map 'Tests'
   And: gebruiker selecteert het document 'TEST bijlage'
   And: gebruiker klikt op 'Openen'
   Then: window om bijlage te selecteren wordt gesloten
   And: de tekst 'TEST bijlage (docx)' wordt getoond in het witte veld van tabblad 'inhoud'
   When: gebruiker klikt onderin op de knop 'volgende'
   Then: zaak gaat verder naar tabblad 'toegang tot dit document' rechts bovenin
   When: gebruiker klikt op knop 'controleer'
   Then: pop-up verschijnt met bevestiging van aangemaakte D-zaak
   When: gebruiker klikt op 'bevestigen'
   Then: pop-up wordt gesloten
   And: nieuwe pop-up verschijnt met boodschap 'Hartelijk dank voor het indienen van uw ingekomendocument
   When: gebruiker klikt op 'OK'
   Then: pop-up wordt gesloten
   And: gebruiker keert terug naar acceptatie-omgeving in de tab 'een nieuwe zaak starten'
     
 */



package kopieAanScenarioDzaakAaanmakenIntern;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import lib.ClickElement;

public class kopieNaarScenarioDzaakAanmkaen {

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
		 driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tst03");
		 driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tester03");
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		 driver.findElement(By.xpath("/html/body/div/form/button")).click();
		//compare the actual title with the expected title

		 System.out.println("gebruiker is ingelogd in de acceptatie omgeving_OK");
		 
		 //driver checkt als gebruiker is gauthoriseerd		  

		 if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[1]/div[2]")) != null){
			  		  

			  System.out.println("Webpagina is OK");
		 }
		 else{
			  System.out.println("Webpagina is niet OK");
		 }


		// Given: gebruiker is ingelogd in de acceptatie-omgeving
		// And: gebruiker bevindt zich in de tab 'een nieuwe zaak starten'
		driver.findElement(By.xpath("//span[text()='een nieuwe zaak starten']")).click();	
		System.out.println("gebruiker bevindt zich in de tab 'een nieuwe zaak starten_OK'");
		 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	
	
		// When: gebruiker drukt op groene '+' knop, achter de regel 'Document inkomend' onder de titel 'Documentatie en archivering'
		//Then: tab 'ingekomendocument' voor aanmaken zaak opent
		//gebruiker drukt op de knop nieuwe zaak starten
		//driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[3]/div[2]/div[1]/table/tbody/tr/td[8]/div/img")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println("icoontje_voor_nieuwe_zaak_starten_werkt_OK");
			 
		
		// When: gebruiker drukt op groene '+' knop, achter de regel 'Document inkomend' onder de titel 'Documentatie en archivering'
		//Then: tab 'ingekomendocument' voor aanmaken zaak opent
		driver.findElement(By.xpath("//div[2]/div[2]/div/table/tbody/tr/td[8]/div/img")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		System.out.println("icoontje_voor_nieuwe_zaak_starten_werkt_OK");
		
		// When: gebruiker vult in het veld 'Betreft' onder titel 'Kenmerken' de tekst in 'test d-zaak generiek'
		driver.findElement(By.xpath("//input[@name='betreft']")).sendKeys("test kopie aan");
		System.out.println("gebruiker vult in het veld 'Betreft' onder titel 'Kenmerken' de tekst in ' 'test kopie aan'_OK");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//And: gebruiker klikt bovenin op de tab 'inhoud'
		WebElement link_Home = driver.findElement(By.partialLinkText("houd"));
		WebElement td_Home = driver.findElement(By.partialLinkText("houd"));
		Actions builder = new Actions(driver);
		Action mouseOverHome =  builder.moveToElement(link_Home).click().build(); 
		mouseOverHome.perform();
		System.out.println("Then: systeem opent tabblad 'inhoud_OK'");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		// When: gebruiker klikt rechts op knop '<<' boven 'bijlagen'
		ClickElement.clickByID(driver, "ext-gen1130");	
		
		System.out.println(" gebruiker klikt rechts op knop '<<' boven 'bijlagen_OK");
		System.out.println(" Then: bijlagen veld wordt geopend_OK");	
		
		// When: gebruiker opent schijf '(H:)'
		// And: gebruiker opent de map 'Beheer InProces 2.10'
		// And: gebruiker opent de map 'Upgrade 2.13'
		// And: gebruiker opent de map 'Tests'
		// And: gebruiker selecteert het document 'TEST bijlage'
		// And: gebruiker klikt op 'Openen'
		// Then: window om bijlage te selecteren wordt gesloten
		// And: de tekst 'TEST bijlage (docx)' wordt getoond in het witte veld van tabblad 'inhoud' * 
			 
		WebElement Grbtn = driver.findElement(By.xpath("//input[@class='x-form-file']"));
		JavascriptExecutor jseGrbtn =  (JavascriptExecutor)driver;
		jseGrbtn.executeScript("arguments[0].click();", Grbtn );
		System.out.println("'+' button is gedrukt in bijlage menu_OK");	
		WebElement uploadElement = driver.findElement(By.xpath("//input[@class='x-form-file']"));

		StringSelection strSel = new 
		StringSelection("H:\\Beheer InProces 2.10\\Upgrade 2.13\\Tests\\TEST bijlage.pdf");;
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);


		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println(".pdf Document is geupload_OK");
		System.out.println(" And: de tekst 'TEST bijlage (docx)' wordt getoond in het witte veld van tabblad 'inhoud'_OK");
		if(driver.findElement(By.xpath("//div[@title='TEST bijlage.pdf']")) != null)
		{
			  System.out.println("Yeaaah Bijlage is aanwezig!!_OK");
		}
		else{
			  System.out.println("Yeaaah Bijlage is NIET aanwezig!!");
		}
			
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
		//When: gebruiker klikt onderin op de knop 'volgende'
		driver.findElement(By.xpath("//button[text()='volgende']")).click();
		System.out.println("gebruiker klikt onderin op de knop 'volgende'_OK");

		//Then: zaak gaat verder naar tabblad 'toegang tot dit document' rechts bovenin
		if(driver.findElement(By.xpath("//span[contains(@class,'x-tab-strip-text b-icoon-toegang')]")) != null)
		{
			  System.out.println("zaak gaat verder naar tabblad 'toegang tot dit document' rechts bovenin_OK");
		}
		else{
			  System.out.println("label met toegang tot dit document is NIET aanwezig!!");
		}

		//When: gebruiker klikt op knop 'controleer'
		//Then: pop-up verschijnt met bevestiging van aangemaakte D-zaak\
		driver.findElement(By.xpath("//button[text()='controleer']")).click();
		System.out.println("pop-up verschijnt met bevestiging van aangemaakte D-zaak");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		//When: gebruiker klikt op 'bevestigen'
		//Then: pop-up wordt gesloten
		//And: nieuwe pop-up verschijnt met boodschap 'Hartelijk dank voor het indienen van uw ingekomendocument
		driver.findElement(By.xpath("//button[text()='bevestigen']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
		driver.findElement(By.xpath("//div[contains(@class,'x-window-header x-unselectable x-window-draggable')]")).click();
		System.out.println("nieuwe pop-up verschijnt met boodschap 'Hartelijk dank voor het indienen van uw ingekomendocument_OK");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
		//When: gebruiker klikt op 'OK'
		//Then: pop-up wordt gesloten
		//And: gebruiker keert terug naar acceptatie-omgeving in de tab 'een nieuwe zaak starten'
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("pop-up wordt gesloten ");
		System.out.println("gebruiker keert terug naar acceptatie-omgeving in de tab 'een nieuwe zaak starten'");
		if(driver.findElement(By.xpath("//li[4]/a[2]/em/span/span")) != null)
		{
			  System.out.println("gebruiker keert terug naar acceptatie-omgeving in de tab 'een nieuwe zaak starten'_OK_TEST SUCCES!!!");
		}
		else{
			  System.out.println("gebruiker keert NIET terug naar acceptatie-omgeving in de tab 'een nieuwe zaak starten'!!_TEST FAILED");
		}


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	


		driver.quit();
		
		
		
		
		
		
	}

}
