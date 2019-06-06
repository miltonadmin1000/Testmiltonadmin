package InloggenAccept;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


		public class InloggenAcceptatieOmgeving_Milton {
			
			public static WebDriver driver;
			
				public void LoginOnpage() {
				 //Java kiest Firefox alls webdriver		  
				  System.setProperty("webdriver.gecko.driver","G:\\Desktop\\automation\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				  
				  //Selenium driver kiest voor firefox browser
				  WebDriver driver = new FirefoxDriver();
				  driver.manage().window().maximize();
				  
				  
				  //Acceptatie omgeving wordt geopend
				  driver.get("https://zaken.acceptatie.amstelveen.nl/login");
		 		  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("G5888");
		    	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Bainats@ams1000");
		    	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		          driver.findElement(By.xpath("/html/body/div/form/button")).click();
		    	   System.out.println("gebruiker is ingelogd in de acceptatie omgeving");
		    	   //driver checkt als gebruiker is gauthoriseerd		  
				   if(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[1]/div[2]")) != null){
					  System.out.println("Webpagina is OK");
				  }
				  else{
					  System.out.println("Webpagina is niet OK");
				  }
		   
				}
				}
			
				
		
				
				
				
				
				
		
	
