package com.main;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.base.LibGlobal;
import com.pages.Cart;
import com.pages.HomePage;
import com.pages.Search;

public class ExecutionMain {
//creating a Libglobal(base class) class object
	static LibGlobal global =new LibGlobal();		
	
//Opening the chrome browser and Loading the url
	@BeforeClass
		private void beforeClass() {
			global.getDriver();
			global.loadUrl("https://www.flipkart.com/");
	
		}
	
//Closing the entire browser	
	@AfterClass
	  private void afterClass() {
		global.quit();
	}
	
//the start time of every test case	
	@BeforeMethod
		private void startTime() {
		Date d=new Date();
		System.out.println(d);
		}
	
//The end time of the every test case
	@AfterMethod
	private void endTime() {
		Date d=new Date();
		System.out.println(d);
	}
	
//Calling the HomePage Method(POM page)
	
	@Test
	 public void Test1() {
		//creating a object for the POM
			HomePage home =new HomePage();
			
		//calling the method from POM - for closing the login popup
			home.getPopup();
			
	   // verifying the user is on the same page or not
			String Expectedurl="https://www.flipkart.com/";
			Assert.assertEquals(global.currentUrl(), Expectedurl, "Verify user is on same page");
			System.out.println("Verified the same user is on the same page");
	}
	
//Calling a method from the Search(POM page)
//Passing the parameters
	
	@Parameters({"SearchBar"})
	@Test
		public void Test2(String s1) throws AWTException {
		
	//creating a object for Search
		Search search=new Search();
		
	//Calling a method from POM - for searching the Iphone12
			search.getSearchbar(s1);	
			
//clicking on the product
			WebElement product = global.byXpath("//div[text()='Apple iPhone 12 (Red, 64 GB)']");
			global.btnClick(product);
//Calling a method from POM - for moving the cursor to the child window
			search.navigate();
		}

	
//verfying the product and adding to the cart along with place order.
	@Test
	public void Test3() throws InterruptedException {
		
//Creating a object for the Cart POM page
		Cart cart=new Cart();

//Calling a method from Cart POM - for verifying, adding to cart & placing an order of the product
		cart.addToCart();
		System.out.println("product added to cart");		
	}
	
	
}
