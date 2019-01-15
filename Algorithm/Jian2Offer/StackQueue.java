/**
 * 
 */
package review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zyd
 * @date 2019年1月14日 下午1:28:24
 * @ClassName: Array2StackQueue 
 * 用队列和栈互相实现
 */
public class StackQueue {
	public static class Stack2Queue{
		private Stack<Integer> stack1;
		private Stack<Integer> stack2;
		
		public Stack2Queue(){
			stack1 = new Stack<>();
			stack2 = new Stack<>();
		}
		public void offer(int num) {
			stack1.push(num);
		}
		
		public int poll() {
			if(stack2.isEmpty()) {
				while(!stack1.isEmpty())
					stack2.push(stack1.pop());
			}
			if(stack2.isEmpty())
				throw new RuntimeException("The queue is empty!");
			return stack2.pop();
		}
	}
	public static class Queue2Stack{
		private Queue<Integer> queue1;
		private Queue<Integer> queue2;
		
		public Queue2Stack() {
			queue1 = new LinkedList<>();
			queue2 = new LinkedList<>();
		}
		
		public void push(int num) {
			queue1.offer(num);
		}
		
		public int pop() {
			while(queue1.size() > 1) {
				queue2.offer(queue1.poll());
			}
			int res = queue1.poll();
			queue1 = queue2;
			queue2 = new LinkedList<>();
			return res;
		}
	}
}
