package ru.nphox.json;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Comparator;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class JsonFieldComparator implements Comparator<JsonNode> {

    private String fieldName;

    @Override
    public int compare(JsonNode o1, JsonNode o2) {
        return o1.get(this.fieldName).toString().compareTo(o2.get(this.fieldName).toString());
    }
}