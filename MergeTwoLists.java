/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoLists {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode head = new ListNode(0);
	        ListNode index = head;
	        if (l1 == null && l2 == null)
	            return null;
	        if (l1 == null)
	            return l2;
	        if (l2 == null)
	            return l1;
	        while (l1!= null && l2!= null){
	            if (l1.val < l2.val){
	                index.next = l1;
	                l1= l1.next;
	            }
	            else{
	                index.next = l2;
	                l2 = l2.next;
	            }
	            index = index.next;
	        }
	        if (l1 == null){
	            index.next = l2;
	        }
	        if (l2 == null){
	            index.next = l1;
	        }
	        return head.next;
	        
	    }
}
