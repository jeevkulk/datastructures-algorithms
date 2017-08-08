package datastructure.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LinkedHashMapTest {

    private LinkedHashMap<String, String> linkedHashMap;

    @Before
    public void setup() {
        linkedHashMap = new LinkedHashMap();
    }

    @Test
    public void testPut() {
        String keyStr = "India";
        String valueStr = "New Delhi";

        linkedHashMap.put(keyStr, valueStr);
        Assert.assertTrue(linkedHashMap.get(keyStr).equals(valueStr));
    }

    @Test
    public void testRehash() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(4);
        linkedHashMap = populateLinkedHashMap(linkedHashMap);
        Assert.assertTrue(testEntries(linkedHashMap));
    }

    @Test
    public void testRemove() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(4);
        linkedHashMap = populateLinkedHashMap(linkedHashMap);
        String keyStr = "Pakistan";
        linkedHashMap.remove(keyStr);
        Assert.assertTrue(linkedHashMap.get(keyStr) == null);
    }

    @Test
    public void testAccessOrder() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(4, 5, 0.75f, LinkedHashMap.Order.ACCESS_ORDER);
        linkedHashMap = populateLinkedHashMap(linkedHashMap);
        Assert.assertTrue(testEntries(linkedHashMap));

        String keyStr = "India";
        String valueStr = "New Delhi";
        linkedHashMap.get(keyStr);

        keyStr = "Japan";
        valueStr = "Tokyo";
        linkedHashMap.put(keyStr, valueStr);

        keyStr = "Pakistan";
        Assert.assertTrue(linkedHashMap.get(keyStr) == null);
    }

    @Test
    public void testAccessFrequencyOrder() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(4, 5, 0.75f, LinkedHashMap.Order.ACCESS_FREQUENCY_ORDER);
        linkedHashMap = populateLinkedHashMap(linkedHashMap);
        Assert.assertTrue(testEntries(linkedHashMap));

        String keyStr = "India";
        String valueStr = "New Delhi";
        linkedHashMap.get(keyStr);

        keyStr = "Japan";
        valueStr = "Tokyo";
        linkedHashMap.put(keyStr, valueStr);

        keyStr = "Pakistan";
        Assert.assertTrue(linkedHashMap.get(keyStr) == null);
    }

    private LinkedHashMap<String, String> populateLinkedHashMap(LinkedHashMap<String, String> linkedHashMap) {
        String keyStr = "India";
        String valueStr = "New Delhi";
        linkedHashMap.put(keyStr, valueStr);

        keyStr = "Pakistan";
        valueStr = "Islamabad";
        linkedHashMap.put(keyStr, valueStr);

        keyStr = "Bangladesh";
        valueStr = "Dhaka";
        linkedHashMap.put(keyStr, valueStr);

        keyStr = "Sri Lanka";
        valueStr = "Colombo";
        linkedHashMap.put(keyStr, valueStr);

        keyStr = "USA";
        valueStr = "Washington DC";
        linkedHashMap.put(keyStr, valueStr);
        return linkedHashMap;
    }

    private boolean testEntries(LinkedHashMap<String, String> linkedHashMap) {
        String keyStr = "India";
        String valueStr = "New Delhi";
        if(!linkedHashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "Pakistan";
        valueStr = "Islamabad";
        if(!linkedHashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "Bangladesh";
        valueStr = "Dhaka";
        if(!linkedHashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "Sri Lanka";
        valueStr = "Colombo";
        if(!linkedHashMap.get(keyStr).equals(valueStr))
            return false;

        keyStr = "USA";
        valueStr = "Washington DC";
        if(!linkedHashMap.get(keyStr).equals(valueStr))
            return false;

        return true;
    }
}
