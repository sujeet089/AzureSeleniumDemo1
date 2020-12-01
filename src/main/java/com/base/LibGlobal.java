package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {

	public static WebDriver driver;
	public Actions acc;
	public Alert a;
	public JavascriptExecutor js;
	public TakesScreenshot ts;
	public WebElement element;
	

	public WebDriver getDriver() {
	     // System.setProperty("webdriver.chrome.driver", "C:\\Users\\alla.chamundeswari\\eclipse-workspace\\SampleDemo\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	      acc=new Actions(driver);
	      ts=(TakesScreenshot) driver;
	      js=(JavascriptExecutor) driver;
	      
	      return driver;
		}
	  public void loadUrl(String Url) {
		  	driver.get(Url);
		  	driver.manage().window().maximize();
		  	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    }
	  public void sendKeyEnter(WebElement element, String data){
		     element.sendKeys(data,Keys.ENTER);
	  }
	  
		  public void sendKey(WebElement element, String data) {
		     element.sendKeys(data);
			}
		  public void btnClick(WebElement element) {
				element.click();
			}
		  
		  public void clear(WebElement element) {
				element.clear();
			}
		  
		  public WebElement byId(String Id) {
		     WebElement idelement = driver.findElement(By.id(Id));
		     return idelement;
		  }
		  
		  public WebElement byName(String Name) {
				WebElement nameElement = driver.findElement(By.name(Name));
				return nameElement;
			}
		  
		  public WebElement byClassName(String className) {
			    WebElement clsElement = driver.findElement(By.className(className));
		      return clsElement;
			}
		  
		  public WebElement byXpath(String xpath) {
				WebElement xpathElement = driver.findElement(By.xpath(xpath));
		      return xpathElement;
			}
		  
		  public WebElement byTagname(String tname) {
			   WebElement tagname = driver.findElement(By.tagName(tname));
		     return tagname;
			}
		  
		  public String title() {
				String Actualtitle = driver.getTitle();
				return Actualtitle;
				
			}
		  
		  public String getAttribute(WebElement element, String value) {
				String attribute = element.getAttribute(value);
				return attribute;
			}
		  
		  public String webText(WebElement element){
			 String text = element.getText();
			return text;
			  
		  }
		  public String currentUrl() {
			   String ActualUrl = driver.getCurrentUrl();
			   System.out.println("Actuall URL is:"+ActualUrl);
		     return ActualUrl;
			}
		  
		  public void print(String variablename) {
				System.out.println(variablename);
			}
		  
		  public void sleep(long numb) throws InterruptedException {
			   Thread.sleep(numb);
			}
		  
		  public void close() {
			      driver.close();
		   } 
		  
		  public void quit() {
				driver.quit();
			}
		  
		  public void threadwait() throws InterruptedException{
			    driver.wait();
		  }
		  
		  public void movetoelement(WebElement element) {
				acc.moveToElement(element);
			}
		  
		  public void perform() {
		      acc.perform();
			}
		  public void doubleclick(WebElement target) {

				acc.doubleClick(target);
			}
		  public void rightclick(WebElement target) {
		    acc.contextClick(target);
			}
		  
		  public void draganddrop(WebElement source, WebElement destination) {
				acc.dragAndDrop(source, destination);  
		  }    
		  public String alertText() {
				String text = a.getText();
				return text;
			}
			
		  public void dismiss() {
				a.dismiss();	
			}
			
		  public void accept() {
		           a.accept();		
			}
		  
		  public void sendkeys(String value) {
		           a.sendKeys(value);
			}
		  
		  public void setAtrribute(String arg1, WebElement element) {
			   js.executeScript("arguments[0].setAttribute('value','"+ arg1 +"')", element);
			}
		  
		  public void jsclick(WebElement element) {
				js.executeScript("arguments[0].click()", element);
			}
		  
		  public void jsScrollUp(WebElement element) {
				js.executeScript("arguments[0].scrollInToView(false)", element);
			}
		    
		  public void jsScrollDown(WebElement element) {
				js.executeScript("arguments[0].scrollInToView(true)", element);
			}
		  
		  public File screenshot() {
				File srcFile = ts.getScreenshotAs(OutputType.FILE);
				return srcFile;
			}
		  
		  public File destinationpath(String loc) {
		        File destFile=new File(loc);
		        return destFile;
			}
		  
		  public void copyfile(File srcFile,File destFile) throws IOException {
		         FileUtils.copyFile(srcFile, destFile);
			}
		  
		  public void frameid(int index) {
		         driver.switchTo().frame(index);	     
			}	  
		  public void framename(String nameorId) {
				 driver.switchTo().frame(nameorId);	
			}  
		  public void framewebelement(WebElement frameelement) {
		         driver.switchTo().frame(frameelement);
		    }
		  public void shifttomainwindow() {
			 driver.switchTo().defaultContent();
		    }
		  
		  public void parentframe() {
				driver.switchTo().parentFrame();
			}  
		  public void selbyindex(WebElement element, int i) {
				Select s=new Select(element);
			s.selectByIndex(i);
		    }	  
		  public void selbyvalue(WebElement element,String value) {
				Select s=new Select(element);
			s.selectByValue(value);
		    }	  
		  public void selbytext(WebElement element, String text1) {
				Select s=new Select(element);
			s.selectByVisibleText(text1);
		}
		  public String getoptions(WebElement element) {
				Select s=new Select(element);
			List<WebElement> alloptions = s.getOptions();
			for (WebElement opt : alloptions) {
				String print = opt.getText();
				return print;
			}
			return null;
		} 
		  public String getselectedopts(WebElement element) {
				Select s=new Select(element);
			List<WebElement> selectedOptions = s.getAllSelectedOptions();
		    for (WebElement opt : selectedOptions) {
				String print = opt.getText();
				return print;
			}
			return null;
		   }
		  public String getfirstselected(WebElement element) {
				Select s=new Select(element);
				WebElement firstSelectedOption = s.getFirstSelectedOption();
				String print = firstSelectedOption.getText();
				return print;
			}
			   public void ismultiple(WebElement element) {
					Select s=new Select(element);
			     boolean b = s.isMultiple();
			     System.out.println(b);
			}
			   public void printing(String print) {
				System.out.println(print);
			}
			 public void deselectbyIndex(WebElement element,int i) {
					Select s=new Select(element);
				s.deselectByIndex(i);
			}
			 public void deselectbyValue(WebElement element, String value) {
					Select s=new Select(element);
		       s.deselectByValue(value);
			}
			 public void deselectbyText(WebElement element, String text) {
					Select s=new Select(element);
				s.deselectByVisibleText(text);
			}
			public void deselectall(WebElement element) {
				Select s=new Select(element);
				s.deselectAll();
			}
			public String parentId() {
				String pwid = driver.getWindowHandle();
		      return pwid;
			}
		 
			public Set<String> allwindow() {
				Set<String> allwindowid = driver.getWindowHandles();
		       return allwindowid;
			}
			public void shiftToChild(String pwid, Set<String> allwindowid) {
				int count=0;
		      for (String each : allwindowid) {
					driver.switchTo().window(each);
					count++;
				}
			}
		     public void particularWindow(String pwid, Set<String> allwindowid,int index) {
				List<String> l=new ArrayList<String>();
				l.addAll(allwindowid);
				l.get(index);
			}
		     

}
