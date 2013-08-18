/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 */
public class RmNthNode {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode fake = new ListNode(0);
	        fake.next = head;
	        ListNode front = head;
			ListNode back = fake;
			int i = 0;
			while(i < n){
				front = front.next;
	            i++;
			}
			while (front != null){
				 front = front.next;
				 back = back.next;
			}
			if (back == fake){
				head = head.next;
			}
			else{
				back.next = back.next.next;
			}
			return head;	
		}
}
