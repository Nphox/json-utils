package ru.nphox.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    public static void main(String[] args) throws IOException {

        String fieldName = "code";
        String fileName = "example.json";

        JsonNode node = new ObjectMapper().readTree(new File(fileName));
        JsonUtils.jsonTraversalSortByFieldName(node, fieldName);
        Writer writer = new FileWriter(new File("sorted.json"));
        writer.write(node.toString());
        writer.close();
    }
}