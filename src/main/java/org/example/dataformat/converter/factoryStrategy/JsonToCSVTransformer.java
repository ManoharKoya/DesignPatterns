package org.example.dataformat.converter.factoryStrategy;

public class JsonToCSVTransformer implements DataTransformer{
    public static JsonToCSVTransformer jsonToCSVTransformer;

    public static JsonToCSVTransformer getInstance() {
        if(jsonToCSVTransformer == null) {
            jsonToCSVTransformer = new JsonToCSVTransformer();
        }
        return jsonToCSVTransformer;
    }
    @Override
    public String transform(String sourceData) {
        // transform logic
        return null;
    }
}
