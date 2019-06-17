package datastructure.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HashMapTest {

    private HashMap<String, String> hashMap;

    @Before
    public void setup() {
        hashMap = new HashMap<>();
    }

    @Test
    public void testPut() {
        String keyStr = "India";
        String valueStr = "New Delhi";

        hashMap.put(keyStr, valueStr);
        Assert.assertTrue(hashMap.get(keyStr).equals(valueStr));
    }

    @Test
    public void testRehash() {
        HashMap<String, String> hashMap = populateHashMap();
        Assert.assertTrue(testEntries(hashMap));
    }

    @Test
    public void testRemove() {
        HashMap<String, String> hashMap = populateHashMap();
        String keyStr = "Pakistan";
        hashMap.remove(keyStr);
        Assert.assertTrue(hashMap.get(keyStr) == null);
    }

    public HashMap<String, String> populateHashMap() {
        HashMap<String, String> hashMap = new HashMap<>(4);
        String keyStr = "India";
        String valueStr = "New Delhi";
        hashMap.put(keyStr, valueStr);

        keyStr = "Pakistan";
        valueStr = "Islamabad";
        hashMap.put(keyStr, valueStr);

        keyStr = "Bangladesh";
        valueStr = "Dhaka";
        hashMap.put(keyStr, valueStr);

        keyStr = "Sri Lanka";
        valueStr = "Colombo";
        hashMap.put(keyStr, valueStr);

        keyStr = "USA";
        valueStr = "Washington DC";
        hashMap.put(keyStr, valueStr);
        return hashMap;
    }

    public boolean testEntries(HashMap<String, String> hashMap) {
        String keyStr = "India";
        String valueStr = "New Delhi";
        if(!hashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "Pakistan";
        valueStr = "Islamabad";
        if(!hashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "Bangladesh";
        valueStr = "Dhaka";
        if(!hashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "Sri Lanka";
        valueStr = "Colombo";
        if(!hashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "USA";
        valueStr = "Washington DC";
        if(!hashMap.get(keyStr).equals(valueStr))
            return false;

        return true;
    }

}
