package Objects;

import Model.RequestModel.PetReqModel;

public class UserObject {
    public static PetReqModel UserInfo(int id , PetReqModel.Category username , String firstName , String lastName, String email, String password , String phone , String status)  {
        PetReqModel petReqModel = new PetReqModel();
        petReqModel.id=id;
        petReqModel.name=username;
        petReqModel.status=status;
        return petReqModel;
    }
}
