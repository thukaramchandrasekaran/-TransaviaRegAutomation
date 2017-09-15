package trans.java.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import cucumber.api.Scenario;

public class WebDriverHelper {
	WebDriver driver;
	Scenario scenario;

	public WebDriverHelper(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
	}

	/**
	 * To click button
	 */
	public void clickButton(WebDriver driver, By locator, String objName) {

		boolean blnClicked = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(locator));

		if (isElementDisplayed(driver, locator, objName)) {
			driver.findElement(locator).click();
			blnClicked = true;
		}

		if (blnClicked) {
			scenario.write(objName + ": is clicked ");
		} else {
			scenario.write(objName + ": is not clicked");
		}
	}

	/**
	 * To check element displayed without report
	 */
	public boolean isElementDisplayed(WebDriver driver, By locator,
			String objName) {
		boolean isDisplayed = false;
		try {
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isDisplayed = driver.findElement(locator).isDisplayed();

		} catch (StaleElementReferenceException stle) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.stop()");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isDisplayed = driver.findElement(locator).isDisplayed();

		} catch (Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}

	/**
	 * To check element displayed with report
	 */
	public void isElementDisplayedWithReport(WebDriver driver, By locator,
			String alt) {
		boolean isDisplayed = false;
		try {
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isDisplayed = driver.findElement(locator).isDisplayed();

		} catch (StaleElementReferenceException stle) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.stop()");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isDisplayed = driver.findElement(locator).isDisplayed();

		} catch (Exception e) {
			isDisplayed = false;
		}

		if (isDisplayed) {
			scenario.write(alt + ": is displayed as expected");
			embedScreenShot();
		} else {
			scenario.write(alt + ": is not displayed as expected");
			embedScreenShot();
		}
	}

	/**
	 * To send values to the text field
	 */
	public void sendText(WebDriver driver, By locator,
			CharSequence valuetoType, String objName) {
		boolean blnTextEntered = false;
		if (isElementDisplayed(driver, locator, objName)) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(valuetoType);
			blnTextEntered = true;
		}
		if (blnTextEntered) {
			scenario.write(valuetoType + " entered successfully on " + objName);
			embedScreenShot();
		} else {
			scenario.write(valuetoType + " is not entered on " + objName);
			embedScreenShot();
		}

	}

	/**
	 * To select value from drop down list
	 * 
	 * @return
	 */
	public void selectDropList(WebDriver driver, By element, String method,
			String value, String strField) {

		// To wait till element loaded
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean isDisplayed = false;

		if (method.contains("visible")) {
			try {
				isDisplayed = driver.findElement(element).isDisplayed();

				if (isDisplayed == true) {
					Select select = new Select(driver.findElement(element));
					select.selectByVisibleText(value);
					scenario.write("<b>'" + value
							+ "' </b> is selected from the list '" + strField
							+ "'");
				} else {
					scenario.write("<b>'" + value
							+ "' </b> is not selected from the list '"
							+ strField + "'");
				}

			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				driver.navigate().refresh();
				isDisplayed = driver.findElement(element).isDisplayed();
				if (isDisplayed == true) {
					Select select = new Select(driver.findElement(element));
					select.selectByVisibleText(value);
					scenario.write("<b>'" + value
							+ "' </b> is selected from the list '" + strField
							+ "'");
				} else {
					scenario.write("<b>'" + value
							+ "' </b> is not selected from the list '"
							+ strField + "'");
				}
			}
		}

		if (method.contains("value")) {
			try {
				isDisplayed = driver.findElement(element).isDisplayed();

				if (isDisplayed == true) {
					Select select = new Select(driver.findElement(element));
					select.selectByValue(value);
					scenario.write("<b>'" + value
							+ "' </b> is selected from the list '" + strField
							+ "'");
				} else {
					scenario.write("<b>'" + value
							+ "' </b> is not selected from the list '"
							+ strField + "'");
				}
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				driver.navigate().refresh();
				isDisplayed = driver.findElement(element).isDisplayed();
				if (isDisplayed == true) {
					Select select = new Select(driver.findElement(element));
					select.selectByValue(value);
					scenario.write("<b>'" + value
							+ "' </b> is selected from the list '" + strField
							+ "'");
				} else {
					scenario.write("<b>'" + value
							+ "' </b> is not selected from the list '"
							+ strField + "'");
				}
			}
		}

		if (method.contains("index")) {
			try {
				isDisplayed = driver.findElement(element).isDisplayed();

				if (isDisplayed == true) {
					Select select = new Select(driver.findElement(element));
					select.selectByIndex(Integer.parseInt(value));
					scenario.write("<b>'" + value
							+ "' </b> is selected from the list '" + strField
							+ "'");
				} else {
					scenario.write("<b>'" + value
							+ "' </b> is not selected from the list '"
							+ strField + "'");
				}

			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				driver.navigate().refresh();
				isDisplayed = driver.findElement(element).isDisplayed();
				if (isDisplayed == true) {
					Select select = new Select(driver.findElement(element));
					select.selectByIndex(Integer.parseInt(value));
					scenario.write("<b>'" + value
							+ "' </b> is selected from the list '" + strField
							+ "'");
				} else {
					scenario.write("<b>'" + value
							+ "' </b> is not selected from the list '"
							+ strField + "'");
				}
			}
		}

	}

	/**
	 * To take screenshot
	 */
	private void embedScreenShot() {
		byte[] screenShot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		try {
			scenario.embed(screenShot, "image/png");
			// FileUtils.copyFile(screenShot, new File(fileName + ".png"));
		} catch (Exception ioe) {
			throw new RuntimeException(ioe.getMessage(), ioe);
		}

	}

	/**
	 * To perform scrolling
	 */
	public void scrollToView(WebDriver driver, By locator) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",
					driver.findElement(locator));
		}

		catch (Exception e) {
			System.out.println("Unable to scroll to view");
		}

	}

	/**
	 * To click button using java script
	 */
	public void clickButtonJS(WebDriver driver, By locator, String objName) {

		boolean blnClicked = false;
		if (isElementDisplayed(driver, locator, objName)) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",
					driver.findElement(locator));
			blnClicked = true;
		}

		if (blnClicked) {

			scenario.write(objName + "' button clicked");
		} else {
			scenario.write("Unable to click on '" + objName + "' button ");
		}
	}

	public void scrollDown(int x, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String str = "window.scrollBy(" + x + "," + y + ")";
		jse.executeScript(str, "");
	}

	public void waitTime() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
