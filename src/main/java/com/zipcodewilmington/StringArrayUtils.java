package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {


    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        ArrayList<String> newArr = new ArrayList(Arrays.asList(array)); // converted array to ArrayList so i can use its "contains" method ... Thanks Leon
        Boolean isValueInArray = null;


        if (newArr.contains(value)) {
            isValueInArray = true;

        } else {

            isValueInArray = false;
        }

        return isValueInArray;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i]; // gets value at each index

            array[i] = array[array.length - i - 1];

            array[array.length - i - 1] = temp; // assigns temp value to current array index
        }


        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        Boolean result = null;
        for (int i = 0; i < array.length; i++) {

            if (array[i] == array[array.length - i -1]){ // compares if  array[current iteration] is same as array[array length - current iteration -1]
                                                            // first compares index 0 to index 4 then index 1 to index 3 and finally index 2 to index 2
                                                            //example ["a","b","c","b","a"]  = true
                                                            //indexes   0   1   2   3   4
                result = true;
            }
            else {
                result = false;
            }

        }
        return result;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {

        Boolean result = null;
        StringBuilder newStrings = new StringBuilder();

        for(String e : array){
            newStrings.append(e);     // appended each element in array to newString
        }

        String newString = newStrings.toString().replaceAll(" ", "").toLowerCase(); // removed spaces and  converted to lower case

         if(newString.length() < 26){  // if string length is less than 26 letter return false because there are only 26 letters in the alphabet

             result = false;
         }else {   // otherwise run this.  even though all tests passed im not sure this is the best solution. will improve it when I get better with Arrays

             for (int i = 0; i < newString.length(); i++) {
                 char letter = newString.charAt(i); // created a local char variable that holds value at current iteration

                 if (letter >= 'a' && letter <= 'z') {

                     result = true;
                 }

             }
         }

        return result;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {

        Integer counter = 0;
        for (int i = 0; i < array.length; i++) {

            if(array[i] == value){ // if array value at current iteration is equal to value  increment counter
                counter ++;

            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        ArrayList<String> newArr = new ArrayList<>(Arrays.asList(array)); // created ArrayList to be able to use the contains() which returns true or false

        for (int i = 0; i < array.length; i++) {

            if(newArr.contains(valueToRemove)){ // evaluates if newArr contains "Value to Remove"

                newArr.remove(valueToRemove); // will remove value in newArr if value is found
            }
        }
        return newArr.toArray(new String[0]); // converts newArr to an Array
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        String stringOfArr = "";
        stringOfArr = (array[0] + " "); // holds value at index 0
        for (int i = 1; i < array.length; i++) {
            String currentIndex  = array[i - 1]; // would start at index 0
            String  nextIndex = array[i];        // would start at index 1

            if(currentIndex != nextIndex){ // compares if current Index value is not equal to next Index value
                stringOfArr += (array[i] + " "); // if true it will add value at current index to stringArr
            }
        }
       String[] newArr = stringOfArr.split(" "); // created new Array by splitting by spaces

        return newArr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) { // Finally figured it out Thanks to Mike

        String stringOfArr = "";
        stringOfArr = (array[0]); // holds value at index 0
        for (int i = 1; i < array.length; i++) {
            String currentIndex  = array[i - 1]; // would start at index 0
            String  nextIndex = array[i];        // would start at index 1

            if(currentIndex == nextIndex){ // compares if current Index value is not equal to next Index value
                stringOfArr += (array[i]); // if true it will add value at current index to stringArr
            }
            else {

                stringOfArr +=( " " +array[i]); // Will add space before array at current index
            }

        }
        String[] newArr = stringOfArr.split(" "); // created new Array by splitting by spaces
        return newArr;
    }


}
