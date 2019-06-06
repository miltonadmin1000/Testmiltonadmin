/*Testcase: Document inkomend
 
 Feature: D-zaak generiek zaaktype
 Background: gebruiker is geautoriseerd voor de rol '
 
  Scenario: D-zaak registeren voor zaaktype Beleid
  
  Scenario: check fase behandelaar
  
  Scenario: document inkomend terugfaseren
  
  Scenario: check terugfasering
  
  Scenario: registrator doet herbeoordeling
  
  Scenario: check fase behandelaar
  
  Scenario: zaak afhandelen
 */


package documentInkomend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC_DocumentInkomendFeatureDZaakGenerriekeZaakType {

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
			  		  

			  System.out.println("Webpagina is OK");
		  }
		  else{
			  System.out.println("Webpagina is niet OK");
		  }

		  
		  //gebruiker drukt op de knop nieuwe zaak starten
		  	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[1]/div[1]/ul/li[4]/a[2]/em/span/span")).click();
		  	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		  	System.out.println("Icoontje_voor_nieuwe_zaak_starten_werkt_OK");
		
		
		
		
		
		
		
	}

}
