package interview.cracking_interview.recursion;

/**
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can
only move in two directions: right and down. How many possible paths are there for
the robot?
FOLLOW UP
Imagine certain squares are “off limits”, such that the robot can not step on them.
Design an algorithm to get all possible paths for the robot.
 * @author jojo
 *
 */
public class Ngrid
{
	public int findWays(int dim){
		int[][] grid = new int[dim][dim];
		
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				//if there is a block then we need to add skip condition for that position here.
				
				//taking care of the zeroth row
				if(i==0 || j==0){
					grid[i][j] = 1;
				}
				else{
					grid[i][j] = grid[i-1][j] + grid[i][j-1];
				}
			}
		}
		
		return grid[dim-1][dim-1];
	}
	
	public static void main(String[] args){
		int numberOfPaths = new Ngrid().findWays(5);
		System.out.println(numberOfPaths);
	}
}
