package steps;

import API.APITest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APIsteps {

    APITest test = new APITest();

    @Given("a user requests for a list of all breeds")
    public void aUserRequestsForAListOfAllBreeds() {
        test.testAllBreeds();
    }

    @When("the user verifies the retriever {string} is within the list")
    public void theUserVerifiesTheRetrieverIsWithinTheList(String breed) {
        test.verifyRetrieverIsWithinTheList(breed);
    }

    @Then("the user requests to produce a list of sub breeds for retriever")
    public void theUserRequestsToProduceAListOfSubBreedsForRetriever() {
        test.listOfSubBreeds();
    }

    @And("the user requests for a random image or link for the sub-breed golden {string}")
    public void theUserRequestsForARandomImageOrLinkForTheSubBreedGolden(String subbreed) {
        test.randomImages(subbreed);
    }
}
