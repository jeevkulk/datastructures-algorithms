package puzzle.tree;

public class MaxNumberOfMoviesCalculator {

    /**
     * Creates a matrix representing a tree. '1' indicates that a movie starting at jth co-ordinate
     * and ending at ith co-ordinate can be viewed after the current.
     * @param startTime
     * @param endTime
     * @return
     */
	public int findMaxNumberOfMovies(int[] startTime, int[] endTime) {
		int[][] tree = new int[startTime.length][endTime.length];

		for (int j = 0; j < endTime.length; j++) {
			for (int i = 0; i < startTime.length; i++) {
				if (endTime[j] <= startTime[i] && i != j)
					tree[j][i] = 1;
				else
					tree[j][i] = 0;
			}
		}
		return findMaxDepth(tree);
	}
	
	private int findMaxDepth(int[][] tree) {
		int i, j, count = 0, maxCount = 0;
		for (i = 0; i < tree.length; i++) {
			for (j = 0; j < tree[i].length; j++) {
				if (tree[i][j] == 1) {
					count = dfs(tree, i, j);
					if (count > maxCount)
						maxCount = count;
				}
			}
		}
		return maxCount;
	}
	
	private int dfs(int[][] tree, int x, int y) {
		int i, j, count = 1;
		Stack stack = new Stack(100);
		int[][] visited = new int[tree.length][tree[0].length];
		for (j = 0; j < tree.length; j++) {
			for (i = 0; i < tree[j].length; i++) {
				visited[i][j] = 0;
			}
		}
		while (y != -1) {
			count ++;
			stack.push(x+"-"+y);
			visited[x][y] = 1;
			x = y;
			y = getNextUnvisitedVertex(tree, visited, y);
		}
		return count;
	}

	private int getNextUnvisitedVertex(int[][] tree, int[][] visited, int x) {
		int j;
		for (j = 0; j < tree[x].length; j++) {
			if (tree[x][j] == 1 && visited[x][j] == 0) {
				return j;
			}
		}
		return -1;
	}

    /**
     * To store the movies that can be watched after current.
     * No used in current scenario - but can be used to report
     * movies that can be watched just in case.
     */
	private class Stack {
		private String[] strArr = null;
		private int top = -1;

		public Stack(int size) {
            strArr = new String[size];
        }

		public void push(String str) {
            strArr[++top] = str;
		}

		public String pop() {
			return strArr[top--];
		}
	}
}
