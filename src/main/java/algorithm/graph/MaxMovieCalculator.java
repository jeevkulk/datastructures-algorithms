package algorithm.graph;

public class MaxMovieCalculator {

	public static void main(String[] args) {
		int[] startTime = new int[] {9, 11, 13, 15, 17};
		int[] endTime = new int[] {11, 13, 15, 17, 19};
		int[][] tree;
		
		MaxMovieCalculator maxMovieCalc = new MaxMovieCalculator();
		tree = maxMovieCalc.convToTree(startTime, endTime);
		maxMovieCalc.findMaxDepth(tree);
	}

	public int[][] convToTree(int[] startTime, int[] endTime) {
		int[][] tree = new int[startTime.length][endTime.length];
		int i,j;
		
		for(j=0; j<endTime.length; j++) {
			for(i=0; i<startTime.length; i++) {
				if(endTime[j] <= startTime[i] && i!=j)
					tree[j][i] = 1;
				else
					tree[j][i] = 0;
			}
		}
		
		for(i=0; i<tree.length; i++) {
			for(j=0; j<tree[i].length; j++) {			
				System.out.print(" "+tree[i][j]+" ");
			}
			System.out.println();
		}
		return tree;
	}
	
	/*public void findMaxDepth(int[][] tree) {
		int i, j, temp, max=0;
		for(j=0; j<tree.length; j++) {
			temp = 0;
			for(i=0; i<tree[j].length; i++) {
				if(tree[i][j] == 1)
					temp++;
			}
			if(max < temp)
				max = temp;
		}
		System.out.println("Maximum number of movies:"+max);
	}*/
	
	public void findMaxDepth(int[][] tree) {
		int i, j, count = 0, maxCount = 0;
		for(i=0; i<tree.length; i++) {
			for(j=0; j<tree[i].length; j++) {
				if(tree[i][j] == 1) {
					System.out.println("Calling dfs() for==>"+i+"-"+j);
					count = dfs(tree, i, j);
					if(count > maxCount)
						maxCount = count;
				}
			}
		}
		System.out.println("Maximum number of movies:"+maxCount);
	}
	
	public int dfs(int[][] tree, int x, int y) {
		int i, j, count = 1;
		Stack stack = new Stack();
		int[][] visited = new int[tree.length][tree[0].length];
		for(j=0; j<tree.length; j++) {
			for(i=0; i<tree[j].length; i++) {
				visited[i][j] = 0;
			}
		}
		while(y != -1) {
			//System.out.println("pushing==="+x+"-"+y);
			count ++;
			stack.push(x+"-"+y);
			visited[x][y] = 1;
			x = y;
			y = getNextUnvisitedVertex(tree, visited, y);
			//System.out.println("y="+y);
			if(y == -1) {
				System.out.println("popping===>"+stack.pop()+"== count="+count);
			}
		}
		return count;
	}

	
	public int getNextUnvisitedVertex(int[][] tree, int[][] visited, int x) {
		int j;
		for(j=0; j<tree[x].length; j++) {
			//System.out.println(x+"----->tree[x][j]==="+tree[x][j]);
			if(tree[x][j] == 1 && visited[x][j] == 0) {
				return j;
			}
		}
		return -1;
	}
	
	public class Stack{
		
		String[] arr = new String[100];
		private int top = -1;
		
		public Stack() {
		}
		
		public void push(String str) {
			arr[++top] = str;
		}
		
		public String pop() {
			return arr[top--];
		}
	}
}
