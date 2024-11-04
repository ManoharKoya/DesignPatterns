package org.example.dataformat.converter.factoryStrategy;

public class DataTransformerService implements IDataTransformerService{
    @Override
    public String transformData(String sourceData, DataType sourceType, DataType destinationType) {
        DataTransformer dataTransformer = DataTransformerFactory.getDataTransformer(sourceType, destinationType);
        return dataTransformer.transform(sourceData);
    }
}
