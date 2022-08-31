package com.zensar.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteAdminSteps {

    WebDriver driver;			

	@Given("open the chrome browser")
	public void open_the_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");    
	     driver=new ChromeDriver();  
	     driver.manage().window().setSize(new Dimension(1920, 1000));
	     //driver.manage().window().maximize();
	     
	}

	@When("Enter the url {string}")
	public void enter_the_url(String url) {
		driver.get(url);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,350)", "");
	        
	}

	@When("Click on delete button of id")
	public void click_on_delete_button_of_id() {	
		driver.findElement(By.name("delete")).findElement(By.id("99")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"97\"]")).click();
	}

	@Then("Deleting works fine")
	public void deleting_works_fine() {
	  System.out.println("deleteByID - working fine");
//	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//	  driver.close();
	//*[@id="97"]
	}



}
