/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		//special case!
		if (head == null || head.next == null || n == 0)
			return head;
		ListNode tail = head;
		ListNode rotate = head;
		for (int i = 0; i < n; i++){
			//roll over
			if (tail == null)
				tail = head;
			tail = tail.next;
		}
		//rotate for the length of the list, still the original list
		if (tail == null)
			return head;
		while(tail.next != null){
			tail = tail.next;
			rotate = rotate.next;
		}
		ListNode newHead = rotate.next;
		rotate.next = null;
		tail.next = head;
		return newHead;

	}
}
