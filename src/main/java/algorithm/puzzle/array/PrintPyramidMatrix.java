package algorithm.puzzle.array;

import java.util.ArrayList;
import java.util.List;

public class PrintPyramidMatrix {

    public static void main(String[] args) {
        PrintPyramidMatrix printPyramidMatrix = new PrintPyramidMatrix();
        List<List<Integer>> list = printPyramidMatrix.prettyPrint(4);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }

    public List<List<Integer>> prettyPrint(int A) {
        List<List<Integer>> list2 = new ArrayList<>();
        for (int y = A; y >= -A; y--) {
            List<Integer> list1 = new ArrayList<>();
            for (int x = -A; x <= A; x++) {
                list1.add(Math.max(Math.abs(x), Math.abs(y)));
            }
            list2.add(list1);
        }
        return list2;
    }
}
