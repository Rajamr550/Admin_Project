package com.zensar.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.AdminEntity;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdminSteps {
	
	@LocalServerPort
	private int port=7779;
	private RestTemplate restTemplate=new RestTemplate();
	private  String postUrl="http://localhost";
	  private int id ;
	

	@Given("I Set POST admin service api endpoint")
	public void i_Set_POST_admin_service_api_endpoint() {
	    String url=postUrl+":"+port+"/admin/user";
	    List<AdminEntity> allPost = restTemplate.getForObject(url, List.class);
	    assertTrue(!allPost.isEmpty());
	}

	@Given("^I sending post to be created with email (.*),name (.*) ,password (.*) ,phNumber (.*)$")
	public void i_sending_post_to_be_created_with_id_email_abc_name_ABC_password_ac123_phNumber(String email,String name,String password,long phNumber) {
		String url = postUrl + ":" + port + "/admin/user";
		AdminEntity adminEntity =new AdminEntity();
//		adminEntity.setId(id);
		adminEntity.setEmail(email);
		adminEntity.setName(name);
		adminEntity.setPassword(password);
		adminEntity.setPhNumber(phNumber);
		
		AdminEntity adminEntityy=restTemplate.postForObject(url, adminEntity, AdminEntity.class);
		id=adminEntityy.getId();
		assertNotNull(adminEntityy);
	}

	

	@Then("I receive valid Response")
	public void i_receive_valid_Response() {
		 String url = postUrl + ":" + port + "/admin/user/" + id;
	        AdminEntity adminEntity = restTemplate.getForObject(url, AdminEntity.class);
	        assertNotNull(adminEntity);
	}

	

}
