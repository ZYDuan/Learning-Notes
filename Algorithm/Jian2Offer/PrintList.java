/**
 * 
 */
package review.jian2Offer;

import java.util.Stack;

/**
 * @author zyd
 * @date 2019年1月19日 上午12:09:39
 * @ClassName: PrintList
 * 从尾到头打印链表
 */
public class PrintList {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		printList1(head);
		printList2(head);
	}
	
	/**
	 * @param head
	 * 非递归
	 */
	private static void printList2(ListNode head) {
		if (head == null) {
			return;
		}
		
		Stack<ListNode> stack = new Stack<>();
		while(head != null) {
			stack.push(head);
			head = head.next;
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().val);
		}
	}

	/**
	 * 递归
	 * @param head
	 */
	public static void printList1(ListNode head) {
		if (head == null) {
			return;
		}
		printList1(head.next);
		System.out.println(head.val);
	}
}
