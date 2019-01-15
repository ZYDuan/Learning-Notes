/**
 * 
 */
package review;

import org.junit.Test;

/**
 * @author zyd
 * @date 2019年1月14日 下午12:00:05 
 * @ClassName: GetMaxGrap 
 * 获得数组中间隔最大的两个连续的数
 */
public class GetMaxGrap {
	
	@Test
	public void test() {
		int[] num = { 4, 5, 1, 4, 6, 12, 43, 22, 41 };
		System.out.println(getMaxGrap(num));
	}
	public int getMaxGrap(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		int len = nums.length;
		boolean[] hasNum = new boolean[len + 1];
		int[] mins = new int[len + 1];
		int[] maxs = new int[len + 1];
		
		for(int i = 0; i < len; i++) {
			int index = getIndex(len, min, max, nums[i]);
			mins[index] = hasNum[index] ? Math.min(mins[index], nums[i]) : nums[i];
			maxs[index] = hasNum[index] ? Math.max(maxs[index], nums[i]) : nums[i];
			hasNum[index] = true;
		}
		
		int res = 0;
		int preMax = maxs[0];
		for(int i = 1; i <= len; i++) {
			if(hasNum[i]) {
				res = Math.max(mins[i] - preMax, res);
				preMax = maxs[i];
			}
		}
		return res;
	}

	/**
	 * @param len
	 * @param min
	 * @param max
	 * @param i
	 * @return
	 */
	private int getIndex(int len, int min, int max, int i) {
		
		return (int)(i - min) * len / (max - min);
	}
}
