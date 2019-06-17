package datastructure.puzzle.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * There is a collection of N strings ( There can be multiple occurrences of a particular string).
 * Each string's length is no more than 20 characters. There are also Q queries. For each query,
 * you are given a string, and you need to find out how many times this string occurs in the given
 * collection of N strings.
 *
 * Input Format:
 * The first line contains N, the number of strings.
 * The next N lines each contain a string.
 * The N+2nd line contains Q, the number of queries.
 * The following Q lines each contain a query string.
 *
 * Sample Input:
 * 4
 * aba
 * baba
 * aba
 * xzxb
 * 3
 * aba
 * xzxb
 * ab
 *
 * Sample Output:
 * 2
 * 1
 * 0
 */

public class FindNumberOfOccurrences {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStrings; i++) {
            String str = scanner.nextLine();
            if (map.containsKey(str)) {
                int occurrence = map.get(str);
                map.put(str, occurrence + 1);
            } else {
                map.put(str, 1);
            }
        }

        int numberOfQueries = Integer.parseInt(scanner.nextLine());
        int numberOfOccurrence = 0;
        for (int i = 0; i < numberOfQueries; i++) {
            numberOfOccurrence = 0;
            String str = scanner.nextLine();
            if (map.containsKey(str)) {
                numberOfOccurrence = map.get(str);
                System.out.println(numberOfOccurrence);
            } else {
                System.out.println(numberOfOccurrence);
            }
        }
    }
}
