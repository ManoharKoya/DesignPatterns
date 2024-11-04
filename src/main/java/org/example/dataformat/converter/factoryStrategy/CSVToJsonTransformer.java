package org.example.dataformat.converter.factoryStrategy;

public class CSVToJsonTransformer implements DataTransformer {

    public static CSVToJsonTransformer csvToJsonTransformer;

    public static CSVToJsonTransformer getInstance() {
        if(csvToJsonTransformer == null) {
            csvToJsonTransformer = new CSVToJsonTransformer();
        }
        return csvToJsonTransformer;
    }

    @Override
    public String transform(String sourceData) {
        // transform logic
        return null;
    }
}
