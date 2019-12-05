package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> jsonPairs;
    private List<String> names;

    public JsonObject(JsonPair... jsonPairs) {
        // ToDo
        this.jsonPairs = Arrays.asList(jsonPairs);
        List<JsonPair> result = new ArrayList<JsonPair>();
        int index;
        List<Integer> result_indexes = new ArrayList<Integer>();
        for (int i = 0; i < this.jsonPairs.size(); i++) {
            index = i;
            for (int j=i; j < this.jsonPairs.size(); j++) {
                if (this.jsonPairs.get(i).getName().equals(this.jsonPairs.get(j).getName())) {
                    index = j;
                }
            }
            if (result_indexes.contains(index)) {
                continue;
            }
            result_indexes.add(index);
        }
        for (int i: result_indexes) {
            result.add(this.jsonPairs.get(i));
        }
        this.jsonPairs = result;
    }

    @Override
    public String toJson() {
        // ToDo
        return "{" + getJsonObjBody() + "}";
    }

    private String getJsonObjBody() {
        String jsonStr = "";
        Iterator<JsonPair> jsonIterator = this.jsonPairs.iterator();
        while (jsonIterator.hasNext()) {
            JsonPair json = jsonIterator.next();
            jsonStr += json.toJson();
            if (jsonIterator.hasNext())
                jsonStr += ", ";
        }
        return jsonStr;
    }

    public void add(JsonPair jsonPair) {
        // ToDo
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        List<String> namez = Arrays.asList(names);
        List<JsonPair> needed = new ArrayList<JsonPair>();
        for (int i=0; i<this.jsonPairs.size(); i++) {
            if (namez.contains(this.jsonPairs.get(i).getName())) {
                needed.add(this.jsonPairs.get(i));
            }
        }
        JsonObject result = new JsonObject((JsonPair) needed);
        return result;
    }
}
