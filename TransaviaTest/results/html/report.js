$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Reg_HomePage.feature");
formatter.feature({
  "line": 2,
  "name": "Regression testing of Home Page",
  "description": "",
  "id": "regression-testing-of-home-page",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@HomePage"
    }
  ]
});
formatter.before({
  "duration": 13284832,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Search flight for one way trip",
  "description": "",
  "id": "regression-testing-of-home-page;search-flight-for-one-way-trip",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@REG_HOMEPAGE_TC01"
    },
    {
      "line": 4,
      "name": "@Priority1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I am on the Transavia homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I enter Departure station as \"Groningen, Netherlands\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I enter Arrival station as \"Almeria, Spain\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I select Depart Date as \"17 Sep 2017\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I update \"2\" Adult \"2\" Children \"1\" Babies",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I select option Show prices in Flying Blue Miles",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on Search button",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I should see Book a Flight Page with flight options",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepdef.i_am_on_the_Transavia_homepage()"
});
formatter.write("Yes, I understand: is clicked ");
formatter.write("Open Application");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 14926819917,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Groningen, Netherlands",
      "offset": 30
    }
  ],
  "location": "HomePageStepdef.strFromStation(String)"
});
formatter.write("Groningen, Netherlands entered successfully on Departure Station");
formatter.embedding("image/png", "embedded1.png");
formatter.result({
  "duration": 1570094033,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Almeria, Spain",
      "offset": 28
    }
  ],
  "location": "HomePageStepdef.i_enter_Arrival_station_as(String)"
});
formatter.write("Almeria, Spain entered successfully on Arrival Station");
formatter.embedding("image/png", "embedded2.png");
formatter.result({
  "duration": 1281647624,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "17 Sep 2017",
      "offset": 25
    }
  ],
  "location": "HomePageStepdef.i_select_Depart_Date_as(String)"
});
formatter.write("Depart icon Calendar: is clicked ");
formatter.write("Date17\u0027 button clicked");
formatter.result({
  "duration": 11000945466,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 10
    },
    {
      "val": "2",
      "offset": 20
    },
    {
      "val": "1",
      "offset": 33
    }
  ],
  "location": "HomePageStepdef.i_update_Adult_Children_Babies(String,String,String)"
});
formatter.write("Booking Passenger Input: is clicked ");
formatter.write("2 entered successfully on Adult Count");
formatter.embedding("image/png", "embedded3.png");
formatter.write("2 entered successfully on Children Count");
formatter.embedding("image/png", "embedded4.png");
formatter.write("2 entered successfully on Babies Count");
formatter.embedding("image/png", "embedded5.png");
formatter.write("Save: is clicked ");
formatter.result({
  "duration": 3613630779,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_select_option_Show_prices_in_Flying_Blue_Miles()"
});
formatter.write("Show prices in Flying Blue Miles\u0027 button clicked");
formatter.result({
  "duration": 178903295,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_click_on_Search_button()"
});
formatter.write("Show prices in Flying Blue Miles\u0027 button clicked");
formatter.result({
  "duration": 3395413340,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_should_see_Book_a_Flight_Page_with_flight_options()"
});
formatter.write("Book a flight: is displayed as expected");
formatter.embedding("image/png", "embedded6.png");
formatter.result({
  "duration": 539936305,
  "status": "passed"
});
formatter.after({
  "duration": 1242779044,
  "status": "passed"
});
formatter.before({
  "duration": 353795,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verify different options displayed in home page",
  "description": "",
  "id": "regression-testing-of-home-page;verify-different-options-displayed-in-home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@REG_HOMEPAGE_TC02"
    },
    {
      "line": 15,
      "name": "@Priority1"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "I am on the Transavia homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "I verify the hearder links",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "I scroll down",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I should see Manage your booking pannel",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I should see Online Check In pannel",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I scroll down",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I should see our top destinations",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "I scroll down",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "I should see view all our destinations",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "I scroll down",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I see 3 options under have a carefree trip",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "I scroll down",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I should see option for Newsletter subscription",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "I should see Can we help you with social media icons",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "I verify the footer options",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageStepdef.i_am_on_the_Transavia_homepage()"
});
formatter.write("Yes, I understand: is clicked ");
formatter.write("Open Application");
formatter.embedding("image/png", "embedded7.png");
formatter.result({
  "duration": 13757661690,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_verify_the_hearder_links()"
});
formatter.write("Plan And Book: is displayed as expected");
formatter.embedding("image/png", "embedded8.png");
formatter.write("Manage Your Booking: is displayed as expected");
formatter.embedding("image/png", "embedded9.png");
formatter.write("Service: is displayed as expected");
formatter.embedding("image/png", "embedded10.png");
formatter.write("Flight status: is displayed as expected");
formatter.embedding("image/png", "embedded11.png");
formatter.write("Online Check in: is displayed as expected");
formatter.embedding("image/png", "embedded12.png");
formatter.write("Get inspired: is displayed as expected");
formatter.embedding("image/png", "embedded13.png");
formatter.write("Destination: is displayed as expected");
formatter.embedding("image/png", "embedded14.png");
formatter.write("Login: is displayed as expected");
formatter.embedding("image/png", "embedded15.png");
formatter.write("Create Account: is displayed as expected");
formatter.embedding("image/png", "embedded16.png");
formatter.result({
  "duration": 6381963685,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_scroll_down()"
});
formatter.result({
  "duration": 11696376,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_should_see_Manage_your_booking_pannel()"
});
formatter.write("Manage your booking: is displayed as expected");
formatter.embedding("image/png", "embedded17.png");
formatter.result({
  "duration": 453477428,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_should_see_Online_Check_In_pannel()"
});
formatter.write("Online check-in: is not displayed as expected");
formatter.embedding("image/png", "embedded18.png");
formatter.result({
  "duration": 10402529697,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_scroll_down()"
});
formatter.result({
  "duration": 11127044,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_should_see_our_top_destinations()"
});
formatter.write("Our top destinations: is displayed as expected");
formatter.embedding("image/png", "embedded19.png");
formatter.result({
  "duration": 642300877,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_scroll_down()"
});
formatter.result({
  "duration": 8509803,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_should_see_view_all_our_destinations()"
});
formatter.write("View all of our destinations: is displayed as expected");
formatter.embedding("image/png", "embedded20.png");
formatter.result({
  "duration": 506698867,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_scroll_down()"
});
formatter.result({
  "duration": 9716692,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 6
    }
  ],
  "location": "HomePageStepdef.i_see_options_under_have_a_carefree_trip(int)"
});
formatter.write("Have a carefree trip: is displayed as expected");
formatter.embedding("image/png", "embedded21.png");
formatter.result({
  "duration": 435998370,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_scroll_down()"
});
formatter.result({
  "duration": 6291036,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_should_see_option_for_Newsletter_subscription()"
});
formatter.write("Newsletter subscription: is displayed as expected");
formatter.embedding("image/png", "embedded22.png");
formatter.result({
  "duration": 424759030,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_should_see_Can_we_help_you_with_social_media_icons()"
});
formatter.write("Can we help you: is displayed as expected");
formatter.embedding("image/png", "embedded23.png");
formatter.result({
  "duration": 397015682,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepdef.i_verify_the_footer_options()"
});
formatter.write("About Transavia: is displayed as expected");
formatter.embedding("image/png", "embedded24.png");
formatter.write("Self-service: is displayed as expected");
formatter.embedding("image/png", "embedded25.png");
formatter.write("Get inspired: is displayed as expected");
formatter.embedding("image/png", "embedded26.png");
formatter.result({
  "duration": 1229096946,
  "status": "passed"
});
formatter.after({
  "duration": 1232166996,
  "status": "passed"
});
});