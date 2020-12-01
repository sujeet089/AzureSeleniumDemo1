package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.LibGlobal;

public class Cart extends LibGlobal{
	 static LibGlobal global =new LibGlobal();
	 
//Default Constructor
	 public Cart() {
		PageFactory.initElements(driver, this);
	}

//Xpath for Add to Cart button
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addtoCart;

//Xpath for the Product Title
	@FindBy(xpath="//span[@class='B_NuCI']")
		private WebElement texttitle;

//Xpath for the Cart Product Title
	@FindBy(xpath="//a[@class='_2Kn22P gBNbID']")
		private WebElement producttext;

//Xpath for the Place order button
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
		private WebElement placeOrder;
	
//for all above elements getters
	public WebElement getAddtoCart() {
		return addtoCart;
	}
	public WebElement getTexttitle() {
		return texttitle;
	}

	public WebElement getproducttext() {
		return producttext;
	}

	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	public void addToCart() throws InterruptedException {
		
		
//fetching the product title here
		String productTitle = global.webText(texttitle);
		System.out.println("product title is:"+productTitle);
		
//product is adding into the cart
		global.btnClick(addtoCart);
		System.out.println("product added to the cart");
		
		Thread.sleep(2000);
		
//fetching the cart product text
		String Carttext = global.webText(producttext);
		System.out.println("Cart product text is:"+Carttext);
		
//verifying both are same or not
		Assert.assertEquals(Carttext, productTitle, "Verify same product is added or not");
		System.out.println("Same Product added verified");
		
//clicking on the place order button
		global.btnClick(placeOrder);
		System.out.println("Order is placed sucessfully");
	}	
}
