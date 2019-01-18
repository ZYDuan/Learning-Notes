/**
 * 
 */
package review;


/**
 * @author zyd
 * @date 2019年1月14日 下午9:43:27 
 * @ClassName: IsBalancedTree 
 * 判断是否为平衡二叉树
 */
public class IsBalancedTree {
	public static class Node {
		Node left;
		Node right;
		int val;

		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.left.left.left = new Node(4);
//		head.left.left.left.left = new Node(4);
		System.out.println(isBalancedTree(head));
	}
	
	public static boolean isBalancedTree(Node head) {
		if(head == null)
			return false;
		
		return balancedTree(head) != -1;
	}
	
	public static int balancedTree(Node node) {
		if(node == null)
			return 0;
		int left = balancedTree(node.left);
		int right = balancedTree(node.right);
		if(left == -1 || right == -1 || Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
	
}
