/**
 * 
 */
package review;

import java.util.PriorityQueue;

/**
 * @author zyd
 * @date 2019年1月14日 下午11:12:46 
 * @ClassName: GetLeastMoney 
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。最省铜板的分隔方法
 */
public class GetLeastMoney {
	
	public static void main(String[] args) {
		int[] nums = {10, 20, 30, 40};
		System.out.println(getLeast(nums));
	}
	
	public static int getLeast(int[] nums) {
		int res = 0;
		if(nums == null || nums.length == 0)
			return res;
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int num : nums) {
			queue.offer(num);
		}
		
		while(queue.size() > 1) {
			int temp = queue.poll() + queue.poll();
			res += temp;
			queue.offer(temp);
		}
		return res;
	}
	
}
