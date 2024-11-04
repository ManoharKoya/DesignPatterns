package org.example.dataformat.converter.adapter;

public abstract class DataAdapter implements DataTransformer{

    protected Data data;

    public Data getData() {
        return data;
    }
    DataAdapter(Data data) {
        this.data = data;
    }

    public Data adapt() {
        switch (this.data.dataType) {
            case CSV -> {
                return this.transformFromCSV();
            }
            case JSON -> {
                return this.transformFromJson();
            }
            case XML -> {
                return this.transformFromXML();
            }
        }
        return null;
    }
}

