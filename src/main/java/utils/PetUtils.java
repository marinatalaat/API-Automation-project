package utils;

import Helper.JsonUtils;
import Model.RequestModel.PetReqModel;
import Restwrapper.Headers;
import Restwrapper.restWrapper;
import Enum.EndPoints;
import java.io.IOException;

public class PetUtils {

    static String filePath = "Config/data.json";

    public static PetReqModel createPetRequest() throws IOException {
        PetReqModel petReqModel = JsonUtils.mapJsonToJavaClass(PetReqModel.class, filePath);

        return restWrapper.restPost(EndPoints.PET, Headers.generalHeaders(), petReqModel, PetReqModel.class);
    }

    public static PetReqModel updatePetRequest(String statusNewValue) throws IOException {
        PetReqModel petReqModel = JsonUtils.mapJsonToJavaClass(PetReqModel.class, filePath);
        petReqModel.status = statusNewValue;
        JsonUtils.writeInJsonFile(petReqModel, filePath);

        return restWrapper.restPut(EndPoints.PET, Headers.generalHeaders(), petReqModel, PetReqModel.class);
    }

    public static PetReqModel getPetWithID() throws IOException {
        PetReqModel petReqModel = JsonUtils.mapJsonToJavaClass(PetReqModel.class, filePath);

        return restWrapper.restGet(EndPoints.PET, Headers.generalHeaders(), String.valueOf(petReqModel.id), PetReqModel.class);
    }

    public static int deletePetWithID() throws IOException {
        PetReqModel petReqModel = JsonUtils.mapJsonToJavaClass(PetReqModel.class, filePath);

        return restWrapper.restDelete(EndPoints.PET, Headers.generalHeaders(), String.valueOf(petReqModel.id));
    }
}
