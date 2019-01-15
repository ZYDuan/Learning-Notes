/**
 * 
 */
package review;

/**
 * @author zyd
 * @date 2019年1月14日 下午3:21:07 
 * @ClassName: RotateMatrix 
 * 90度旋转正方形矩阵
 */
public class RotateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] martix = {{1,2,3,4,5},
				 {6,7,8,9,10},
				 {11,12,13,14,15},
				 {16,17,18,19,20},
				 {21,22,23,24,25}};
		rotateMatrix(martix);
		// TODO Auto-generated method stub
		for(int i = 0; i < martix.length; i++) {
			for(int j = 0; j < martix[i].length; j++)
				System.out.print(martix[i][j] + " ");
			System.out.println();
		}
	}

	public static void rotateMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return;
		int len = matrix.length;
		int fR = 0, fC = 0, sR = len - 1, sC = len - 1;
		while(fR <= sR) {
			rotate(matrix, fR++, fC++, sR--, sC--);
		}
	}
	
	
	private static void rotate(int[][] matrix, int i, int j, int m, int n) {
		int len = n - j;
		for(int x = 0; x < len; x++) {
			int temp = matrix[i][j + x];
			matrix[i][j + x] = matrix[m - x][j];
			matrix[m - x][j] = matrix[m][n - x];
			matrix[m][n - x] = matrix[i + x][n];
			matrix[i + x][n] = temp;
		}
		
	}
}
