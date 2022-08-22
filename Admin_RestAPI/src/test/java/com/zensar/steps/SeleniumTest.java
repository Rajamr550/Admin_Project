package com.zensar.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumTest {

    WebDriver driver;			

	@Given("open the chrome browser")
	public void open_the_chrome_browser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RM66237\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	       
        
	     driver=new ChromeDriver();  
	       driver.manage().window().maximize();

	       
	       
	       
	}

	@When("Enter the url {string}")
	public void enter_the_url(String url) {
		
		driver.get(url);
		
	}

	@When("Click on delete button of id")
	public void click_on_delete_button_of_id() {
		
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[6]/button/mat-icon"));
		deleteButton.click();
	}



	@Then("Deleting works fine")
	public void deleting_works_fine() {
	  System.out.println("deleteByID - working fine");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.close();
	}



}
