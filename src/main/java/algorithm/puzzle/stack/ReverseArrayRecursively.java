package algorithm.puzzle.stack;

public class ReverseArrayRecursively {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        ReverseArrayRecursively reverseArrayRecursively = new ReverseArrayRecursively();
        reverseArrayRecursively.doPrint(arr, 0);
    }

    /**
     * Non-tail recursion - this is space heavy
     * @param arr
     * @param i
     */
    private void doPrint(int[] arr, int i) {
        //end condition
        if (i >= arr.length) {
            return;
        }

        //In-order Logic
        System.out.println("Before call =>"+arr[i]);

        //call recursively
        doPrint(arr, ++i);

        //Reverse-order Logic
        System.out.println("After call =>"+arr[i - 1]);
    }
}
