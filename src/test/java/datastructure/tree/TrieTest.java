package datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TrieTest {

    private Trie trie;

    @Before
    public void setup() {
        trie = new Trie();
    }

    @Test
    public void TestTrieGetSize() {
        trie.addWord("jeevan");
        trie.addWord("jasween");
        trie.addWord("ranjeet");
        Assert.assertTrue(trie.getSize() == 3);
    }

    @Test
    public void TestTrieWhenWordIsPresent() {
        trie.addWord("jeevan");
        trie.addWord("jasween");
        trie.addWord("ranjeet");
        trie.printTrie();
        Assert.assertTrue(trie.isWordPresent("jeevan"));
    }

    @Test
    public void TestTrieWhenWordIsAbsent() {
        trie.addWord("jeevan");
        trie.addWord("jasween");
        trie.addWord("ranjeet");
        trie.printTrie();
        Assert.assertTrue(!trie.isWordPresent("jeevaaan"));
    }
}
