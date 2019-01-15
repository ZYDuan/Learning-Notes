/**
 * 
 */
package review;

/**
 * @author zyd
 * @date 2019年1月14日 下午4:37:22 
 * @ClassName: PrintZhiMatrix 
 * zhi字形打印matrix
 */
public class PrintZhiMatrix {
	
	public static void main(String[] args) {
		int[][] martix = {{1,2,3,4,5},
				 {6,7,8,9,10},
				 {11,12,13,14,15},
				 {16,17,18,19,20},
				 {21,22,23,24,25}};
		printZhiMtrix(martix);
	}
	
	public static void printZhiMtrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return;
		
		boolean isTop2Bot = false;
		
		int aR = 0, aC = 0, bR = 0, bC = 0;
		int row = matrix.length - 1;
		int col = matrix[0].length - 1;
		while(aR != row + 1) {
			printZhi(matrix, aR, aC, bR, bC, isTop2Bot);
			//需要注意顺序
			aR = aC == col ? aR + 1 : aR;
			aC = aC == col ? aC : aC + 1;
			bC = bR == row ? bC + 1 : bC;
			bR = bR == row ? bR : bR + 1;
			isTop2Bot = !isTop2Bot;
		}
	}

	/**
	 * @param matrix
	 * @param aR
	 * @param aC
	 * @param bR
	 * @param bC
	 * @param isTop2Bot
	 */
	private static void printZhi(int[][] matrix, int aR, int aC, int bR, int bC, boolean isTop2Bot) {
		if(isTop2Bot) {
			while(aR != bR + 1) {
				System.out.print(matrix[aR++][aC--] + " ");
			}
		}else {
			while(bR != aR - 1) {
				System.out.print(matrix[bR--][bC++] + " ");
			}
		}
		System.out.println();
	}
	
}
