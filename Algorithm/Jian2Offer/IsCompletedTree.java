/**
 * 
 */
package review;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyd
 * @date 2019年1月14日 下午10:32:06
 * @ClassName: IsCompletedTree 
 * 判断是否是完全二叉树
 */
public class IsCompletedTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(4);
		head.left = new Node(2);
		head.right = new Node(6);
//		head.left.left = new Node(1);
		head.left.right = new Node(3);
		head.right.left = new Node(5);
		System.out.println(isCompletedTree(head));
	}
	
	public static boolean isCompletedTree(Node node) {
		if(node == null)
			return false;
		
		boolean flag = false;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if((flag && (temp.left != null || temp.right != null)) || (temp.left == null && temp.right != null))
				return false;
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			
			if (temp.right != null) {
				queue.offer(temp.right);
			}else {
				flag = true;
			}
		}
		return true;
	}
}
