/**
 * 
 */
package review;

/**
 * @author zyd
 * @date 2019年1月14日 下午2:56:26 
 * @ClassName: PrintMatrix 
 * 按照转圈的方式打印矩阵
 */
public class PrintMatrix {
	public static void main(String[] args) {
		int[][] martix = {{1,2,3,4,5},
				 {6,7,8,9,10},
				 {11,12,13,14,15},
				 {16,17,18,19,20}};
		printMatrix(martix);
				 
	}
	public static void printMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return;
		
		int fR = 0, fC = 0;
		int sR = matrix.length - 1, sC = matrix[0].length - 1;
		while(fR <= sR && fC <= sC) {
			print(matrix, fR++, fC++, sR--, sC--);
		}
	}
	
	public static void print(int[][] matrix, int fR, int fC, int sR, int sC) {
		if(fR == sR) {
			while(fC <= sC)
				System.out.println(matrix[fR][fC++]);
		}else if (fC == sC) {
			while(fR <= fC)
				System.out.println(matrix[fR++][fC]);
		}else {
			int i = fR, j = fC;
			while(j < sC) {
				System.out.println(matrix[fR][j++]);
			}
			while(i < sR) {
				System.out.println(matrix[i++][j]);
			}
			
			while(j > fC) {
				System.out.println(matrix[i][j--]);
			}
			while(i > fR) {
				System.out.println(matrix[i--][j]);
			}
		}
	}
}
