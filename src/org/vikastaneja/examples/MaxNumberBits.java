package org.vikastaneja.examples;

/**
 * Created by vikastaneja on 5/24/14.
 */
public class MaxNumberBits {

    public static boolean[] stringToBitarray(String s) {
        if (s == null || s.isEmpty()) {
            throw new RuntimeException("String is null or empty");
        }

        char[] carray = s.toCharArray();
        int numOfValidChar = 0;
        for(int i = 0; i < carray.length; i++) {
            if (carray[i] != ' ') {
                numOfValidChar++;
            }
        }

        boolean[] barray = new boolean[numOfValidChar];
        for (int i = 0, j = 0; i < carray.length && j < numOfValidChar; i++) {
            if (carray[i] != ' ') {
                barray[j] = carray[i] == '0' ? false : true;
                j++;
            }
        }

        return barray;
    }

    public static int FindMax(boolean[] bitArray) {
        if (bitArray == null || bitArray.length == 0)
            return 0;

        int[] temp = new int[bitArray.length];
        int total = 0;

        for (int i = 0; i < temp.length; i++) {
            total += bitArray[i] == true ? 1 : 0;
            temp[i] = bitArray[i] == true ? -1 : 1;
        }

        int temp1 = 0, temp2 = 0;
        int left1 = 0, left2 = 0;
        int right1 = 0, right2 = 0;
        for (int i = 0; i < temp.length; i++) {
            if ((temp2 + temp[i]) >= 0) {
                temp2 += temp[i];
            } else {
                left2 = i + 1;
                temp2 = 0;
            }

            if (temp1 < temp2) {
                left1 = left2;
                right1 = i;
                temp1 = temp2;
            }
        }

        return total + temp1;
    }

}