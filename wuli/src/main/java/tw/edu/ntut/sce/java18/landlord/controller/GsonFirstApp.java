package tw.edu.ntut.sce.java18.landlord.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tw.edu.ntut.sce.java18.landlord.model.ContractBean;

public class GsonFirstApp {

  public static void main(String[] args) {
    String jsonString = "{\"CID\" : }";
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting();
    Gson gson = builder.create();
    ContractBean contract = gson.fromJson(jsonString, ContractBean.class);
  }
}
