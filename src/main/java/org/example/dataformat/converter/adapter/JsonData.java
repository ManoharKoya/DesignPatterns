package org.example.dataformat.converter.adapter;

public class JsonData extends Data{
    JsonData(String data) {
        this.dataType = DataType.JSON;
        this.data = data;
    }
}
