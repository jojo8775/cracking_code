package interview.cracking_interview.hard;

import java.util.PriorityQueue;

public class Hard_Prob6 {
	public int[] findKLargestNumbers(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a - b);

		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] > heap.peek()) {
				heap.poll();
				heap.add(arr[i]);
			}
		}

		int[] result = new int[heap.size()];
		int count = 0;
		while (!heap.isEmpty()) {
			result[count++] = heap.poll();
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[128];
		for (int i = 0; i < 128; i++) {
			arr[i] = getRandom(78, 100);
		}

		print(arr);
		print(new Hard_Prob6().findKLargestNumbers(arr, 10));
	}

	private static int getRandom(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
}
