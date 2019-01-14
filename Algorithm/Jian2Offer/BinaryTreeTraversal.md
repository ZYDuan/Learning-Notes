二叉树遍历

	public class BTreeTraversal {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		pre1(head);
		System.out.println();
		pre2(head);
		System.out.println();
		System.out.print("in-order: ");
		in1(head);
		System.out.println();
		in2(head);
		System.out.println();
		System.out.print("pos-order: ");
		post1(head);
		System.out.println();
		post2(head);
		System.out.println();

	}
	/**
	 * @param head
	 */
	private static void post2(Node head) {
	//		Stack<Node> stack = new Stack<>();
	//		Stack<Node> res = new Stack<>();
	//		stack.push(head);
	//		while(!stack.isEmpty()) {
	//			head = stack.pop();
	//			res.push(head);
	//			if(head.left != null)
	//				stack.push(head.left);
	//			if (head.right != null) {
	//				stack.push(head.right);
	//			}
	//		}
	//		while(!res.isEmpty())
	//			System.out.println(res.pop().value);
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		Node c = null;
		while(!stack.isEmpty()) {
			c = stack.peek();
			if(c.left != null && head != c.right && head != c.left) {
				stack.push(c.left);
			}else if (c.right != null && head != c.right) {
				stack.push(c.right);
			}else{
				head = stack.pop();
				System.out.println(head.value);
			}
		}
	}
	/**
	 * @param head
	 */
	private static void post1(Node head) {
		if(head == null)
			return;
		post1(head.left);
		post1(head.right);
		System.out.println(head.value);
		
	}
	/**
	 * @param head
	 */
	private static void in2(Node head) {
		Stack<Node> stack = new Stack<>();
		while(!stack.isEmpty() || head != null) {
			if(head != null) {
				stack.push(head);
				head = head.left;
			}else {
				head = stack.pop();
				System.out.println(head.value);
				head = head.right;
			}
		}
		
	}
	/**
	 * @param head
	 */
	private static void in1(Node head) {
		if(head == null)
			return;
		in1(head.left);
		System.out.println(head.value);
		in1(head.right);
	}
	/**
	 * @param head
	 */
	private static void pre2(Node head) {
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		while(!stack.isEmpty()) {
			head = stack.pop();
			System.out.println(head.value);
			if(head.right != null)
				stack.push(head.right);
			if (head.left != null) {
				stack.push(head.left);
			}
		}
		
	}
	/**
	 * @param head
	 */
	private static void pre1(Node head) {
		if(head == null)
			return;
		System.out.println(head.value);
		pre1(head.left);
		pre1(head.right);
	}
	}
