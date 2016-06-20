package interview.cracking_interview.arrays;

/**
 * Rotate matrix in place
 * @author jojo
 *
 */
public class RotateMatrix {
	public void rotateMatrix(int[][] grid){
		int start = 0, end = grid.length - 1;
		
		//number of layers 
		for(int i=0; i<grid.length/2; i++){
			
			int offset = 0;
			for(int j=start; j<end; j++){
				int temp = grid[start][j];
				
				grid[start][j] = grid[end - offset][start];
				grid[end - offset][start] = grid[end][end - offset];
				grid[end][end - offset] = grid[j][end];
				grid[j][end] = temp;
				
				offset++;
			}
			
			end --;
			start ++;
		}
	}
	
	public static void main(String[] args){
		int len = 5; 
		
		int[][] grid = new int[len][];
		int count = 1;
		for(int i=0; i<grid.length; i++){
			grid[i] = new int[len];
			for(int j=0; j<len; j++){
				grid[i][j] = count;
			}
			
			count ++;
		}
		
		System.out.println("before ------------- ");
		print(grid);
		new RotateMatrix().rotateMatrix(grid);
		System.out.println("after ------------- ");
		print(grid);
	}
	
	private static void print(int[][] grid){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				System.out.print(grid[i][j] + ", ");
			}
			
			System.out.println();
		}
	}
}
