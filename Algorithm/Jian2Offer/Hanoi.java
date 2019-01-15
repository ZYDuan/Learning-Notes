/**
 * 
 */
package review;

/**
 * @author zyd
 * @date 2019年1月14日 下午11:56:20 
 * @ClassName: Hanoi 
 * 汉诺塔算法
 */
public class Hanoi {
	public static void main(String[] args) {
		hanoiTa(3);
	}
	
	public static void hanoiTa(int n) {
		if(n == 0)
			return;
		move(n, "left", "right", "mid");
	}

	/**
	 * @param n
	 * @param from
	 * @param to
	 * @param help
	 */
	private static void move(int n, String from, String to, String help) {
		if(n == 1) {
			System.out.println("move 1 from " + from + " to " + to);
			return;
		}
		move(n - 1, from, help, to);
		System.out.println("move " + n + " from " + from + " to " + to);
		move(n - 1, help, to, from);
	}
}
