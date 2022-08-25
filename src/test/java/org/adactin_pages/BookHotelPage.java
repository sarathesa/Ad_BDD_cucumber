package org.adactin_pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass {
	
	public BookHotelPage() {
	PageFactory.initElements(driver, this);
	}
	
	public WebElement getFirstNameError() {
		return firstNameError;
	}

	public WebElement getLastNameError() {
		return lastNameError;
	}

	public WebElement getAddressError() {
		return addressError;
	}

	public WebElement getCardNumberError() {
		return cardNumberError;
	}

	public WebElement getCardtypeError() {
		return cardtypeError;
	}

	public WebElement getEmpMonthError() {
		return empMonthError;
	}

	public WebElement getCvvError() {
		return cvvError;
	}

	@FindBy(xpath="//label[text()='Please Enter your First Name']")
	private WebElement firstNameError;
	
	@FindBy(xpath="//label[text()='Please Enter you Last Name']")
	private WebElement lastNameError;
	
	@FindBy(xpath="//label[text()='Please Enter your Address']")
	private WebElement addressError;
	
	@FindBy(xpath="//label[text()='Please Enter your 16 Digit Credit Card Number']") 
	private WebElement cardNumberError;
	
	@FindBy(xpath="//label[text()='Please Select your Credit Card Type']")
	private WebElement cardtypeError;
	
	@FindBy(xpath="//label[text()='Please Select your Credit Card Expiry Month']")
	private WebElement empMonthError;
	
	@FindBy(xpath="//label[text()='Please Enter your Credit Card CVV Number']")
	private WebElement cvvError;
	
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHotelmsg;
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCardNumber;
	
	@FindBy(id="cc_type")
	private WebElement dDnCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement dDnExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement dDnExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCvvNo;
	
	@FindBy(id="book_now")	
	private WebElement btnBook;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNumber() {
		return txtCardNumber;
	}

	public WebElement getdDnCardType() {
		return dDnCardType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}

	public WebElement getTxtCvvNo() {
		return txtCvvNo;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}
	
	public void buttonClick() {
		click(getBtnBook());
	}
	public WebElement getTxtBookHotelmsg() {
		return txtBookHotelmsg;
	}
	
	public void bookHotel(String firstName,String lastName,String address,String cardtype,
			String cardNo,String expMonth,String expYear, String cvv ) throws InterruptedException {
		typeText(getTxtFirstName(), firstName);
		typeText(getTxtLastName(), lastName);
		typeText(getTxtAddress(), address);
		typeText(getdDnCardType(), cardtype);
		typeText(getTxtCardNumber(), cardNo);
		selectByText(getdDnExpMonth(), expMonth);
		selectByText(getdDnExpYear(), expYear);
		selectByID(getdDnExpYear(), 12);
		typeText(getTxtCvvNo(), cvv);
		
		
		click(getBtnBook());
		Thread.sleep(5000);
		
		String bookHotelPageVerify= driver.getCurrentUrl();
		Assert.assertTrue(bookHotelPageVerify,true);

	}

	}
	
	


