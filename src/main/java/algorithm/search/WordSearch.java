package algorithm.search;

import datastructure.graph.Trie;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordSearch {

    public void execute() {
        Trie dictionaryTrie = readFile("dictionary_webster.txt");
        dictionaryTrie.printTrie();
    }

    private Trie readFile(String fileName) {
        Trie trie = new Trie();
        URL url = this.getClass().getClassLoader().getResource(fileName);
        try {
            Path path = Paths.get(url.toURI());
            Stream<String> stream = Files.lines(path);
            stream.forEach(word -> {
                trie.addWord(word.toLowerCase());
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trie;
    }

}
