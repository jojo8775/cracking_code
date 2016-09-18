package interview.cracking_interview.hard;

import java.util.ArrayList;
import java.util.List;

public class Hard_Prob3 {
	public List<Integer> findNumbers(int[] arr, int count) {
		List<Integer> result = new ArrayList<Integer>();

		int beg = 0;
		while (beg < count) {
			int randIdx = getRandom(beg, arr.length);
			result.add(arr[randIdx]);
			swap(arr, beg, randIdx);
			beg++;
		}

		return result;
	}

	private static int getRandom(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
