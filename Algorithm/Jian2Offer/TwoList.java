/**
 * 
 */
package review;


/**
 * @author zyd
 * @date 2019年1月14日 下午7:20:59
 * @ClassName: TwoList 
 * 找到两个单链表相交的节点
 */
public class TwoList {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		Node head2 = new Node(0);
		 // 1->2->3->4->5->6->7->null
		 head1.next = new Node(2);
		 head1.next.next = new Node(3);
		 head1.next.next.next = new Node(4);
		 head1.next.next.next.next = new Node(5);
		 head1.next.next.next.next.next = new Node(6);
		 head1.next.next.next.next.next.next = new Node(7);
		
		 // 0->9->8->6->7->null
//		 Node head2 = new Node(0);
		 head2.next = new Node(9);
		 head2.next.next = new Node(8);
		 head2.next.next.next = head1.next.next.next.next.next; // 8->6

		// 1->2->3->4->5->6->7->4...
//		head1 = new Node(1);
//		head1.next = new Node(2);
//		head1.next.next = new Node(3);
//		head1.next.next.next = new Node(4);
//		head1.next.next.next.next = new Node(5);
//		head1.next.next.next.next.next = new Node(6);
//		head1.next.next.next.next.next.next = new Node(7);
//		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
//
//		// 0->9->8->6->4->5->6..
//		head2 = new Node(0);
//		head2.next = new Node(9);
//		head2.next.next = new Node(8);
//		head2.next.next.next = head1.next.next.next.next.next; // 8->6

		System.out.println(isCommonList(head1, head2));

	}
	
	public static int isCommonList(Node head1, Node head2) {
		// 获取链表的环入点
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);

		// 两个无环链表
		if (loop1 == null && loop2 == null) {
			return noLoopList(head1, head2);
		} else if (loop1 != null && loop2 != null) {
			// 两个有环链表
			return loopList(head1, head2, loop1, loop2);
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * @param head1
	 * @param head2
	 * @param loop1
	 * @param loop2
	 */
	private static int loopList(Node head1, Node head2, Node loop1, Node loop2) {
		Node node1 = loop1;
		Node node2 = loop2;
		if(loop1 == loop2) {
			int len = 0;
			while(node1 != loop1) {
				node1 = node1.next;
				len++;
			}
			
			while(node2 != loop2) {
				node2 = node2.next;
				len--;
			}
			node1 = len > 0 ? head1 : head2;
			node2 = node1 == head1 ? head2 : head1;
			len = Math.abs(len);
			while (len != 0) {
				len--;
				node1 = node1.next;
			}
			while (node1 != node2) {
				node1 = node1.next;
				node2 = node2.next;
			}
			return node1.value;
		}
		
		node1 = loop1.next;
		while(node1 != loop1) {
			if(node1 == loop2)
				return node1.value;
			node1 = node1.next;
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * @param head1
	 * @param head2
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int noLoopList(Node head1, Node head2) {
		int len = 0;
		Node node1 = head1;
		while (node1.next != null) {
			len++;
			node1 = node1.next;
		}

		Node node2 = head2;
		while (node2.next != null) {
			len--;
			node2 = node2.next;
		}
		// 判断是否最后一个节点是否相同
		if (node2 != node1)
			return Integer.MIN_VALUE;
		
		
		node1 = len > 0 ? head1 : head2;
		node2 = node1 == head1 ? head2 : head1;
		len = Math.abs(len);
		while (len > 0) {
			node1 = node1.next;
			len--;
		}

		while (node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1.value;
	}

	/**
	 * @param head1
	 * @return
	 */
	private static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null)
			return null;
		Node n1 = head.next;
		Node n2 = head.next.next;
		while (n2 != n1) {
			if (n2.next == null || n2.next.next == null)
				return null;
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n1 = head;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
}
