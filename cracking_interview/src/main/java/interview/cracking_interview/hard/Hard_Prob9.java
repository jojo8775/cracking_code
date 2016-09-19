package interview.cracking_interview.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Hard_Prob9 {
	public int findMedian(int[] arr){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((u,v) -> u - v);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((u,v) -> v - u);
		
		for(int n : arr){
			minHeap.add(n);
			while(!maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
				minHeap.add(maxHeap.poll());
			}
			
			while(minHeap.size() > maxHeap.size() + 1){
				maxHeap.add(minHeap.poll());
			}
		}
		
		if(arr.length % 2 == 0){
			return (minHeap.peek() + maxHeap.peek())/2;
		}
		
		return minHeap.peek();
	}
	
	public static void main(String[] args){
		int[] arr = new int[127];
		for(int i=0; i<arr.length; i++){
			arr[i] = getRandom(50, 500);
		}
		
		System.out.println("Actual result: " + new Hard_Prob9().findMedian(arr));
		Arrays.sort(arr);
		System.out.println("Expected result: " + arr[arr.length/2]);
	}
	
	private static int getRandom(int min, int max){
		return min + (int)(Math.random() * (max - min + 1));
	}
}
