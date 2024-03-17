package Model.RequestModel;

import java.util.ArrayList;


public class PetReqModel {
    public int id;
    public String name;
    public Category category;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;


    public class Category{
        public int id;
        public String name;
    }

    public static class Tag{
        public int id;
        public String name;
    }
}
