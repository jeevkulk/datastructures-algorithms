package algorithm.puzzle.string;

import java.util.ArrayList;
import java.util.List;

public class AnagramLocator {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> strList) {
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        List<Integer> hashValueList = new ArrayList<>();
        for (String str : strList) {
            hashValueList.add(getHashValue(str));
        }
        for (int i = 0; i < hashValueList.size(); i++) {
            int currentHashValue = hashValueList.get(i);
            ArrayList<Integer> resultList = new ArrayList<>();
            while (hashValueList.contains(currentHashValue)) {
                int index = hashValueList.indexOf(currentHashValue);
                resultList.add(index);
            }
            finalResult.add(resultList);
        }
        return finalResult;
    }

    private int getHashValue(String str) {
        int hashValue = 0;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            hashValue = hashValue + c;
        }
        return hashValue;
    }
}
