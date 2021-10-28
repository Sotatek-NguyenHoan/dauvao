package test.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.Atribute.Atribute;
import test.CommonPath.EbayPath;

public class Base {
	WebDriver driver;
	public void click(WebDriver driver, By by) {
		driver.findElement(by).click();
	}
	public void sendKey(WebDriver driver, By by, String text) {
		driver.findElement(by).sendKeys(text);
	}
	public void clear(WebDriver driver, By by) {
		driver.findElement(by).clear();
	}

	public String getText(WebDriver driver, By by) {
		return driver.findElement(by).getText();
	}

	public void implicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public List<Atribute> sort(List<Atribute> atributelist)
	{
		Atribute temp=new Atribute();
		for(int i=0; i<atributelist.size()-1; i++){
			for (int j=i+1; j<atributelist.size(); j++){

				double a=Double.parseDouble(atributelist.get(i).getProductPrice());
				double b=Double.parseDouble(atributelist.get(j).getProductPrice());
				if(a > b){
					temp=atributelist.get(j);
					atributelist.set(j,atributelist.get(i));
					atributelist.set(i,temp);
				}
			}
		}
		return atributelist;
	}
}
