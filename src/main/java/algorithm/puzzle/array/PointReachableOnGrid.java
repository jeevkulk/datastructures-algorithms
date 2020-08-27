package algorithm.puzzle.array;

public class PointReachableOnGrid {

    /**
     * To find if a point (x2, y2) is reachable on a grid - traversing either to (x1 + y1, y1) or (x1, x1 + y1)
     * every time.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public boolean isReachable(int x1, int y1, int x2, int y2) {
        if (x2 < x1 || y2 < y1) {
            return false;
        } else if (x1 == x2 && y1 == y2) {
            return true;
        }
        return isReachable(x1 + y1, y1, x2, y2) || isReachable(x1 , x1 + y1, x2, y2);
    }

    public static void main(String[] args) {
        PointReachableOnGrid pointReachableOnGrid = new PointReachableOnGrid();
        System.out.println("Is Reachable: "+pointReachableOnGrid.isReachable(2, 10, 26, 12));
    }
}
