package StepDef;

import Model.RequestModel.PetReqModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.PetUtils;

import java.io.IOException;

public class PetStepDef {

    PetReqModel petReqModel;
    String statusUpdatedValue;

    @Given("User Create new Pet")
    public void userCreateNewPet() throws IOException {
        petReqModel = PetUtils.createPetRequest();
        Assertions.assertNotNull(petReqModel.status);
        Assertions.assertNotNull(petReqModel.category.name);
    }

    @Then("User update the status of existing Pet with value {string}")
    public void userUpdateTheStatusOfExistingPetWithValueUnavailable(String statusNewValue) throws IOException {
        petReqModel = PetUtils.updatePetRequest(statusNewValue);
        statusUpdatedValue = statusNewValue;
        Assertions.assertEquals(petReqModel.status, statusNewValue);



    }

    @Then("User should check on the updated status value")
    public void userShouldCheckOnTheUpdatedStatusValue() throws IOException {
        petReqModel = PetUtils.getPetWithID();
        Assertions.assertEquals(statusUpdatedValue ,petReqModel.status);
    }

    @Then("User delete the created new Pet and the request should be with status code {int}")
    public void userDeleteTheCreatedNewPet(int StatusCode) throws IOException {
        int receivedStatusCode = PetUtils.deletePetWithID();
        Assertions.assertEquals(StatusCode, receivedStatusCode);
    }
}
