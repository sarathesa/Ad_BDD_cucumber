package com.stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.adactin_pages.BookHotelPage;
import org.adactin_pages.BookingConfirmPage;
import org.adactin_pages.LoginPage;
import org.adactin_pages.SearchHotel;
import org.adactin_pages.SelectHotel;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingHoteStep extends BaseClass {
	LoginPage loginPage;
	SearchHotel searchHotel;
	SelectHotel selectHotel;
	BookHotelPage bookHotelPage;
	BookingConfirmPage bookingConfirmPage;

	@Given("User is on the Adactin page")
	public void userIsOnTheAdactinPage() throws IOException {
//		getDriver(getPropertyValue("browserName"));
//		implicitywait(5);
//		loadUrl(getPropertyValue("url"));
//		maximize();
	}

	@When("User should perform login")
	public void userShouldPerformLoginWith() throws IOException {
//		loginPage = new LoginPage();
//		loginPage.login(getPropertyValue("userName"), getPropertyValue("password"));
	}

	@When("User Should Verify login msg {string}")
	public void userShouldVerifyLoginMsg(String expValue) {
		searchHotel = new SearchHotel();
		WebElement txtLoginMsg = searchHotel.getTxtLoginMsg();
		String actValue = txtLoginMsg.getAttribute("value");
		Assert.assertEquals("Verofied Login", expValue, actValue);

	}

	@When("User should Search Hotel with selecting {string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSearchHotelWithSelectingAnd(String location, String hotels, String roomType, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childrensPerRoom) {
		searchHotel = new SearchHotel();
		searchHotel.searchHotel(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultsPerRoom,
				childrensPerRoom);

	}

	@When("User Should Verify select hotel {string}")
	public void userShouldVerifySelectHotel(String expValue) {
		selectHotel = new SelectHotel();
		WebElement txtSelectHotelmsg = selectHotel.getTxtSelectHotelmsg();
		String actValue = txtSelectHotelmsg.getText();
		Assert.assertEquals("Verified in Select page", expValue, actValue);
	}

	@When("User should select Hotel")
	public void userShouldSelectHotel() {
		selectHotel = new SelectHotel();
		selectHotel.selectHotels();

	}

	@When("User Should Verify msg {string}")
	public void userShouldVerifyMsg(String expValue) {
		bookHotelPage = new BookHotelPage();
		WebElement txtBookHotelmsg = bookHotelPage.getTxtBookHotelmsg();
		String actValue = txtBookHotelmsg.getText();
		Assert.assertEquals("Verified in BookHotel page", expValue, actValue);

	}

	@When("User should book hotel with giving details{string},{string},{string} and payment")
	public void userShouldBookHotelWithGivingDetailsAndPayment(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		bookHotelPage = new BookHotelPage();

		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String cardtype = map.get("cardType");
		String cardNo = map.get("cardNo");
		String expMonth = map.get("select month");
		String expYear = map.get("select value");
		String cvv = map.get("cvv");

		bookHotelPage.bookHotel(firstName, lastName, address, cardtype, cardNo, expMonth,expYear, cvv);
	}

	@Then("User Should Verify {string}")
	public void userShouldVerify(String expValue) {
		BookingConfirmPage bookingConfirmPage = new BookingConfirmPage();
		WebElement txtBookingConfirmmsg = bookingConfirmPage.getTxtBookingConfirmmsg();
		String actValue = txtBookingConfirmmsg.getText();
		Assert.assertEquals("Verified in Booking Confirming", expValue, actValue);

	}

	@When("User Should click book button")
	public void userShouldClickBookButton() {

		bookHotelPage.buttonClick();

	}

	@Then("User Should verify msg {string},{string},{string},{string},{string},{string},{string}")
	public void userShouldVerifyMsg(String expFirstnameError, String expLastNameError, String expAddressError,
			String expCardNumberError, String expCardTypeError, String expempMonthError, String expcvvError) {

		BookHotelPage bookHotelPage = new BookHotelPage();
		WebElement firstNameError = bookHotelPage.getFirstNameError();
		String actFirstNameError = firstNameError.getText();
		Assert.assertEquals("Verifying firstname Error", expFirstnameError, actFirstNameError);

		WebElement lastNameError = bookHotelPage.getLastNameError();
		String actLastNameError = lastNameError.getText();
		Assert.assertEquals("Verifying Lastname Error", expLastNameError, actLastNameError);

		WebElement addressError = bookHotelPage.getAddressError();
		String actAddressError = addressError.getText();
		Assert.assertEquals("Verifying Address Error", expAddressError, actAddressError);

		WebElement cardNumberError = bookHotelPage.getCardNumberError();
		String actCardNumberError = cardNumberError.getText();
		Assert.assertEquals("Verifying CardNumber Error", expCardNumberError, actCardNumberError);

		WebElement cardtypeError = bookHotelPage.getCardtypeError();
		String actCardTypeError = cardtypeError.getText();
		Assert.assertEquals("Verifying CardType Error", expCardTypeError, actCardTypeError);

		WebElement empMonthError = bookHotelPage.getEmpMonthError();
		String actempMonthError = empMonthError.getText();
		Assert.assertEquals("Verifying ExpMonth  Error", expempMonthError, actempMonthError);

		WebElement cvvError = bookHotelPage.getCvvError();
		String actcvvError = cvvError.getText();
		Assert.assertEquals("Verifying cvv Error", expcvvError, actcvvError);

	}

}
