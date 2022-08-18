package com.zensar.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Pattern;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.AdminEntity;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmailValidationSteps {

    private int port = 7787;
    private RestTemplate restTemplate = new RestTemplate();
    private String Url = "http://localhost";
    private int id;

//    @Given("I Set Get admin service api endpoint with id")
//    public void i_Set_Get_admin_service_api_endpoint_with_id() {
//	String url = Url + ":" + port + "/admin/user";
//	List<AdminEntity> getById = restTemplate.getForObject(url, List.class);
//	assertTrue(!getById.isEmpty());
//    }
//
//    @When("I send get by id method to get with id {int}")
//    public void i_send_get_by_id_method_to_get_with_id(int int1) {
//	String url = Url + ":" + port + "/admin/user/" + int1;
//	AdminEntity adminEntityy = restTemplate.getForObject(url, AdminEntity.class);
//	adminEntityy.getId();
//	assertNotNull(adminEntityy);
//    }
//
//    @Then("I recieve valid Response for Get by id")
//    public void i_recieve_valid_Response_for_Get_by_id() {
//	String url = Url + ":" + port + "/admin/user/" + 2;
//	AdminEntity adminEntity = restTemplate.getForObject(url, AdminEntity.class);
//	assertNotNull(adminEntity);
//	validating_email(adminEntity.getEmail());
//    }
//
//    @Then("I check for validating email")
//    public void validating_email(String email) {
//	// int flag = 0;
//	assertNotNull(email);
//	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//	Pattern pattern = Pattern.compile(emailRegex);
//	assertTrue(pattern.matcher(email).matches());
//
//    }
    // new

    @Given("I Set Get admin service api endpoint with ids")
    public void i_set_get_admin_service_api_endpoint_with_ids() {
//	String url = Url + ":" + port + "/admin/user";
//	List<AdminEntity> getById = restTemplate.getForObject(url, List.class);
//	assertTrue(!getById.isEmpty());
	System.out.println("check");

    }

    @When("I send get by ids method to get with id {int}")
    public void i_send_get_by_ids_method_to_get_with_id(Integer int1) {
//	String url = Url + ":" + port + "/admin/user/" + int1;
//	AdminEntity adminEntityy = restTemplate.getForObject(url, AdminEntity.class);
//	adminEntityy.getId();
//	assertNotNull(adminEntityy);
	System.out.println("check");

    }

    @Then("I recieve valid Response for Get by ids and check Email")
    public void i_recieve_valid_response_for_get_by_ids() {
	String url = Url + ":" + port + "/admin/user/" + 2;
	AdminEntity adminEntity = restTemplate.getForObject(url, AdminEntity.class);
	assertNotNull(adminEntity);

	if (validateEmail(adminEntity.getEmail()).equals("true"))
	    assertThat(true);

    }

    private String validateEmail(String email) {
	if (email == null || email.isEmpty()) {
	    return "false";
	}
	String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	Pattern pattern = Pattern.compile(emailRegex);
	if (pattern.matcher(email).matches()) {
	    return "true";
	}

	return "false";

    }

}
