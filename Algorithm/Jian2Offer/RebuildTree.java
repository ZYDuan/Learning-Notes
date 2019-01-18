/**
 * 
 */
package review.jian2Offer;

/**
 * @author zyd
 * @date 2019年1月19日 上午12:16:37
 * @ClassName: RebuildTree 
 * 根据中序遍历和前序遍历进行二叉树重建
 */
public class RebuildTree {
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode node = reBuildTree(pre, in);
		while(node != null) {
			System.out.println(node.val);
			node = node.right;
		}
	}

	public static TreeNode reBuildTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}

		return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	/**
	 * @param pre
	 * @param preStart
	 * @param preEnd
	 * @param in
	 * @param inStart
	 * @param inEnd
	 * @return
	 */
	private static TreeNode rebuild(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if (preStart > preEnd) {
			return null;
		}
		if (preStart == preEnd) {
			return new TreeNode(pre[preStart]);
		}

		TreeNode node = new TreeNode(pre[preStart]);
		int i = inStart;
		for (; i <= inEnd; i++) {
			if (pre[preStart] == in[i]) {
				break;
			}
		}

		node.left = rebuild(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
		node.right = rebuild(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
		return node;
	}
}
