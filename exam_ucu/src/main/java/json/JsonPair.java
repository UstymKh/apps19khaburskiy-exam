package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonPair extends Tuple<String, Json>{
    private String name;
    private Json value;
    public JsonPair(String name, Json value) {
        super(name, value);
        this.name = name;
        this.value = value;
    }

    public String toJson() {
        return "'" + this.name + "': " + this.value.toJson();
    }

    public void setValue(Json value) {
        this.value = value;
    }

    public Json getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}