package algorithm.puzzle.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hashing Algorithm
 *
 * Description:
 * Design a simple hashing algorithm which hashes different string keys to different integer values. Note that you will
 * be given three different strings in each test case and your algorithm should always hash them to different integers
 * in the range of 0 to 9 (both included). You just have to modify the hashFunction method of the Source class. Do not
 * change the main method. If your algorithm works correctly, ‘Correct’ will be printed on the output, and nothing will
 * be printed if it doesn't.
 *
 * Sample input:
 * ABC
 * DEF
 * GHI
 */

public class ASCIIBasedHashFunction {
    static int hashFunction(String key) {
        int hashValue = 0;
        char[] charArray = key.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            hashValue = hashValue + (31 * (i + 1) * charArray[i]);
        }
        hashValue = hashValue % 10;
        System.out.println(hashValue);
        return hashValue;
    }

    public static void main(String[] args) throws IOException{
        int[] array = new int[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++)
            array[i] = hashFunction(br.readLine());
        int flag = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = j + 1; k < 3; k++) {
                if (array[k] > 9 || array[j] > 9 || (k != j && array[k] == array[j])) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)
                break;
        }
        if (flag == 0)
            System.out.println("Correct");
    }
}
