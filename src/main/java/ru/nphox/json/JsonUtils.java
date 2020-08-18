package ru.nphox.json;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void jsonTraversalSortByFieldName(JsonNode root, String fieldName){
        if(root.isObject()){
            Iterator<JsonNode> iterator = root.iterator();
            while(iterator.hasNext()) {
                jsonTraversalSortByFieldName(iterator.next(), fieldName);
            }
        } else if(root.isArray()){
            ArrayNode arrayNode = (ArrayNode) root;
            sortArrayNode(arrayNode, fieldName);
            for(int i = 0; i < arrayNode.size(); i++) {
                jsonTraversalSortByFieldName(arrayNode.get(i), fieldName);
            }
        }
    }

    public static void sortArrayNode(ArrayNode arrayNode, String fieldName){
        List<JsonNode> nodeList = new ArrayList<>();
        for(int i = 0; i < arrayNode.size(); i++) {
            if(arrayNode.get(i).has(fieldName)){
                nodeList.add(arrayNode.get(i));
            }
        }
        Collections.sort(nodeList, new JsonFieldComparator(fieldName));
        for(int i = 0; i < nodeList.size(); i++) {
            arrayNode.set(i, nodeList.get(i));
        }
    }
}
