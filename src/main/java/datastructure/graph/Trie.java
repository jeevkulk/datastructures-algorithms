package datastructure.graph;


import java.util.ArrayDeque;
import java.util.Deque;

public class Trie {

    private Node root;
    private Deque<Node> queue = new ArrayDeque<>();

    public Trie() {
        root = new Node();
    }

    public void addWord(char[] ch, int startPos, Node node) {
        if(startPos < ch.length)
            addChar(ch, startPos, root);
    }

    private void addChar(char[] ch, int pos, Node node) {
        Node newNode;
        int hash = ch[pos] - 'a';
        if((node.getBit() & 1 << hash) == 0) {
            node.setBit(getBit(node.getBit(), hash));
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

    public void dfs(Node node) {
        if(node == null)
            node = root;
        int bit = node.getBit();
        int[] bitPos = getBitPosition(bit);
        Node[] nodes = node.getNodes();
        for(int pos : bitPos) {
            System.out.print(getChar(pos));
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
