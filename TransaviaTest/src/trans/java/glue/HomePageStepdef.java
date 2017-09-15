package trans.java.glue;

import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import trans.java.framework.WebDriverFactory;
import trans.java.framework.WebDriverHelper;
import trans.java.po.HomePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepdef extends WebDriverFactory {
	private WebDriver driver;

	private HomePage homepage;
	Calendar calendar = Calendar.getInstance();
	private Scenario scenario;
	WebDriverHelper wd = new WebDriverHelper(driver, scenario);

	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;

	}

	@After
	public void teardown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Given("^I am on the Transavia homepage$")
	public void i_am_on_the_Transavia_homepage() throws Throwable {
		this.driver = SharedDriver();
		homepage = new HomePage(driver, scenario);
		homepage.openApplication();
	}

	@When("^I enter Departure station as \"(.*?)\"$")
	public void strFromStation(String strFromStation) throws Throwable {
		homepage.enterFromValue(strFromStation);
	}

	@When("^I enter Arrival station as \"(.*?)\"$")
	public void i_enter_Arrival_station_as(String strToStation)
			throws Throwable {
		homepage.enterToValue(strToStation);
	}

	@When("^I select Depart Date as \"(.*?)\"$")
	public void i_select_Depart_Date_as(String departureDate) throws Throwable {
		homepage.enterDepartureDate(departureDate);
	}

	@When("^I update \"(.*?)\" Adult \"(.*?)\" Children \"(.*?)\" Babies$")
	public void i_update_Adult_Children_Babies(String adult, String children,
			String babies) throws Throwable {
		homepage.updatePassenger(adult, children, babies);
	}

	@When("^I select option Show prices in Flying Blue Miles$")
	public void i_select_option_Show_prices_in_Flying_Blue_Miles()
			throws Throwable {
		homepage.clickShowPrices();
	}

	@When("^I click on Search button$")
	public void i_click_on_Search_button() throws Throwable {
		homepage.clickSearch();
	}

	@Then("^I should see Book a Flight Page with flight options$")
	public void i_should_see_Book_a_Flight_Page_with_flight_options()
			throws Throwable {
		homepage.verifyBookAFlightPage();
	}

	@Then("^I verify the hearder links$")
	public void i_verify_the_hearder_links() throws Throwable {
		homepage.verifyHeaderLinks();
	}

	@When("^I scroll down$")
	public void i_scroll_down() throws Throwable {
		homepage.scrollDown();
	}

	@Then("^I should see Manage your booking pannel$")
	public void i_should_see_Manage_your_booking_pannel() throws Throwable {
		homepage.verifyManageYourBookingPanel();
	}

	@Then("^I should see Online Check In pannel$")
	public void i_should_see_Online_Check_In_pannel() throws Throwable {
		homepage.verifyOnlineCheckInPannel();
	}

	@Then("^I should see our top destinations$")
	public void i_should_see_our_top_destinations() throws Throwable {
		homepage.verifyTopDestinations();
	}

	@Then("^I should see view all our destinations$")
	public void i_should_see_view_all_our_destinations() throws Throwable {

		homepage.verifyAllOurDestinations();
	}

	@Then("^I see (\\d+) options under have a carefree trip$")
	public void i_see_options_under_have_a_carefree_trip(int arg1)
			throws Throwable {
		homepage.verifyCareFreeTrip();
	}

	@Then("^I should see option for Newsletter subscription$")
	public void i_should_see_option_for_Newsletter_subscription() {
		homepage.verifyNewsSub();
	}

	@Then("^I should see Can we help you with social media icons$")
	public void i_should_see_Can_we_help_you_with_social_media_icons()
			throws Throwable {
		homepage.verifySocialMedia();
	}

	@Then("^I verify the footer options$")
	public void i_verify_the_footer_options() throws Throwable {
		homepage.verifyFooter();
	}

}
