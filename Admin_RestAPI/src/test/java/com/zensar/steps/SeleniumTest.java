package com.zensar.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumTest {

	
	@Given("open the chrome browser")
	public void open_the_chrome_browser() {

	       
	       
	       
	       
	}

	@When("Enter the url {string}")
	public void enter_the_url(String string) {
		
	}

	@When("Click on delete button of id")
	public void click_on_delete_button_of_id() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RM66237\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	       
        
	     WebDriver driver=new ChromeDriver();  
	        driver.manage().window().maximize();

		driver.navigate().to("http://localhost:4200/admin_form/"); 
		WebElement m = driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[2]/td[6]/button/mat-icon"));
		m.click();
	}



	@Then("Deleting works fine")
	public void deleting_works_fine() {
	  System.out.println("working fine");
	}



}
