/**
 * 
 */
package review;

/**
 * @author zyd
 * @date 2019年1月14日 下午10:49:49 
 * @ClassName: CBTCount 
 * 完全二叉树节点的总数
 */
public class CBTCount {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(getNodeCount(head));
	}
	
	public static int getNodeCount(Node head) {
		if(head == null)
			return 0;
		
		int depth = getDepth(head);
		return getLevelCount(head, 1, depth);
	}
	
	/**
	 * @param head
	 * @param i
	 * @param depth
	 * @return
	 */
	private static int getLevelCount(Node head, int level, int depth) {
		if(level == depth)
			return 1;
		int right = getDepth(head.right);
		if(right == (depth - level))
			return (1 << (depth - level)) + getLevelCount(head.right, level + 1, depth);
		else
			return (1<< (depth - level - 1)) + getLevelCount(head.left, level + 1, depth);
	}

	/**
	 * 获取该节点到叶子节点的深度
	 * @param head
	 * @return
	 */
	public static int getDepth(Node head) {
		int res = 0;
		while(head != null) {
			res++;
			head = head.left;
		}
		return res;
	}
}
