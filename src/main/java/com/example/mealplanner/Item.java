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
    int itemID;
    Double itemQuantity;
    String itemType;

    public Item(String itemName, int itemID, Double itemQuantity, String itemType) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemQuantity = itemQuantity;
        this.itemType = itemType;
    }
}
