package algorithm.string;

public class HasUniqueChars {

    public static void main(String[] args) {
        HasUniqueChars hasUniqueChars = new HasUniqueChars();
        System.out.println(hasUniqueChars.hasUniqueChars("ABCXYZabcxyzA", HasUniqueCharsAlgorithms.HASHCODE));
        System.out.println(hasUniqueChars.hasUniqueChars("ABCXYZabcxyzA", HasUniqueCharsAlgorithms.BIT_VECTOR));
    }

    private boolean hasUniqueChars(String inputStr, HasUniqueCharsAlgorithms hasUniqueCharsAlgorithms) {
        switch (hasUniqueCharsAlgorithms) {
            case HASHCODE:
                return checkUniqueUsingHashcode(inputStr);
            case BIT_VECTOR:
                return checkUniqueUsingBitVector(inputStr);
        }
        return false;
    }

    /**
     * Assuming string contains ascii characters and not unicode
     */
    private boolean checkUniqueUsingHashcode(String inputStr) {
        if(isNotUnique(inputStr))
            return false;
        boolean[] booleanArr = new boolean[128];
        for(char ch : inputStr.toCharArray()) {
            int hashValue = (int)ch;
            if(booleanArr[hashValue]) {
                return false;
            }
            booleanArr[hashValue] = true;
        }
        return true;
    }

    private boolean checkUniqueUsingBitVector(String inputStr) {
        if(isNotUnique(inputStr))
            return false;
        int checker = 0;
        for(char ch : inputStr.toCharArray()) {
            int value = (int)ch;
            if((checker & (1 << value)) > 0) {
                return false;
            }
            checker |= (1 << value);
        }
        return true;
    }

    /**
     * Basic check which returns true if it is definitely not unique
     * @param inputStr
     * @return
     */
    private boolean isNotUnique(String inputStr) {
        boolean isNotUnique = false;
        if(inputStr.length() > 128)
            return true;
        return isNotUnique;
    }
}

enum HasUniqueCharsAlgorithms {
    BRUTE_FORCE,
    HASHCODE,
    BIT_VECTOR,
    SORT_AND_COMPARE
}
