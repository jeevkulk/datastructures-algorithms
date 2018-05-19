package algorithm.common.string;

public class CheckPermutation {

    public static void main(String[] args) {
        CheckPermutation checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.checkPermutation("A BC", "A BC", CheckPermutationAlgorithms.HASHCODE));
    }

    private boolean checkPermutation(String inputStr1, String inputStr2, CheckPermutationAlgorithms checkPermutationAlgorithms) {
        switch (checkPermutationAlgorithms) {
            case HASHCODE:
                return checkPermutationUsingHashcode(inputStr1, inputStr2);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Assuming string contains ascii characters and not unicode
     * Time complexity: O(N)
     * Space complexity: O(N)
     */
    private boolean checkPermutationUsingHashcode(String inputStr1, String inputStr2) {
        if(isNotPermutation(inputStr1, inputStr2))
            return false;
        int[] intArr = new int[128];
        for(int i = 0; i < inputStr1.length(); i++) {
            int val1 = inputStr1.charAt(i);
            intArr[val1]++ ;
            int val2 = inputStr2.charAt(i);
            intArr[val2]-- ;
        }
        for(int i = 0; i < intArr.length; i++) {
            if (intArr[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * Basic check which returns true if it is not a permutation
     * @param inputStr1
     * @param inputStr2
     * @return
     */
    private boolean isNotPermutation(String inputStr1, String inputStr2) {
        boolean isNotPermutation = false;
        if(inputStr1.length() != inputStr2.length())
            isNotPermutation = true;
        return isNotPermutation;
    }
}

enum CheckPermutationAlgorithms {
    BRUTE_FORCE,
    HASHCODE,
    SORT_AND_COMPARE
}
