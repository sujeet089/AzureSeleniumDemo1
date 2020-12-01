package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class HomePage extends LibGlobal{
	
//Creating a object for base class
	public static LibGlobal global =new LibGlobal();
	
//default constructor
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
//Xpath of Login Poup
		@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
		 	private WebElement popup;
		
//Getters for Login Popup
		public void getPopup() {
			global.btnClick(popup);
		}

		
}
