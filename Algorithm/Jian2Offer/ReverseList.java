/**
 * 
 */
package review;


/**
 * @author zyd
 * @date 2019年1月14日 下午5:53:23 
 * @ClassName: ReverseList 
 */
public class ReverseList {
	public static class ListNode{
		ListNode next;
		Integer val;
		public ListNode(Integer val) {
			this.val = val;
			this.next = null;
		}
	}
	
	public static ListNode reverseList(ListNode head) {
		ListNode node = head;
		ListNode pre = null;
		while(node != null) {
			ListNode temp = node.next;
			node.next = pre;
			pre = node;
			node = temp;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode next = head;
		for(int i = 1; i < 3; i++) {
			next.next = new ListNode(i);
			next = next.next;
		}
		
		ListNode res = reverseList(head);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
}
