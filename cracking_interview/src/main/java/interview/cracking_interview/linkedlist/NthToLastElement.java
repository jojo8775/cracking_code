package interview.cracking_interview.linkedlist;

/**
 * Implement an algorithm to find the nth to last element of a singly linked
 * list.
 * 
 * @author jojo
 *
 */
public class NthToLastElement
{
	public Node find(Node root, int n)
	{
		Node first = new Node(0), second = root;

		// giving second a head start
		for (int i = 0; i < n; i++)
		{
			if (second != null)
			{
				second = second.next;
			}
		}

		while (second != null)
		{
			second = second.next;
			first = first.next;
		}

		return first.next;
	}

	private static class Node
	{
		public int val;
		public Node next;

		public Node(int val)
		{
			this.val = val;
		}
	}
}
