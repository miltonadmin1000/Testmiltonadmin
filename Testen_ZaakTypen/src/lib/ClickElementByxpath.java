	package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class ClickElementByxpath {

	public static void clickByxpath(WebDriver ldriver, String xpath )
	{

	Actions act = new Actions(ldriver);
	act.moveToElement(ldriver.findElement(By.xpath(xpath))).click().build().perform();
	
	
	}}
	