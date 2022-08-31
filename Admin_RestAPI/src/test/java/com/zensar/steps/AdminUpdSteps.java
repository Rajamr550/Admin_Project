package com.zensar.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AdminUpdSteps {


	public WebDriver driver = null;
	
	@Given("open browser in chrome")
	public void open_browser_in_chrome() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SR66171\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver =new ChromeDriver();
//		driver.manage().window().setSize(new Dimension(1920, 1000)); 
		driver.manage().window().maximize();
	}


	@When("Enter {string} url")
	public void enter_url(String url) {
		
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	@When("Click on Edit button for particular id")
	public void click_on_edit_button_for_particular_id() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("adminEdit")));
//		executor.executeScript(“arguments[0].click();”, element);
		driver.findElement(By.name("adminEdit")).findElement(By.id("2")).click();
		
	}
	
	@When("Enter Updated Admin Details like name {string} passowrd {string} email {string} mobile {string}")
	public void enter_updated_admin_details_like_name_passowrd_email_mobile(String name, String password, String email, String mobile) {

		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("mobile")).sendKeys(mobile);
	}


	@When("Click on Update button")
	public void click_on_update_button() {
	    driver.findElement(By.name("update")).click();
	}

	@Then("Updated Admin details get registered")
	public void updated_admin_details_get_registered() {
//	 
//		String captureText = driver.findElement(By.xpath(null)).getText();
//		Assert.assertEquals(true, captureText.contains("Pras"));
	}



}
