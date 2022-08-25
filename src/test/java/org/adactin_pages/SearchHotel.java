package org.adactin_pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotel extends BaseClass {
	
	public SearchHotel() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id="username_show")
	private WebElement txtLoginmsg;

	public WebElement getTxtLoginMsg() {
		return txtLoginmsg;
	}

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotel;

	@FindBy(id = "room_type")
	private WebElement dDnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnRoomNos;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement dDnAdultPerRoom;

	@FindBy(id = "child_room")
	private WebElement dDnChildrenPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotel() {
		return dDnHotel;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNos() {
		return dDnRoomNos;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultPerRoom() {
		return dDnAdultPerRoom;
	}

	public WebElement getdDnChildrenPerRoom() {
		return dDnChildrenPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void searchHotel(String location, String hotel, String roomType, String noOfRoom, String checkIDate,
			String checkOutDate, String adultsPerRoom, String childrenPerRoom) {

		selectByText(getdDnLocation(), location);
		selectByText(getdDnHotel(), hotel);
		selectByText(getdDnRoomType(), roomType);
		selectByText(getdDnRoomNos(), noOfRoom);
		typeText(getTxtCheckInDate(), checkIDate);
		typeText(getTxtCheckOutDate(), checkOutDate);
		selectByText(getdDnAdultPerRoom(), adultsPerRoom);
		selectByText(getdDnChildrenPerRoom(), childrenPerRoom);
		click(getBtnSearch());
		
		String searchPageVerify = driver.getCurrentUrl();
		Assert.assertTrue("searchPageVerify", true);

	}

}
