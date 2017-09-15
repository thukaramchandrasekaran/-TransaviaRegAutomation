package trans.java.po;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import trans.java.framework.WebDriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage {
	private WebDriver driver;
	private Scenario scenario;
	WebDriverHelper wd;

	By btnYesIUnder = By.xpath("(//button[.='Yes, I understand'])[1]");
	By edtDepatrureSta = By.id("routeSelection_DepartureStation-input");
	By edtArrivalSta = By.id("routeSelection_ArrivalStation-input");
	By calendepartDate = By
			.id("dateSelection_OutboundDate-datepicker-input-input");

	By iconCalendarDepart = By
			.xpath("(//span[contains(@class,'datepicker-trigger icon-font icon-calendar')])[1]");
	By btnBookingPass = By.id("booking-passengers-input");
	By chkShowPrices = By
			.xpath("//label[.='Show prices in Flying Blue Miles']");

	By edtAdultsCnt = By
			.xpath("//div[contains(@class,'selectfield adults')]//input");
	By edtChildrenCnt = By
			.xpath("//div[contains(@class,'selectfield children')]//input");
	By edtBabiesCnt = By
			.xpath("//div[contains(@class,'selectfield babies')]//input");

	By btnSearch = By
			.xpath("(//div[contains(@class,'panel_section-button-container')])[2]//button");
	By btnSave = By.xpath("//button[.='Save']");

	By lblTitle = By.xpath("//h1[.='Book a flight']");

	// Page verification objects
	By lnkPlanABook = By
			.xpath("(//a[contains(@class,'h5 primary-navigation_link')])[1]");
	By lnkManageBook = By
			.xpath("(//a[contains(@class,'h5 primary-navigation_link')])[2]");
	By lnkServices = By
			.xpath("(//a[contains(@class,'h5 primary-navigation_link')])[3]");

	By lnkFlightStatus = By.xpath("(//a[contains(text(),'Flight status')])[1]");
	By lnkOnlineChkIn = By
			.xpath("(//a[contains(text(),'Online check-in')])[1]");
	By lnkGetIns = By.xpath("(//a[contains(text(),'Get inspired!')])[1]");
	By lnkDestina = By.xpath("(//a[contains(text(),'Destinations')])[1]");
	By lnkLogin = By.xpath("(//a[contains(text(),'Log in')])[1]");
	By lnkCreateAcc = By.xpath("(//a[contains(text(),'Create account')])[1]");

	By pannelManageBooking = By
			.xpath("//a[contains(text(),'Go to My Transavia')]");
	By pannelOnlineChkIn = By
			.xpath("//a[contains(text(),'I want to check in')");
	By lblTopDestination = By
			.xpath("//h2[contains(text(),'Our top destinations:')]");
	By lblAllDesti = By
			.xpath("//a[contains(text(),'View all of our destinations')]");
	By lblCareFreeTrip = By
			.xpath("//h2[contains(text(),'Have a carefree trip!')]");

	By lblNewsSUb = By
			.xpath("//h2[contains(text(),'Newsletter subscription')]");
	By lblCanweHelp = By.xpath("//h2[contains(text(),'Can we help you?')]");
	By lblAbtTrans = By.xpath("//h3[contains(text(),'About Transavia')]");
	By lblSelfService = By.xpath("//h3[contains(text(),'Self-service')]");
	By lblGetIns = By.xpath("//h3[contains(text(),'Get inspired')]");

	public HomePage(WebDriver driver, Scenario scenario) {
		this.driver = driver;
		this.scenario = scenario;
		wd = new WebDriverHelper(driver, scenario);
	}

	public void openApplication() {
		String strApplicaionUrl = "https://www.transavia.com/en-NL/home/";
		driver.manage().window().maximize();
		driver.get(strApplicaionUrl);

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (wd.isElementDisplayed(driver, btnYesIUnder, "Yes, I understand")) {
			wd.clickButton(driver, btnYesIUnder, "Yes, I understand");
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		scenario.write("Open Application");
		embedScreenShot(scenario);
	}

	private void embedScreenShot(Scenario scenario) {
		byte[] screenShot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		try {
			scenario.embed(screenShot, "image/png");
			// FileUtils.copyFile(screenShot, new File(fileName + ".png"));
		} catch (Exception ioe) {
			throw new RuntimeException(ioe.getMessage(), ioe);
		}

	}

	public void enterFromValue(String strFromStation) {
		wd.sendText(driver, edtDepatrureSta, strFromStation,
				"Departure Station");
		driver.findElement(edtDepatrureSta).sendKeys(Keys.TAB);
	}

	public void enterToValue(String strToStation) {
		wd.sendText(driver, edtArrivalSta, strToStation, "Arrival Station");
		driver.findElement(edtArrivalSta).sendKeys(Keys.TAB);
	}

	public void enterDepartureDate(String departureDate)
			throws InterruptedException {

		String strDate = departureDate.split(" ")[0].trim();
		String calObj1 = "(//table[@class='ui-datepicker-calendar']//a[.='"
				+ strDate + "'])[1]";
		String calObj2 = "(//table[@class='ui-datepicker-calendar']//a[.='"
				+ strDate + "'])[2]";

		wd.clickButton(driver, iconCalendarDepart, "Depart icon Calendar");

		if (wd.isElementDisplayed(driver, By.xpath(calObj1), "")) {
			wd.clickButtonJS(driver, By.xpath(calObj1), "Date" + strDate);
		} else if (wd.isElementDisplayed(driver, By.xpath(calObj2), "")) {
			wd.clickButtonJS(driver, By.xpath(calObj2), "Date" + strDate);
		}

	}

	public void updatePassenger(String adult, String children, String babies) {

		wd.scrollToView(driver, edtArrivalSta);

		wd.clickButton(driver, btnBookingPass, "Booking Passenger Input");

		wd.sendText(driver, edtAdultsCnt, adult, "Adult Count");
		wd.sendText(driver, edtChildrenCnt, adult, "Children Count");
		wd.sendText(driver, edtBabiesCnt, adult, "Babies Count");

		wd.clickButton(driver, btnSave, "Save");
	}

	public void clickShowPrices() {
		wd.scrollToView(driver, edtArrivalSta);

		wd.clickButtonJS(driver, chkShowPrices,
				"Show prices in Flying Blue Miles");
	}

	public void clickSearch() {
		wd.scrollToView(driver, chkShowPrices);

		wd.clickButtonJS(driver, btnSearch, "Show prices in Flying Blue Miles");
	}

	public void verifyBookAFlightPage() {
		wd.isElementDisplayedWithReport(driver, lblTitle, "Book a flight");
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String str = "window.scrollBy(" + 200 + "," + 200 + ")";
		jse.executeScript(str, "");
	}

	public void verifyHeaderLinks() {

		wd.isElementDisplayedWithReport(driver, lnkPlanABook, "Plan And Book");
		wd.isElementDisplayedWithReport(driver, lnkManageBook,
				"Manage Your Booking");
		wd.isElementDisplayedWithReport(driver, lnkServices, "Service");

		wd.isElementDisplayedWithReport(driver, lnkFlightStatus,
				"Flight status");
		wd.isElementDisplayedWithReport(driver, lnkOnlineChkIn,
				"Online Check in");
		wd.isElementDisplayedWithReport(driver, lnkGetIns, "Get inspired");
		wd.isElementDisplayedWithReport(driver, lnkDestina, "Destination");
		wd.isElementDisplayedWithReport(driver, lnkLogin, "Login");
		wd.isElementDisplayedWithReport(driver, lnkCreateAcc, "Create Account");
	}

	public void verifyManageYourBookingPanel() {

		wd.scrollDown(200, 1000);
		wd.isElementDisplayedWithReport(driver, pannelManageBooking,
				"Manage your booking");
	}

	public void verifyOnlineCheckInPannel() {

		wd.isElementDisplayedWithReport(driver, pannelOnlineChkIn,
				"Online check-in");

	}

	public void verifyTopDestinations() {

		wd.scrollDown(200, 400);
		wd.isElementDisplayedWithReport(driver, lblTopDestination,
				"Our top destinations");

	}

	public void verifyAllOurDestinations() {

		wd.scrollDown(200, 1000);
		wd.isElementDisplayedWithReport(driver, lblAllDesti,
				"View all of our destinations");
	}

	public void verifyCareFreeTrip() {

		wd.scrollDown(200, 500);
		wd.isElementDisplayedWithReport(driver, lblCareFreeTrip,
				"Have a carefree trip");
	}

	public void verifyNewsSub() {

		wd.scrollDown(200, 500);
		wd.isElementDisplayedWithReport(driver, lblNewsSUb,
				"Newsletter subscription");
	}

	public void verifySocialMedia() {

		wd.scrollDown(200, 500);
		wd.isElementDisplayedWithReport(driver, lblCanweHelp, "Can we help you");
	}

	public void verifyFooter() {

		wd.isElementDisplayedWithReport(driver, lblAbtTrans, "About Transavia");
		wd.isElementDisplayedWithReport(driver, lblSelfService, "Self-service");
		wd.isElementDisplayedWithReport(driver, lblGetIns, "Get inspired");

	}

}
