/**
 * 
 */
package review;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zyd
 * @date 2019年1月14日 下午11:23:46 
 * @ClassName: GetMostProfit 
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花 费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多 做k个项目 m表示你初始的资金 
 * 说明:你每做完一个项目，马上获得的收益，可以支持你去做下 一个 项目。
 * 输出: 你最后获得的最大钱数。
 */
public class GetMostProfit {

	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
	
	public static class MinCostComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.c - o2.c;
		}
	}

	public static class MaxCostComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o2.p - o1.p;
		}
	}
	public static class MaxHeapComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] costs = {100, 200, 300, 400, 150};
		int[] profits = {50, 60, 40, 60, 80};
		int k = 4;
		int m = 250;

		System.out.println(getMostProfit(costs, profits, k, m));
	}

	public static int getMostProfit(int[] costs, int[] profits, int K, int m) {
		if(costs == null || costs.length == 0)
			return 0;
		
		PriorityQueue<Node> costSeq = new PriorityQueue<>(new MinCostComparator()); // 进行最小堆排序
		PriorityQueue<Node> proSeq = new PriorityQueue<>(new MaxCostComparator()); // 进行最大堆排序

		Node[] nodes = new Node[costs.length];
		for (int i = 0; i < costs.length; i++) {
			nodes[i] = new Node(profits[i], costs[i]);
			costSeq.add(nodes[i]);
		}
		
		for (int i = 0; i < K; i++) {
			while (!costSeq.isEmpty() && costSeq.peek().c <= m) {
				proSeq.add(costSeq.poll());
			}
			if (proSeq.isEmpty()) {
				return m;
			}
			m += proSeq.poll().p;
		}
		return m;
	}
}
