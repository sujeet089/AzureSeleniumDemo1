package com.main;

import java.awt.AWTException;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.LibGlobal;
import com.pages.Cart;
import com.pages.HomePage;
import com.pages.Search;

public class NewTest {
	
	static LibGlobal global =new LibGlobal();
	
	@BeforeClass
	private void beforeClass() {
		global.getDriver();
		global.loadUrl("https://www.flipkart.com/");

	}

	
  //@Test
  public void f() {
	  
	//creating a object for the POM
		HomePage home =new HomePage();
		
	//calling the method from POM - for closing the login popup
		home.getPopup();
		
 // verifying the user is on the same page or not
		String Expectedurl="https://www.flipkart.com/";
		Assert.assertEquals(global.currentUrl(), Expectedurl, "Verify user is on same page");
		System.out.println("Verified the same user is on the same page");
  }
  
  
  @BeforeMethod
	private void startTime() {
	Date d=new Date();
	System.out.println(d);
	}
  
  @AfterMethod
	private void endTime() {
		Date d=new Date();
		System.out.println(d);
	}
  
  

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


