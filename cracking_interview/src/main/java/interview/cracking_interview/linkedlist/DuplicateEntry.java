package interview.cracking_interview.linkedlist;

/**
 * Remove duplicate nodes from linked list without using buffer
 * 
 * @author jojo
 *
 */
public class DuplicateEntry
{
	// no buffer
	public Node removeDuplicate(Node root)
	{
		Node current = root.next, prev = root;

		while (current != null)
		{
			prev = root;
			while (prev != current)
			{
				if (prev.val == current.val)
				{
					prev.next = prev.next.next;
					prev = prev.next;
					break;
				}
			}

			current = current.next;
		}

		return root;
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
