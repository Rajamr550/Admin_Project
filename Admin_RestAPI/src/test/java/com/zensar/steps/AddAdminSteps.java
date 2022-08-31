package com.zensar.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.zensar.dto.AdminDTO;
import com.zensar.entity.AdminEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AddAdminSteps {
	
	public WebDriver  driver=null;
	
	@Given("open browser")
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();  
	}

	@When("Enter url {string}")
	public void enter_url(String url) {
		driver.get(url);  
	}

	@When("Enter Admin Details like name {string} passowrd {string} email {string}")
	public void enter_admin_details_like_name_passowrd_email(String name, String password, String email) {
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(password); 
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("mobileNo")).sendKeys("878787878"); 
	}

	@When("Click on Submit")
	public void click_on_submit() {
		driver.findElement(By.name("submit")).click();  
	}

	@Then("Admin details get registered")
	public void admin_details_get_registered() {
		String capText=	driver.findElement(By.xpath("//*")).getText();
		Assert.assertEquals(true, capText.contains("Zensar123@gmail.com"));	   
	}


	

//	@Given("open browser")
//	public void open_browser() {
//		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\PD66188\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//		driver =new ChromeDriver();
//		driver.manage().window().maximize();
//	    
//	}
//
//
//	@When("Enter url {string}")
//	public void enter_url(String url) {
//	   driver.get(url);
//	}
//
//
//
//	@When("Click on delete icon to delete any admin")
//	public void click_on_delete_icon_to_delete_any_admin() {
//		driver.findElement(By.id("deleteRecord")).click();
//	}
//
//
//
//	@Then("selected admin record will be deleted")
//	public void selected_admin_record_will_be_deleted() {
//		
//		String capText=	driver.findElement(By.xpath("//*")).getText();
//		Assert.assertEquals(true, capText.contains("Dhoke123@gmail.com"));
//	   
//	}

}
