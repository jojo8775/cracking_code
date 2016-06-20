package interview.cracking_interview.linkedlist;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * sin- gle digit. The digits are stored in reverse order, such that the 1’s
 * digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list. EXAMPLE Input: (3 -> 1 -> 5), (5 -> 9
 * -> 2) Output: 8 -> 0 -> 8
 * 
 * @author jojo
 *
 */
public class AddLinkedList
{
	public Node add(Node n1, Node n2)
	{
		int carry = 0;
		Node r = new Node(0), head = r;

		while (n1 != null)
		{
			if (n2 != null)
			{
				carry += n2.val;
				n2 = n2.next;
			}

			carry += n2.val + carry;
			r.next = new Node(carry % 10);
			carry /= carry;
			n1 = n1.next;
		}

		while (carry != 0)
		{
			if (n2 != null)
			{
				carry += n2.val;
				n2 = n2.next;
			}

			r.next = new Node(carry % 10);
			carry /= carry;
		}

		r.next = n2;

		return head.next;
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
