/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * think carefully the process of adding 2 numbers
 * details!!!
 */
public class addnum {


	public static void main(String[] args) {
		// some test
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(8);
		ListNode l2 = new ListNode(0);
		addTwoNumbers(l1, l2);

	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//edge cases
		if (l1 == null || l2 == null)
			return null;
		//last digit do first
		ListNode result = new ListNode((l1.val + l2.val) % 10);
		ListNode node = result;
		int carry = (l1.val + l2.val) / 10;

		ListNode i = l1.next;
		ListNode j = l2.next;

		while (i != null || j != null || carry == 1){
			//System.out.println("here");
			if ((i != null) && (j != null)){
				//have to use node.next to add new nodes to the list
				node.next = new ListNode((i.val + j.val + carry)%10);
				//calculate new carry after using former carry for this digit
				carry = (i.val + j.val + carry) / 10;
				i = i.next;
				j = j.next;

			}
			else if (i != null){

				node.next = new ListNode((i.val + carry) %10);
				carry = (i.val + carry) / 10;
				i = i.next;
			}
			else if (j != null){

				node.next = new ListNode((j.val + carry)%10);
				carry = (j.val + carry) / 10;
				j = j.next;

			}
			else {
				node.next = new ListNode(1);
				//the highest digit as carry, should terminate the loop
				break;
			}
			node = node.next;
		}
		return result;
	}
	

}


