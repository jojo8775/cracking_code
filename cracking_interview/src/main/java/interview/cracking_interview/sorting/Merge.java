package interview.cracking_interview.sorting;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 * 
 * @author jojo
 *
 */
public class Merge
{
	public int[] merge(int[] a, int[] b, int idx1)
	{
		int count = a.length - 1, idx2 = b.length - 1;
		while (idx1 >= 0)
		{
			if (idx2 >= 0 && a[idx1] < b[idx2])
			{
				a[count--] = b[idx2--];
			} else
			{
				a[count--] = a[idx1--];
			}
		}

		while (idx2 >= 0)
		{
			a[count--] = b[idx2--];
		}

		return a;
	}
}
