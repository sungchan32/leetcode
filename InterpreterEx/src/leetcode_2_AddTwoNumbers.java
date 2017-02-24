
public class leetcode_2_AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		
//		l1.next = new ListNode(1);
//		l1.next.next = new ListNode(2);
//		l1.next.next.next = new ListNode(2);
//		
//		l2.next = new ListNode(9);
//		l2.next.next = new ListNode(3);
//		l2.next.next.next = new ListNode(2);
		
		
		leetcode_2_AddTwoNumbers a = new leetcode_2_AddTwoNumbers();
		
		l1 = a.addTwoNumbers(l1, l2);
		
		String num = "";
		
		while(l1 != null){
			num += l1.val; 
			
			l1 = l1.next;
		}
		System.out.println(num);
	}

	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = null, head = null;
		head = node = new ListNode(0); // node의 head를 가지고 있고, a를 움직여 값을 더해 주게 된다.
		boolean endstate = true;
		
		int num = 0;
		int sum = 0;
		int carry = 0;
		while(endstate){
			
			if (l2 != null && l1 == null)
				sum = l2.val + carry;
			else if (l2 == null && l1 != null)
				sum = l1.val + carry;
			else if (l2 != null && l1 != null)
				sum = l1.val + l2.val + carry;
				
			num = sum%10;
			carry = sum/10;
			
			node = node.next = new ListNode(num);
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
			
			if (l1 == null && l2 == null) {
				if(carry != 0)
					node = node.next = new ListNode(carry);
				endstate = false;
			}
		}
		
		
		return head.next;
    }
	 
}


//linked list node 형태
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}