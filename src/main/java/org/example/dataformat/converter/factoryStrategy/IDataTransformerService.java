package org.example.dataformat.converter.factoryStrategy;

public interface IDataTransformerService {
    public String transformData(String sourceData, DataType sourceType, DataType destinationType);
}
