package interview.cracking_interview.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5
 * cents) and pennies (1 cent), write code to calculate the number of ways of
 * representing n cents.
 * 
 * @author jojo
 *
 */
public class NCoin {
	public int find(List<Integer> coins, int sum){
		int[][] grid = new int[coins.size() + 1][sum + 1];
		grid[0][0] = 1;
		Collections.sort(coins);
		
		for(int i=1; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(j < coins.get(i - 1)){
					grid[i][j] = grid[i-1][j];
				}
				else{
					grid[i][j] = grid[i-1][j] + grid[i][j-coins.get(i-1)];
				}
			}
		}
		
		return grid[coins.size()][sum];
	}
	
	public static void main(String[] args){
		System.out.println(new NCoin().find(Arrays.asList(2,3), 5));
	}
}
