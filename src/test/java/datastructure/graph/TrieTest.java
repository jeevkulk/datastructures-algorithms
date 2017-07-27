package datastructure.graph;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TrieTest {

    private Trie trie;

    @Before
    public void setup() {
        trie = new Trie();
    }

    @Test
    public void TestTrie() {
        trie.addWord("jeevan".toCharArray(), 0, null);
        trie.addWord("jasween".toCharArray(), 0, null);
        trie.addWord("ranjeet".toCharArray(), 0, null);
        trie.dfs(null);
        Mockito.times(1);
    }

}
