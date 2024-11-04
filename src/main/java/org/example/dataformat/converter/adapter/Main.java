package org.example.dataformat.converter.adapter;

public class Main {
    public static void main(String[] args) {
        JsonData sourceData = new JsonData("Some Json data");
        XMLAdapter xmlAdapter = new XMLAdapter(sourceData);
        XMLData data = xmlAdapter.adapt();
        System.out.println(data.data);
    }
}
