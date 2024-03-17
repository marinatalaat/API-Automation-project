package Objects;

import Model.RequestModel.PetReqModel;

import java.util.ArrayList;

public class PetRequest {
    public static PetReqModel PetInfo(int id , String Name , PetReqModel.Category Category, ArrayList<String> PhotoURLS, ArrayList<PetReqModel.Tag> Tags, String status)  {
        PetReqModel petReqModel = new PetReqModel();
        petReqModel.id=id;
        petReqModel.name=Name;
        petReqModel.category=Category;
        petReqModel.photoUrls=PhotoURLS;
        petReqModel.tags=Tags;
        petReqModel.status=status;
        return petReqModel;
    }
}
