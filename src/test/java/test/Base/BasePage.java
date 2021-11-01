package test.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	public void click(WebElement element) {
		element.click();
	}
	public void sendKey( WebElement element, String text) {element.sendKeys(text);
	}
	public void clear(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {
		return element.getText();
	}


	private WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

}
