package MethodLoginMilton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AcceptatieLoginTester01 {
	  public static  WebDriver driver;
		
			public static void InloggenAcceptatie (){
		
				
				
				//Java kiest Firefox alls webdriver		  
				  System.setProperty("webdriver.gecko.driver","G:\\Desktop\\automation\\geckodriver-v0.24.0-win64\\geckodriver.exe");
				  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				  
				  //Selenium driver kiest voor firefox browser
				  WebDriver driver = new FirefoxDriver();
				  driver.manage().window().maximize();
				  
				  
				  //Acceptatie omgeving wordt geopend
				  driver.get("https://zaken.acceptatie.amstelveen.nl/login");
				  	  
				  
				  //Inloggen in acceptatie omgeving
				  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tst01");
				  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("tester01");
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
			
					}
			
	}

		


