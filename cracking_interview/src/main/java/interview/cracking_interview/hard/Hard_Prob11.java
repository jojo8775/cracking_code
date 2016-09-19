package interview.cracking_interview.hard;

public class Hard_Prob11 {
	public int findMaxArea(int[][] grid){
		Entry[][] dp = new Entry[grid.length][grid[0].length];
		
		int maxArea = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(grid[i][j] == 1){
					int x = j == 0 ? 1 : dp[i][j-1].x + 1;
					int y = i == 0 ? 1 : dp[i-1][j].y + 1;
					dp[i][j] = new Entry(x,y);

					if(x == y){
						maxArea = Math.max(maxArea, x * y);
					}
				}
				else{
					dp[i][j] = new Entry(0,0);
				}
			}
		}
		
		return maxArea;
	}
	
	private static class Entry{
		int x;
		int y;
		
		public Entry(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args){
		int[][] grid = new int[5][];
		grid[0] = new int[]{0,1,1,1,1};
		grid[1] = new int[]{0,1,1,0,1};
		grid[2] = new int[]{0,1,1,1,1};
		grid[3] = new int[]{0,1,1,1,1};
		grid[4] = new int[]{0,0,1,0,1};
		
		System.out.println(new Hard_Prob11().findMaxArea(grid));
	}
}
