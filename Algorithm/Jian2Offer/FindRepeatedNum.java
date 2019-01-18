/**
 * 
 */
package review.jian2Offer;

/**
 * @author zyd
 * @date 2019年1月17日 下午11:26:26 
 * @ClassName: FindRepeatedNum 
 * 在长度为n，元素为0 ~ n-1的数组中找出重复的数
 * 根据面试或笔试的要求是找出一个重复或是所有重复的数，还有时间跟空间效率的考虑
 */
public class FindRepeatedNum {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,2,2};
		System.out.println(findRepeated(nums));
		System.out.println(findRepeatedNotModified(nums));
	}
	
	/**
	 * 数组中某些数字是重复的。但不知道几个数字重复，也不知道每个数字重复了几次
	 * @param nums
	 * @return
	 */
	public static int findRepeated(int[] nums) {
		if(nums == null || nums.length == 0)
			return -1;
		int i = 0;
		while(i < nums.length) {
			if(nums[i] != i && nums[nums[i]] == nums[i]) {
				return nums[i];
			}else if(nums[i] != i) {
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
			i++;
		}
		return -1;
	}
	
	/**
	 * 不修改数组找出重复的数字（n+1长度中元素范围为1-n，且至少有一个为重复的
	 * @param nums
	 * @return
	 */
	public static int findRepeatedNotModified(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		//1.用hash
		//2.二分法
		int start = 1, end = nums.length;
		while(start <= end) {
			int mid = start + ((end - start) >> 1);
			int count = getCountRange(nums, start, mid);
			if(end == start) {
				if(count > 1)
					return start;
				else 
					break;
			}
			
			if(count > mid - start + 1)
				end = mid;
			else 
				start = mid + 1;
		}
		return 0;
	}

	/**
	 * @param nums
	 * @param start
	 * @param mid
	 * @return
	 */
	private static int getCountRange(int[] nums, int start, int end) {
		int count = 0;
		for(int num : nums) {
			if(num >= start && num <= end)
				count++;
		}
		return count;
	}
}
