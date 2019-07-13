package algorithm.puzzle.string;

public class CheckPalindromePermutation {

    public static void main(String[] args) {
        CheckPalindromePermutation checkPalindromePermutation = new CheckPalindromePermutation();
        System.out.println(checkPalindromePermutation.checkPalindromePermutation("abc133831cba", CheckPalindromePermutationAlgorithms.HASHCODE));
    }

    private boolean checkPalindromePermutation(String inputStr, CheckPalindromePermutationAlgorithms checkPalindromePermutationAlgorithms) {
        switch (checkPalindromePermutationAlgorithms) {
            case HASHCODE:
                return checkPalindromePermutationUsingHashcode(inputStr);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Assuming string contains ascii characters and not unicode
     * Time complexity: O(N)
     * Space complexity: O(1)
     */
    private boolean checkPalindromePermutationUsingHashcode(String inputStr) {
        int bitVector = 0;
        for(int ch : inputStr.toCharArray()) {
            bitVector ^= (1 << ch);
        }
        if((bitVector & (bitVector - 1)) == 0)
            return true;
        else
            return false;
    }
}

enum CheckPalindromePermutationAlgorithms {
    BRUTE_FORCE,
    HASHCODE,
    SORT_AND_COMPARE
}
