
package com.mkyong.json.jsonsimple;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileReader;
import java.io.IOException;

    public class Read {

        public static void main(String[] args) {

            try (FileReader reader = new FileReader("uniapp.json")) {

                JsonObject jsonObject = (JsonObject) Jsoner.deserialize(reader);

                // read value one by one manually
                System.out.println((String) jsonObject.get("studentName"));
                System.out.println((jsonObject.get("age").toString()));

                // loops the array
                JsonArray msg = (JsonArray) jsonObject.get("uni app");
                for (Object o : msg) {
                    System.out.println(o);
                }

            } catch (IOException | JsonException e) {
                throw new RuntimeException(e);
            }

        }

    }

