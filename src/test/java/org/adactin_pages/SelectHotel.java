package org.adactin_pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotel extends BaseClass{
	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement txtSelectHotelmsg;
	
	public WebElement getTxtSelectHotelmsg() {
		return txtSelectHotelmsg;
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnSelect; 
	
	@FindBy(id="continue")
	private WebElement btncontinue;

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getBtncontinue() {
		return btncontinue;
	}
	
	public void selectHotels() {
		click(getBtnSelect());
		click(getBtncontinue());
		
		String selectHotelpageVerify= driver.getCurrentUrl();
		Assert.assertTrue("verified", true);
	}
}
