package interview.cracking_interview.hard;

public class Hard_Prob12 {
	public int findMaxArea(int[][] grid){
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		
		for(int i=1; i<grid.length; i++){
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		
		for(int i=1; i<grid[0].length; i++){
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		
		for(int i=1; i<grid.length; i++){
			for(int j=1; j<grid[i].length; j++){
				dp[i][j] = grid[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
			}
		}
		
		int maxArea = Integer.MIN_VALUE;
		
		for(int i=0; i<dp.length; i++){
			for(int j=0; j<dp[i].length; j++){
				int count = 0;
				while(i + count < dp.length && j+count < dp[i].length){
					int left = j == 0 ? 0 : dp[i+count][j-1];
					int top = i == 0 ? 0 : dp[i-1][j+count];
					int topCorner = (i == 0 || j == 0) ? 0 : dp[i-1][j-1]; 
					
					maxArea = Math.max(maxArea, dp[i+count][j+count] - left - top + topCorner);
					count ++;
				}
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args){
		int[][] grid = new int[4][];
		
		grid[0] = new int[]{0,0,0,0};
		grid[1] = new int[]{0,3,3,3};
		grid[2] = new int[]{0,3,3,3};
		grid[3] = new int[]{0,3,3,3};
		
		System.out.println(new Hard_Prob12().findMaxArea(grid));
	}
}
