package org.example.dataformat.converter.factoryStrategy;

public class XMLToJsonTransformer implements DataTransformer{

    public static XMLToJsonTransformer xmlToJsonTransformer;

    public static XMLToJsonTransformer getInstance() {
        if(xmlToJsonTransformer == null) {
            xmlToJsonTransformer = new XMLToJsonTransformer();
        }
        return xmlToJsonTransformer;
    }
    @Override
    public String transform(String sourceData) {
        // transform logic
        return null;
    }
}
