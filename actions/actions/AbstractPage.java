package actions;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AbstractPage {
	WebDriver driver;
	
	
	/**
	 * Compare exactly 2 strings 
	 * 
	 * @param txt1 
	 * 			String need to be compare
	 * @param txt2 
	 * 			String used to be compared with
	 */
	public void compareText(String txt1, String txt2) {
		Assert.assertEquals(txt1, txt2);
	}

	/**
	 * Verify the text of Web Element
	 * @param by
	 * 			By of interact WebElement
	 * @param expectation
	 * 			Expect String of WebElement
	 */
	public void verifyText(By by, String expectation) {
		compareText(driver.findElement(by).getText(), expectation);
	}

	/**
	 * Verify Attribute of Web Element
	 * @param by
	 * 			By of interact WebElement
	 * @param attribute
	 * 			Name of attribute 
	 * @param expectation
	 * 			Expect attribute value of Web Element 
	 */
	public void verifyAttribute(By by, String attribute, String expectation) {
		compareText(driver.findElement(by).getAttribute(attribute), expectation);
	}

	/**
	 * Verify URl of current page
	 * @param expectation
	 * 		Expect url
	 */
	public void verifyUrl(String expectation) {
		compareText(driver.getCurrentUrl(), expectation);
	}

	/**
	 * Verify title of current page
	 * @param expectation
	 * 		Expect title
	 */
	public void verifyTitle(String expectation) {
		compareText(driver.getTitle(), expectation);
	}

	/**
	 * Click web element
	 * @param by
	 * 		By of interact WebElement 
	 */
	public void click(By by) {
		driver.findElement(by).click();
	}

	public void jsExecute(String jsFunction, Object obj) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsFunction, obj);
	}

	public void clickByJS(By by) {
		jsExecute("arguments[0].click();", driver.findElement(by));
	}

	public void openUrl(String url) {
		driver.get(url);
	}

	public boolean isSelected(By by) {
		return driver.findElement(by).isSelected();
	}

	public boolean isDisplayed(By by) {
		return driver.findElement(by).isDisplayed();
	}

	public void verifySelected(By by) {
		Assert.assertEquals(isSelected(by), true);
	}

	public void verifyDeselected(By by) {
		Assert.assertEquals(isSelected(by), false);
	}

	public void mouseOver(By by) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(by)).perform();
	}

	public void clickAndHold(By by) {
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(by)).perform();
	}

	public void clickAndHoldAndMove(List<By> by) {
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(by.get(0)));
		for (int i = 1; i < by.size(); i++) {
			action.moveToElement(driver.findElement(by.get(1))).perform();
		}
	}

	public void doubleClick(By by) {
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(by)).perform();
	}

	public void rightClick(By by) {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(by)).perform();
	}

	public void dragAdnDrop(By source, By target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(source), driver.findElement(target)).perform();
	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void switchToNewWindow() {
		String OldWindows = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(OldWindows)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void closeOtherWindows() {
		String OldWindows = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(OldWindows)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(OldWindows);
	}

	public void switchThenCloseOtherWindows() {
		String OldWindows = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(OldWindows)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
		OldWindows = driver.getWindowHandle();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(OldWindows)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(OldWindows);
	}
}
