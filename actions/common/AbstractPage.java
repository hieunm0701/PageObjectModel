package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AbstractPage {
	WebDriver driver;

	public void openAnyUrl() {

	}

	/**
	 * Get title of current page
	 * 
	 * @return String title
	 */
	public String getTitle() {
		String title;
		title = driver.getTitle();
		return title;
	}

	/**
	 * Get url of current Page
	 * 
	 * @return String url
	 */
	public String getCurrentUrl() {
		String currentUrl;
		currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * Get page source of current page
	 * 
	 * @return String source of current page
	 */
	public String getPageSource() {
		String pageSource;
		pageSource = driver.getPageSource();
		return pageSource;
	}

	/**
	 * Go back to previous page
	 */
	public void back() {
		driver.navigate().back();
	}

	/**
	 * Go forward page
	 */
	public void forward() {
		driver.navigate().forward();
	}

	/**
	 * Refresh page
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * Get the web element of page from By
	 * @param by
	 * @return
	 * 		Web Element
	 */
	public WebElement getWebElement(By by) {
		try {
			return driver.findElement(by);
		} catch (NoSuchElementException e) {
			throw (e);
		}
	}

	/**
	 * Click to target Web Element
	 * @param by
	 * 		By of Web Element
	 */
	public void clickToElement(By by) {
		getWebElement(by).click();
	}

	/**
	 * Send string into element 
	 * @param by
	 * 		By of Web Element
	 * @param key
	 * 		String of key to send
	 */
	public void sendkeyToElement(By by, String key) {
		getWebElement(by).sendKeys(key);
	}
	/**
	 * Send string into element 
	 * @param by
	 * 		By of Web Element
	 * @param key
	 * 		Key to send
	 */
	public void sendkeyToElement(By by, Keys key) {
		getWebElement(by).sendKeys(key);
	}
	public void selectItemInDropdownListByText(By by, String value) {
		Select select = new Select(getWebElement(by));
		select.selectByVisibleText(value);
	}

	public void getFirstItemSelected() {

	}

	public void getAttributeValue() {

	}

	public void getTextElement() {

	}

	public void getSizeElements() {

	}

	public void checkTheCheckbox() {

	}

	public void uncheckTheCheckbox() {

	}

	public void isControlDisplayed() {

	}

	public void isControlSelected() {

	}

	public void isControlEnabled() {

	}

	public void acceptAlert() {

	}

	public void cancelAlert() {

	}

	public void getTextAlert() {

	}

	public void sendkeyToAlert() {

	}

	public void switchWindowByID() {

	}

	public void switchWindowByTitle() {

	}

	public void closeAllWindowsWithoutParent() {

	}

	public void switchToIframe() {

	}

	public void doubleClickElement() {

	}

	public void mouseHoverElement() {

	}

	public void rightClick() {

	}

	public void dragAndDrop() {

	}

	public void keyPress() {

	}

	public void uploadBySendkeys() {

	}

	public void uploadByRobot() {

	}

	public void uploadByAutoIT() {

	}

	public void executeJavascript() {

	}

	public void executeJavascriptToBrowser() {

	}

	public void executeJavascriptToElement() {

	}

	public void scrollToBottomPageByJS() {

	}

	public void scrollToElementByJS() {

	}

	public void hightlightElementByJS() {

	}

	public void removeAttributeOfElementByJS() {

	}

	public void checkAnyImageLoadedByJS() {

	}

	public void waitForControlPrecence() {

	}

	public void waitForControlVisible() {

	}

	public void waitForControlClickable() {

	}

	public void waitForControlNotVisible() {

	}

	public void waitForAlertPrecence() {

	}
}
