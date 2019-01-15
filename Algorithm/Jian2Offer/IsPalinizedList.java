/**
 * 
 */
package review;


/**
 * @author zyd
 * @date 2019年1月14日 下午6:05:45
 * @ClassName: PrintCommonList
 */
public class IsPalinizedList {
	public static class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	public static void main(String[] args) {
		Node head1 = new Node(0);
		
		Node list1 = head1;
		
		for(int i = 1; i < 10; i++) {
			head1.next = new Node(i);
			head1 = head1.next;
		}
		for(int i = 9; i >= 0; i--) {
			head1.next = new Node(i);
			head1 = head1.next;
		}
		
		System.out.println(isPalinizedList(list1));
	}
	
	public static boolean isPalinizedList(Node head) {
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		n2 = n1.next;
		n1.next = null;
		
		Node n3 = null;
		while(n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		
		n3 = n1;
		n2 = head;
		while (n1 != null && n2 != null) { 
			if (n1.val != n2.val) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return true;
	}
}
