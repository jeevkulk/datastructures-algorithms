package algorithm.array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class ArrayRotation {

    private static Logger logger = LogManager.getLogger(ArrayRotation.class);

    public static void main(String[] args) {
        ArrayRotation arrayRotation = new ArrayRotation();
        int[] arrInt1 = arrayRotation.acceptInputLine("Please input two space-separated integers denoting the respective values of (the number of integers) and  (the number of left rotations that must be performed):", 2);
        if(arrInt1[1] > arrInt1[0]) {
            logger.info("Rotation value cannot be greater than length of array!");
            System.exit(-1);
        }
        int[] arrInt2 = arrayRotation.acceptInputLine("Please input 'n' space-separated integers describing the respective elements of the array's initial state:", arrInt1[0]);
        int[] rotatedArr = arrayRotation.rotateArray(arrInt2, arrInt1[1]);
        arrayRotation.printArray(rotatedArr);
    }

    private int[] acceptInputLine(String inputFor, int expectedNumberOfElements) {
        String inputLine = null;
        try {
            logger.info(inputFor);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            inputLine = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getIntArray(inputLine, expectedNumberOfElements);
    }

    private int[] getIntArray(String inputLine1, int expectedElements) {
        String[] str1 = inputLine1.split(" ");
        int[] arrInt = new int[expectedElements];
        int i = 0;
        for(String str : str1) {
            arrInt[i++] = Integer.parseInt(str);
        }
        return arrInt;
    }

    public int[] rotateArray(int[] arrInt, int rotateBy) {
        int i = 0, j = 0, k = 0;
        int index = 0;
        int[] tempArr = new int[rotateBy];
        for (i=0; i<arrInt.length; i++) {
            if (j < tempArr.length) {
                index = (i + rotateBy < arrInt.length) ? i + rotateBy : i + rotateBy - arrInt.length;
                tempArr[j++] = arrInt[index];
                arrInt[index] = arrInt[i];
            } else if (j == tempArr.length) {
                index = (i + rotateBy < arrInt.length) ? i + rotateBy : i + rotateBy - arrInt.length;
                int temp = arrInt[index];
                arrInt[index] = tempArr[k];
                tempArr[k++] = temp;
                if (k == tempArr.length)
                    k = 0;
            }
        }
        return arrInt;
    }

    private void printArray(int[] arrInt) {
        StringBuilder sb = new StringBuilder();
        logger.info("Rotated Array: ");
        for(int i : arrInt) {
            sb.append(i+" ");
        }
        logger.info(sb.toString());
    }
}
