package org.example.dataformat.converter.adapter;

public class CSVData extends Data{
    CSVData(String data) {
        this.data = data;
        this.dataType = DataType.CSV;
    }
}
