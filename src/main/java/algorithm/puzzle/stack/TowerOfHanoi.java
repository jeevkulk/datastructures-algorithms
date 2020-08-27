package algorithm.puzzle.stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        int numberOfCoinsStacked = 25;
        for (int i = 0; i < numberOfCoinsStacked; i++) {
            System.out.println("Moves required to move coins from stack S to stack D = "
                    +towerOfHanoi.moves(i, 'S', 'D', 'A'));
        }
    }

    /**
     * Tail Recursion implemented - this is space optimized
     * @param numberOfCoinsStacked
     * @param sourceStack
     * @param destinationStack
     * @param auxiliaryStack
     * @return
     */
    public int moves(int numberOfCoinsStacked, char sourceStack, char destinationStack, char auxiliaryStack) {
        //Base Condition
        if (numberOfCoinsStacked == 0 || numberOfCoinsStacked == 1) {
            return numberOfCoinsStacked;
        }
        return moves(numberOfCoinsStacked - 1, 'S', 'A', 'D')
                + 1 + moves(numberOfCoinsStacked - 1, 'A', 'D', 'S');
    }
}
