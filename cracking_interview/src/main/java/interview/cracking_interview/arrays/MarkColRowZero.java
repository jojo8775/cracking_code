package interview.cracking_interview.arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0.
 * 
 * @author jojo
 *
 */
public class MarkColRowZero {
	public void markZero(int[][] grid){
		int[] col = new int[grid.length];
		int[] row = new int[grid[0].length];
		
		// index the row and col which should be marked as 0
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(grid[i][j] == 0){
					col[i] = 1;
					row[j] = 1;
				}
			}
		}
		
		// making the actual change
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(col[i] == 1 || row[j] == 1){
					grid[i][j] = 0;
				}
			}
		}
	}
}
