package com.mkyong.json.jsonsimple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileWriter;
import java.io.IOException;

public class JSONfile {

    public static void main(String[] args) {

        // JSON String
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("studentName", "Jesus Martinez");
        jsonObject.put("age", "21");

        // JSON Array
        JsonArray grades = new JsonArray();
        grades.add("Spanish: 96");
        grades.add("Math I: 86");
        grades.add("English II: 90");

        jsonObject.put("uni app", grades);

        try (FileWriter fileWriter = new FileWriter("uniapp.json")) {

            Jsoner.serialize(jsonObject, fileWriter);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
