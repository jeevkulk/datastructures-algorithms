package datastructure.graph;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void addWord(String word) {
        char[] ch = word.toCharArray();
        addChar(ch, 0, root);
    }

    private void addChar(char[] ch, int pos, Node node) {
        Node newNode;
        int hash = getHash(ch[pos]);
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

    public void printTrie() {
        dfs(root);
    }

    private void dfs(Node node) {
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
