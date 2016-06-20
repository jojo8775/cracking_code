package interview.cracking_interview.linkedlist;

/**
 * Given a circular linked list, implement an algorithm which returns node at
 * the begin- ning of the loop. DEFINITION Circular linked list: A (corrupt)
 * linked list in which a node’s next pointer points to an earlier node, so as
 * to make a loop in the linked list. EXAMPLE Input: A -> B -> C -> D -> E -> C
 * [the same C as earlier] Output: C
 * 
 * @author jojo
 *
 */
public class CircularLinkedList
{
	public int find(Node root)
	{
		Node f = root, s = f;
		s = s.next;
		f = f.next.next;

		// finding the overlap point
		while (f.val != s.val)
		{
			s = s.next;
			f = f.next.next;
		}

		// putting s to start point;
		s = root;

		// finding the loop begin
		int steps = 0;
		while (f.val != s.val)
		{
			f = f.next;
			s = s.next;

			steps++;
		}

		return steps;
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
