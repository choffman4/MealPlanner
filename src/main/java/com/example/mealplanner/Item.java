package com.example.mealplanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Item {
    String itemName;
    Double itemQuantity;
    String itemType;
    String itemCategory;

    public Item(String itemName, Double itemQuantity, String itemType, String itemCategory) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemType = itemType;
        this.itemCategory = itemCategory;
    }

    public Item(String itemName, String itemCategory, String itemType) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemType='" + itemType + '\'' +
                ", itemCategory='" + itemCategory + '\'' +
                '}';
    }

    public String toSimpleString() {
        return "itemName='" + itemName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemType='" + itemType + '\'';
    }

    public JSONObject toJSON() {
        JSONObject jsonItem = new JSONObject();
        jsonItem.put("itemName", itemName);
        jsonItem.put("itemQuantity", itemQuantity);
        jsonItem.put("itemType", itemType);
        jsonItem.put("itemCategory", itemCategory);
        return jsonItem;
    }



}
