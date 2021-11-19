package com.infosys.aboutcanada.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.infosys.aboutcanada.model.RowsItem;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class DataConverter implements Serializable {

    @TypeConverter // note this annotation
    public String fromList(List<RowsItem> optionValues) {
        if (optionValues == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<RowsItem>>() {
        }.getType();
        String json = gson.toJson(optionValues, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<RowsItem> toList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<RowsItem>>() {
        }.getType();
        List<RowsItem> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }
}
