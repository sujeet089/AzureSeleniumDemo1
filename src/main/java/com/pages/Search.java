package com.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.base.LibGlobal;


public class Search extends LibGlobal{
	

	 static LibGlobal global =new LibGlobal();

//default constructor
	public Search() {
		PageFactory.initElements(driver, this);
	}
	
//Xpath for the Search Bar
	@FindBy(xpath ="//input[@type='text']")
		private WebElement searchbar;

//Getter of the Search bar
	public void getSearchbar(String s1) {
		global.sendKeyEnter(searchbar, s1);
		}
		
		
//Cursor is moving to the child window
		public void navigate() {
//getting the parent window ID
			String parentId = global.parentId();
//Getting the all windows ID
			Set<String> allWid = global.allwindow();
//Cursor is shifting to child window
			global.shiftToChild(parentId, allWid);

		}
}
