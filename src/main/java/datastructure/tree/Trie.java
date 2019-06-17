package datastructure.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Trie {

    private Logger log = LogManager.getLogger(Trie.class);

    private Node root;

    private int count = 0;

    private final String END_OF_WORD_CHAR = "|";

    public Trie() {
        root = new Node();
    }

    /**
     * Method to add word to trie
     * @param word
     */
    public void addWord(String word) {
        if(word != null) {
            word = word.concat(END_OF_WORD_CHAR);
            word = word.toLowerCase();
            char[] ch = word.toCharArray();
            addChar(ch, 0, root);
        }
    }

    private void addChar(char[] ch, int pos, Node node) {
        Node newNode;
        int hash = getHash(ch[pos]);
        if((node.getBit() & 1 << hash) == 0) {
            node.setBit(getBit(node.getBit(), hash));
            if(ch[pos] == END_OF_WORD_CHAR.toCharArray()[0]) {
                count++;
            }
            newNode = new Node();
            Node[] nodes = node.getNodes();
            nodes[hash] = newNode;
        }
        else {
            Node[] nodes = node.getNodes();
            newNode = nodes[hash];
        }
        if(++pos < ch.length)
            addChar(ch, pos, newNode);
    }

    private int getBit(int bit, int hash) {
        int newBit = bit | 1 << hash;
        return newBit;
    }

    public int getSize() {
        return count;
    }

    public void printTrie() {
        dfs(root);
    }

    private void dfs(Node node) {
        int bit = node.getBit();
        int[] bitPos = getBitPosition(bit);
        Node[] nodes = node.getNodes();
        for(int pos : bitPos) {
            log.info(getChar(pos));
            dfs(nodes[pos]);
        }
    }

    private int[] getBitPosition(int inputNumber) {
        int[] bitPos = new int[32];
        int ctr = 0, bitPosCtr = 0, index = 0;
        while (inputNumber != 0) {
            if ((inputNumber & 1) == 1)
                bitPos[bitPosCtr++] = index;
            inputNumber = inputNumber >> 1;
            index++;
        }
        int[] newBitPos = new int[bitPosCtr];
        for(int i = 0; i < bitPosCtr; i++)
            newBitPos[i] = bitPos[i];
        return newBitPos;
    }

    public boolean isWordPresent(String word) {
        boolean isPresent = false;
        if(word != null) {
            word = word.concat(END_OF_WORD_CHAR);
            word = word.toLowerCase();
            char[] ch = word.toCharArray();
            isPresent = checkChar(ch, 0, root);
        }
        return isPresent;
    }

    private boolean checkChar(char[] ch, int pos, Node node) {
        boolean isPresent = false;
        int bit = node.getBit();
        int hash = getHash(ch[pos]);
        if((bit & 1 << hash) != 0) {
            if(++pos < ch.length) {
                Node[] nodes = node.getNodes();
                Node newNode = nodes[hash];
                isPresent = checkChar(ch, pos, newNode);
            }
            else
                isPresent = true;
        }
        else
            isPresent = false;
        return isPresent;
    }

    /**
     * Assuming ASCII characters
     * @param ch
     * @return
     */
    private int getHash(char ch) {
        return (int)(ch - 'a');
    }

    private char getChar(int pos) {
        return (char)(pos + 'a');
    }

    class Node {
        int bit;
        Node[] nodes;

        public Node() {
            this.nodes = new Node[32];
        }

        public int getBit() {
            return bit;
        }

        public void setBit(int bit) {
            this.bit = bit;
        }

        public Node[] getNodes() {
            return nodes;
        }

        public void setNode(Node[] nodes) {
            this.nodes = nodes;
        }
    }
}
