package algorithm.string;

public class IsUnique {

    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique("ABCXYZabcxyzA", IsUniqueAlgorithms.HASHCODE));
        System.out.println(isUnique.isUnique("Jeevan", IsUniqueAlgorithms.BIT_VECTOR));
    }

    private boolean isUnique(String str, IsUniqueAlgorithms isUniqueAlgorithms) {
        switch (isUniqueAlgorithms) {
            case HASHCODE:
                return checkUniqueUsingHashcode(str);
            case BIT_VECTOR:
                return checkUniqueUsingBitVector(str);
        }
        return false;
    }

    /**
     * Assuming string contains ascii characters and not unicode
     */
    private boolean checkUniqueUsingHashcode(String str) {
        if(str.length() > 128)
            return false;
        boolean[] booleanArr = new boolean[128];
        for(char ch : str.toCharArray()) {
            int hashValue = (int)ch;
            if(booleanArr[hashValue]) {
                return false;
            }
            booleanArr[hashValue] = true;
        }
        return true;
    }

    private boolean checkUniqueUsingBitVector(String str) {
        int checker = 0;
        for(char ch : str.toCharArray()) {
            int value = (int)ch;
            if((checker & (1 << value)) > 0) {
                return false;
            }
            checker |= (1 << value);
        }
        return true;
    }
}

enum IsUniqueAlgorithms {
    BRUTE_FORCE,
    HASHCODE,
    BIT_VECTOR
}
