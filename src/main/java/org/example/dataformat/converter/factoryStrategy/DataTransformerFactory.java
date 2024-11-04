package org.example.dataformat.converter.factoryStrategy;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class DataTransformerFactory {

    public static DataTransformer getDataTransformer(DataType sourceType, DataType destinationType) {
        HashMap<Map.Entry<DataType, DataType>, DataTransformer> dataTransformerMap = null;
        dataTransformerMap.put(new AbstractMap.SimpleEntry<>(DataType.CSV, DataType.JSON), CSVToJsonTransformer.getInstance());
        dataTransformerMap.put(new AbstractMap.SimpleEntry<>(DataType.JSON, DataType.CSV), JsonToCSVTransformer.getInstance());
        dataTransformerMap.put(new AbstractMap.SimpleEntry<>(DataType.XML, DataType.JSON), XMLToJsonTransformer.getInstance());

        Map.Entry<DataType, DataType> dataTransform = new AbstractMap.SimpleEntry<>(sourceType, destinationType);

        return dataTransformerMap.get(dataTransform);
    }
}
