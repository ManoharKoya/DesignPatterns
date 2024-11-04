package org.example.dataformat.converter.adapter;

public interface DataTransformer {
    public Data transformFromXML();
    public Data transformFromJson();
    public Data transformFromCSV();
}
