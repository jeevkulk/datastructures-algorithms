package algorithm.string;

import java.util.Scanner;

public class DNAHealthProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] genes = new String[n];
        for(int genes_i = 0; genes_i < n; genes_i++){
            genes[genes_i] = in.next();
        }
        int[] health = new int[n];
        for(int health_i = 0; health_i < n; health_i++){
            health[health_i] = in.nextInt();
        }
        int s = in.nextInt();
        long totalHealth = 0;
        long maxTotalHealth = 0;
        for(int a0 = 0; a0 < s; a0++){
            int first = in.nextInt();
            int last = in.nextInt();
            String d = in.next();
            totalHealth = calculateTotalHealth(genes, health, first, last, d);
            if(maxTotalHealth < totalHealth) {
                maxTotalHealth = totalHealth;
            }
        }
    }

    private static long calculateTotalHealth(String[] genes, int[] health, int first, int last, String d) {
        long totalHealth = 0;
        for (int i = first; i < last; i++) {
            //totalHealth += getNumberOfOccurrences(genes[i], d) * health[i];
        }
        return totalHealth;
    }

    /*private static long getNumberOfOccurrences(String gene, String d) {
        char[] ch = gene.toCharArray();
        for (char c : ch) {

        }
    }*/
}
