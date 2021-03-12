package edu.okbu.cis2723.sp2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DataExplorer {
    private float[] theArray;
    private File theDataFile;
    private float average = 0.0f;
    private DecimalFormat averageFormat = new DecimalFormat("0.00");

    public DataExplorer(String theFileName) {
        // Store the data file as an instance variable, just in case it is needed.
        theDataFile = new File(theFileName);
    }

    /**
     * Method to read the data
     * @return True if the data is read successfully
     */
    public boolean readData() {
        try {
            // Create the scanner for reading the data
            Scanner fileScanner = new Scanner(theDataFile);

            // Read the number of elements and instantiate the array
            int numItems = fileScanner.nextInt();
            theArray = new float[numItems];

            // Use an index for assigning values to the array elements
            // We need to manually track this.
            int idx = 0;

            // Loop until there is nothing more in the file
            while (fileScanner.hasNext()) {
                // Read the data value and assign it to the array at the
                // current index position
                theArray[idx] = fileScanner.nextFloat();

                // Update the index
                idx++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data not found");
            return false;
        }

        // TODO Make this an exception
        return true;
    }

    /**
     * Method to compute the average of the numbers
     */
    public void computeAverage() {
        // Standard average initializations: the total and the number of items
        float total = 0.0f;
        float items = 0;

        // Iterate through all the data
        for (int idx = 0; idx < theArray.length; idx++) {
            // If the data value is beween 0.0 and 100.0, then update
            // the total and the number of items (for computing the average);
            // otherwise skip the data item
            if (theArray[idx] >= 0.0 && theArray[idx] <= 100.0) {
                total = total + theArray[idx];
                items++;
            }
        }

        average = total / items;
        System.out.println("Average = " + averageFormat.format(average));
    }

    /**
     * Method to find the minimum and maximum in the data
     */
    public void findMinMax() {
        // Standard min max initializations: indices of the minimum and maximum
        // in the data
        int minIdx = 0;
        int maxIdx = 0;

        // Iterate through all the data
        for (int idx = 1; idx < theArray.length; idx++) {
            // If the data value is greater than the maximum, then update
            // the index of the maximum
            if (theArray[idx] > theArray[maxIdx]) {
                maxIdx = idx;
            }
            // If the data value is less than the minimum, then update
            // the index of the minimum
            if (theArray[idx] < theArray[minIdx]) {
                minIdx = idx;
            }
        }

        System.out.println("\nMinimum = " + averageFormat.format(theArray[minIdx]));
        System.out.println("\nMaximum = " + averageFormat.format(theArray[maxIdx]));
    }

    /**
     * Method to clean the data (replace the invalid data with
     * the average).
     */
    public void cleanData() {
        // Iterate through all the data
        for (int idx = 0; idx < theArray.length; idx++) {
            // If the data value is beween 0.0 and 100.0, then update
            // the total and the number of items (for computing the average);
            // otherwise skip the data item
            if (theArray[idx] < 0.0 || theArray[idx] > 100.0) {
                theArray[idx] = average;
            }
        }
    }

    // Accessors
    public float[] getTheArray() { return this.theArray; }
    public File getTheDataFile() { return this.theDataFile; }
    public float getAverage() { return average; }

    // Mutators
    public void setTheArray(float[] a) { this.theArray = a; }
    public void setTheDataFile(File f) { this.theDataFile = f; }

    /**
     * For now, this is just a placeholder.
     * @return
     */
    public String toString() {
        // TODO implement toString()
        return "Data Explorer";
    }

    /**
     * Placeholder for now.
     * @param other The other data explorer
     * @return Alwasy true (for now)
     */
    public boolean equals(DataExplorer other) {
        // TODO implement equals()
        return true;
    }
}
