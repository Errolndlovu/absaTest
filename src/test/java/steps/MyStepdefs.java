package steps;

import WEB.TestWeb;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;


public class MyStepdefs {
    TestWeb test = new TestWeb();

    @After
    public void cleanup() {
           test.closeWindow();
    }


    @Given("the user is on the way to automation site")
    public void theUserIsOnTheWayToAutomationSite() {
        test.setUp();
        test.verifyUserIsOnTheUserListTable();
    }

    @When("the user clicks on the add new user button")
    public void the_user_clicks_on_the_add_new_user_button() {
        test.clickAddUser();
    }

    @And("the user captures the first name {string} for the new user")
    public void theUserCapturesTheFirstNameForTheNewUser(String name) {
        test.enterFirstName(name);
    }

    @And("the user captures the last name {string} for the new user")
    public void theUserCapturesTheLastNameForTheNewUser(String lastname) {
        test.enterLastName(lastname);
    }

    @And("the user captures the user name {string} for the new user")
    public void theUserCapturesTheUserNameForTheNewUser(String username) throws IOException {
        test.enterUserName(username);
    }

    @And("the user captures the password {string} for the new user")
    public void theUserCapturesThePasswordForTheNewUser(String pass) {
        test.enterPassword(pass);
    }

    @And("the user selects the customer company {string} option for the new user")
    public void theUserSelectsTheCustomerCompanyOptionForTheNewUser(String comp) {
        test.customerOption(comp);
    }

    @And("the user selects the role {string} for the new user")
    public void theUserSelectsTheRoleForTheNewUser(String role) {
        test.roleOption(role);
    }

    @And("the user captures the email {string} for the new user")
    public void theUserCapturesTheEmailForTheNewUser(String email) {
        test.enterEmail(email);
    }

    @And("the user captures the cellphone number {string} for the new user")
    public void theUserCapturesTheCellphoneNumberForTheNewUser(String cell) {
        test.enterCell(cell);
    }

    @Then("the user clicks on the save button")
    public void theUserClicksOnTheSaveButton() {
        test.clickSave();
    }

    @And("the new user is added into the User List Table")
    public void theNewUserIsAddedIntoTheUserListTable() throws IOException{
        test.verifyUser();
    }



}
