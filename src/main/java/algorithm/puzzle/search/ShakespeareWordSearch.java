package algorithm.puzzle.search;

import datastructure.tree.Trie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ShakespeareWordSearch {

    private Logger log = LogManager.getLogger(ShakespeareWordSearch.class);

    public void execute() {
        long startTime = System.currentTimeMillis();

        List<String> dictionaryList = readFile("dictionary_webster.txt");
        Stream<String> dictionaryStream = dictionaryList.stream();
        Trie dictionaryTrie = populateTrie(dictionaryStream);
        //dictionaryTrie.printTrie();
        long numberOfWordsInDictionary = dictionaryTrie.getSize();

        List<String> wordList = readFile("words_shakespeare.txt");
        long totalNumberOfWordsUsedByShakespeare = wordList.stream().map(word -> word.toLowerCase()).distinct().count();
        long numberOfWordsInDictionaryUsedByShakespeare = wordList.stream().filter(word -> dictionaryTrie.isWordPresent(word)).count();
        long numberOfWordsNotUsedByShakespeare = numberOfWordsInDictionary - numberOfWordsInDictionaryUsedByShakespeare;
        long numberOfWordsUsedByShakespeareNotInDictionary = totalNumberOfWordsUsedByShakespeare - numberOfWordsInDictionaryUsedByShakespeare;

        log.info("Total Number of Distinct Words in Webster Dictionary: "+numberOfWordsInDictionary);
        log.info("Total Number of Distinct Words used by Shakespeare: "+totalNumberOfWordsUsedByShakespeare);
        log.info("Number of Words in dictionary used by Shakespeare: "+numberOfWordsInDictionaryUsedByShakespeare);
        log.info("Number of Words in dictionary but not used by Shakespeare: "+numberOfWordsNotUsedByShakespeare);
        log.info("Number of Words used by Shakespeare but not in dictionary: "+numberOfWordsUsedByShakespeareNotInDictionary);

        long endTime = System.currentTimeMillis();
        log.info("Total time to execute (in secs): "+(endTime - startTime)/(1000));
    }

    private List<String> readFile(String fileName) {
        List<String> wordList = null;
        URL url = this.getClass().getClassLoader().getResource(fileName);
        try {
            Path path = Paths.get(url.toURI());
            wordList = Files.readAllLines(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    private Trie populateTrie(Stream<String> wordStream) {
        Trie trie = new Trie();
        wordStream.forEach(word -> {
            trie.addWord(word.toLowerCase());
        });
        return trie;
    }

}
