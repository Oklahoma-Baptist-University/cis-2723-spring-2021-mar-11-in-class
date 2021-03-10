# CIS 2723 Spring 2021 Mar 11 In Class

Write Java program(s) to do the following
<ul>
  <li>Create a class with a single instance variable named theArray. This variable is an array of floats.
  <li>Create a method to read in the data:
  <ul>
     <li>Open the file mar-11-001.dat for reading. The first line is the number of elements in the array. Each subsequent line is a floating point number.
     <li>Read the number of elements in the array and declare and instantiate an array of that size.
     <li>Read in the rest of the data, assigning the value read in to an element in the array.
  </ul>
  <li>Create a method to compute the average of the data. Print out the result formatted to 2 decimal points. If a value is < 0.0 or greater than 100.0, then <i>do not</i> include it in the calculation of the average
  <li>Create a method to clean the data. This method replaces values < 0.0 or > 100.0 with the average computed above
  <li>Create a method to find the minimim and maximum values in the data. Print out the results formatted to 2 decimal places
  <li>In the main method
  <ul>
    <li>Create an instance of the class
    <li>Call the method to read in the data
    <li>Call the method to clean the data
    <li>Call the method to find the minimum and maximum
  </ul>
</ul>
