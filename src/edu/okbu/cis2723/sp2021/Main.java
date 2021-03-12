package edu.okbu.cis2723.sp2021;

public class Main {

    public static void main(String[] args) {
        DataExplorer data = new DataExplorer("mar-11-001.dat");
        data.readData();
        data.computeAverage();
        data.cleanData();
        data.findMinMax();
    }
}
