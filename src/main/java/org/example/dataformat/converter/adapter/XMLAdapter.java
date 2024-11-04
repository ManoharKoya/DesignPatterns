package org.example.dataformat.converter.adapter;

public class XMLAdapter extends DataAdapter{
    XMLAdapter(Data data) {
        super(data);
    }

    public XMLData adapt() {
        Data data = super.adapt();
        return new XMLData(data.data);
    }

    @Override
    public XMLData transformFromXML() {
        return new XMLData(this.data.data);
    }

    @Override
    public XMLData transformFromJson() {
        // logic
        return null;
    }

    @Override
    public XMLData transformFromCSV() {
        // logic
        return null;
    }
}
