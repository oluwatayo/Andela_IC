package com.example.android.aic.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by OLUWATAYO on 15/09/2017.
 */

public class ItemResponse {
    @SerializedName("items")
    @Expose
    private List<Item> items;
    public  List<Item> getItems(){
        return items;
    }
     public void setItems(List<Item> items){
         this.items = items;
     }
}
