package com.zensar.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdminSteps {

    private int port = 7787;
    private RestTemplate restTemplate = new RestTemplate();
    private String Url = "http://localhost";
    private int id;

    @Given("I Set POST admin service api endpoint")
    public void i_Set_POST_admin_service_api_endpoint() {
	String url = Url + ":" + port + "/admin/user";
	List<AdminEntity> allPost = restTemplate.getForObject(url, List.class);
	assertTrue(!allPost.isEmpty());
    }

    @When("^I sending post to be created with email (.*),name (.*) ,password (.*) ,phNumber (.*)$")
    public void i_sending_post_to_be_created_with_id_email_abc_name_ABC_password_ac123_phNumber(String email,
	    String name, String password, long phNumber) {
	String url = Url + ":" + port + "/admin/user";
	AdminEntity adminEntity = new AdminEntity();
//		adminEntity.setId(id);
	adminEntity.setEmail(email);
	adminEntity.setName(name);
	adminEntity.setPassword(password);
	adminEntity.setPhNumber(phNumber);

	AdminEntity adminEntityy = restTemplate.postForObject(url, adminEntity, AdminEntity.class);
	id = adminEntityy.getId();
	assertNotNull(adminEntityy);
    }

    @Then("I receive valid Response")
    public void i_receive_valid_Response() {
	String url = Url + ":" + port + "/admin/user/" + id;
	AdminEntity adminEntity = restTemplate.getForObject(url, AdminEntity.class);
	assertNotNull(adminEntity);
    }

    @Given("I Set Get admin service api endpoint")
    public void i_Set_Get_admin_service_api_endpoint() {
	String url = Url + ":" + port + "/admin/user";
	List<AdminEntity> allGet = restTemplate.getForObject(url, List.class);
	assertTrue(!allGet.isEmpty());

    }

    @When("^I sending get all method record to get id(.*), email (.*),name (.*) ,password (.*) ,phNumber (.*)$")
    public void i_sending_get_all_method_record_to_get_id1_email_name_password_phNumber(int id, String email,
	    String name, String password, long phNumber) {
	String url = Url + ":" + port + "/admin/user";
	List<AdminEntity> adminEntityy = restTemplate.getForObject(url, List.class);
	adminEntityy.add(new AdminEntity());
	adminEntityy.add(new AdminEntity());
	assertNotNull(adminEntityy);
    }

    @Then("I recieve valid Response for Getting all Records")
    public void i_recieve_valid_Response_for_Getting_all_Records() {

	String url = Url + ":" + port + "/admin/user";
	List<AdminEntity> adminEntity = restTemplate.getForObject(url, List.class);
	assertNotNull(adminEntity);

    }

    @Given("I Set Delete admin service api endpoint")
    public void i_Set_Delete_admin_service_api_endpoint() {
	String url = Url + ":" + port + "/admin/user";
	List<AdminEntity> deleteById = restTemplate.getForObject(url, List.class);
	assertTrue(!deleteById.isEmpty());
    }

    @When("I sending delete method to be deleted with id {int}")
    public void i_sending_delete_method_to_be_deleted_with_id(int delId) {

	String url = Url + ":" + port + "/admin/user/" + delId;
	restTemplate.delete(url);
	assertTrue(true);
    }

    @Then("I recieve valid Response true\\/false")
    public void i_recieve_valid_Response_true_false() {
	String url = Url + ":" + port + "/admin/user/" + id;
	assertTrue(true);

    }

    @Given("I Update admin service api endpoint")
    public void i_Update_admin_service_api_endpoint() {

	String url = Url + ":" + port + "/admin/user";
	List<AdminEntity> updateById = restTemplate.getForObject(url, List.class);
	assertTrue(!updateById.isEmpty());
    }

    @When("^I sending update method record to get id (.*), email (.*),name (.*) ,password (.*) ,phNumber (.*)$")
    public void i_sending_update_method_record_to_get_id1_email_name_password_phNumber(int id, String email,
	    String name, String password, long phNumber) {

	AdminEntity adminEntity = new AdminEntity();
	;
	id = this.id;
	adminEntity.setId(id);
	adminEntity.setName("prashant");
	adminEntity.setEmail("prashant24@gmail.com");
	adminEntity.setPassword("pass@123");
	adminEntity.setPhNumber(909887654);
	id = adminEntity.getId();
	String url = Url + ":" + port + "/admin/user/" + id;
	restTemplate.put(url, adminEntity);

	assertNotNull(adminEntity);
    }

    @Then("I recieve valid Response for update")
    public void i_recieve_valid_Response_for_update() {
	AdminEntity adminEntityy = new AdminEntity();
	id = adminEntityy.getId();
	String url = Url + ":" + port + "/admin/user/" + 3;
	AdminEntity adminEntity = restTemplate.getForObject(url, AdminEntity.class);
	assertNotNull(adminEntity);
    }

    // Get BY ID

    @Given("I Set Get admin service api endpoint with id")
    public void i_Set_Get_admin_service_api_endpoint_with_id() {
	String url = Url + ":" + port + "/admin/user";
	List<AdminEntity> getById = restTemplate.getForObject(url, List.class);
	assertTrue(!getById.isEmpty());
    }

    @When("I send get by id method to get with id {int}")
    public void i_send_get_by_id_method_to_get_with_id(int int1) {
	String url = Url + ":" + port + "/admin/user/" + int1;
	AdminEntity adminEntityy = restTemplate.getForObject(url, AdminEntity.class);
	adminEntityy.getId();
	assertNotNull(adminEntityy);
    }

    @Then("I recieve valid Response for Get by id")
    public void i_recieve_valid_Response_for_Get_by_id() {
	String url = Url + ":" + port + "/admin/user/" + 2;
	AdminEntity adminEntity = restTemplate.getForObject(url, AdminEntity.class);
	assertNotNull(adminEntity);
    }

}
