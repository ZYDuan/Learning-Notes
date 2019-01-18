/**
 * 
 */
package review;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zyd
 * @date 2019年1月14日 下午11:43:32 
 * @ClassName: GetMidFromStream 
 * 一个数据流中，随时可以取得中位数
 */
public class GetMidFromStream {
	public static class MaxHeapComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	}
	
	public static void main(String[] args) {
		for(int i = 50; i < 400; i *= 2) {
			offer(i);
			System.out.println(getMid());
		}
	}
	
	public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
	
	public static void offer(int num) {
		if(maxHeap.isEmpty())
			maxHeap.offer(num);
		else {
			if(maxHeap.peek() < num)
				minHeap.offer(num);
			
			if(maxHeap.size() > minHeap.size() + 1)
				minHeap.offer(maxHeap.poll());
			else if(maxHeap.size() < minHeap.size() - 1)
				maxHeap.offer(minHeap.poll());
		}
	}
	
	public static int getMid() {
		if(maxHeap.size() == 0)
			throw new RuntimeException("The stream is empty!"); 
		if(maxHeap.size() == minHeap.size())
			return (maxHeap.peek() + minHeap.peek()) / 2;
		return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
	}
	
}
