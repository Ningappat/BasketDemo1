import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasketDemo {

	public static void main(String[] args) throws InterruptedException {
	
		
	    	System.setProperty("webdriver.chrome.driver", "D:\\BrowserDriver\\ChromeNewDriver\\chromedriver.exe");
	    	WebDriver driver=new ChromeDriver();
		
		
	    	driver.get("http://www.bigbasket.com/");
	    	System.out.println("Big basket home page is displayed");
		
		    driver.manage().window().maximize();
		
	    	WebDriverWait wait=new WebDriverWait(driver,20);
		
	    	Actions actions = new Actions(driver);		
	    	WebElement menuOption = driver.findElement(By.xpath("//a[@class='dropdown-toggle meganav-shop']/parent::li"));	
	    	actions.moveToElement(menuOption).perform();
			    
	        WebElement subMenuOption = driver.findElement(By.xpath("//body/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/mega-nav-template[1]/div[1]/ul[1]/li[4]/a[1]"));		
	     	actions.moveToElement(subMenuOption).build().perform();
		 		 		
	    	 driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		    	
		     WebElement subMenuOption2 = driver.findElement(By.xpath("(//a[@ng-href='/pc/beverages/tea/?nc=nb'])[2]"));
	    	 actions.moveToElement(subMenuOption2).build().perform();
	 	     driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		     
		   //Select green tea			 
		     WebElement subMenuOption3 = driver.findElement(By.linkText("Green Tea"));
		     actions.moveToElement(subMenuOption3).click().build().perform();
		     driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		     		     
		   //Search the Tea
		     
		      WebElement searchElement=driver.findElement(By.xpath("//*[@id='filterbar']/div[4]/div[2]/div/input"));
		     
		      searchElement.sendKeys("Tea");
		     
		      WebDriverWait wait1=new WebDriverWait(driver,30);
		    
		      //Select the first and last checkbox
		     		     
		       WebElement SelectFirst =driver.findElement(By.xpath("//span[text()='Cambridge Tea Party']"));
		       SelectFirst.click();
		       WebElement Selectlast=  driver.findElement(By.xpath("//span[text()='Teamonk']"));
		       Selectlast.click();
		     
		       //Get the Tea count
		    
		       WebElement totalproductsCount=driver.findElement(By.xpath("//div[@class='row']//h2[1]"));	  
		       String s= totalproductsCount.getText();
		       System.out.println("Tea Count is : " + s);
		      
		       //Product price
		      
		       WebElement totalPrice=driver.findElement(By.xpath("//span[@class='discnt-price']//span"));
		       String firstproductprice= totalPrice.getText();
		       System.out.println("Product price is " +firstproductprice);
		      		      
		       driver.close();
		     
		     
		   
	}

}
