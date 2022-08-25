package org.adactin_pages;

import java.io.IOException;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmPage extends BaseClass{
	
	public BookingConfirmPage() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement txtBookingConfirmmsg;
	
	public WebElement getTxtBookingConfirmmsg() {
		return txtBookingConfirmmsg;
	}

	@FindBy(id="order_no")
	private WebElement orderId;

	public WebElement getOrderId() {
		return orderId;
	}
	
	public void bookingConfirm() throws IOException  {
		String valueAttribute = getValueAttribute(getOrderId());
		
		System.out.println(valueAttribute);
		inputToExcel("Sheet1", 11, 18, valueAttribute);
		
		String bookingConfirmPage= driver.getCurrentUrl();
		Assert.assertTrue(bookingConfirmPage,true);
		
	}
	

}
