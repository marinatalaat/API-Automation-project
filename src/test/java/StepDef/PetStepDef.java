package StepDef;

import Model.RequestModel.PetReqModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.PetUtils;

import java.io.IOException;

public class PetStepDef {

    PetReqModel petReqModel;
    int receivedStatusCode;
    @Given("User Create new Pet")
    public void userCreateNewPet() throws IOException {
        petReqModel = PetUtils.createPetRequest();
        Assertions.assertNotNull(petReqModel.status);
        Assertions.assertNotNull(petReqModel.category.name);
    }

    @Then("User update the status of existing Pet with value {string}")
    public void userUpdateTheStatusOfExistingPetWithValueUnavailable(String statusNewValue) throws IOException {
        petReqModel = PetUtils.updatePetRequest(statusNewValue);
        Assertions.assertEquals(petReqModel.status, statusNewValue);



    }

    @Then("Verify that Pet Status has been changed to {string} Correctly")
    public void userShouldCheckOnTheUpdatedStatusValue(String NewStatus) throws IOException {
        petReqModel = PetUtils.getPetWithID();
        Assertions.assertEquals(NewStatus ,petReqModel.status);
    }

    @Then("User delete the created new Pet")
    public void userDeleteTheCreatedNewPet() throws IOException {
        receivedStatusCode= PetUtils.deletePetWithID();

    }

    @Then("Verify that the request should be with status code {int}")
    public void theRequestShouldBeWithStatusCode(int StatusCode) {
        Assertions.assertEquals(StatusCode, receivedStatusCode);
    }


}
