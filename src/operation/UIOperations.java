package operation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperations {

	WebDriver driver;
	public UIOperations(WebDriver driver) {
		this.driver = driver;
	}
	//															fname				id				TestFirst	
	public void execute(Properties p, String operation, String objectName, String objectType, String value) throws Exception {
		
		switch (operation.toUpperCase()){
			case "SETTEXT":
				//driver.findElement(By.id("locator")).sendKeys(value);
				//driver.findElement(
				//										fname		id
				driver.findElement(this.getObject(p, objectName, objectType)).sendKeys(value);
				//driver.findElement(By.id("fname")).sendKeys(value from Excel);
				break;
			case "CLICK":
				driver.findElement(this.getObject(p, objectName, objectType)).click();
				break;
			case "GOTOURL":
				driver.get(p.getProperty(value));
				break;
			case "GETTEXT":
				driver.findElement(this.getObject(p, objectName, objectType)).getText();
				break;
			case "CLOSE":
				driver.close();
				break;
			default:
				break;
		}
	}
	//											fname				id
	private By getObject(Properties p, String ObjectName, String objectType) throws Exception {
		if(objectType.equalsIgnoreCase("ID")) {
			return By.id(p.getProperty(ObjectName));
		} else if(objectType.equalsIgnoreCase("NAME")) {
			return By.name(p.getProperty(ObjectName));
		} else if(objectType.equalsIgnoreCase("LINK")) {
			return By.linkText(p.getProperty(ObjectName));
		} else if(objectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(p.getProperty(ObjectName));
		} else if(objectType.equalsIgnoreCase("CSS")) {
			return By.cssSelector(p.getProperty(ObjectName));
		}
		else {
			throw new Exception("Exception");
		}
	}
}
