/**
 * 
 */
package review;

import java.util.Stack;

/**
 * @author zyd
 * @date 2019年1月14日 下午1:22:51
 * @ClassName: MinStack
 * 实现一个可以以O(1)返回最小值的栈
 */
public class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public int pop() {
		if (this.stack.isEmpty())
			throw new RuntimeException("The stack is empty!");
		minStack.pop();
		return stack.pop();
	}

	public void push(int num) {
		stack.push(num);
		if (minStack.isEmpty() || num < minStack.peek())
			minStack.push(num);
		else {
			minStack.push(minStack.peek());
		}
	}

	public int getMin() {
		return minStack.peek();
	}
}
