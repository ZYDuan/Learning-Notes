/**
 * 
 */
package review;


/**
 * @author zyd
 * @date 2019年1月14日 下午9:52:23 
 * @ClassName: IsBST 
 * 判断是否搜索二叉树
 */
public class IsBST {
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
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(9);
		head.left.left = new Node(10);
		head.left.right = new Node(4);
		head.right.left = new Node(8);
		System.out.println(isBST(head));
	}
	
	public static boolean isBST(Node node) {
		if(node == null)
			return true;
		boolean left = true;
		boolean right = true;
		
		if(node.left != null)
			left = isBST(node.left) && node.left.val < node.val;
		if(node.right != null)
			right = isBST(node.right) && node.right.val > node.val;
		return left && right;
	}
}
