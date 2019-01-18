/**
 * 
 */
package review.jian2Offer;

/**
 * @author zyd
 * @date 2019年1月18日 上午12:08:34 
 * @ClassName: ReplaceSpace 
 * 取代空格为%20
 */
public class ReplaceSpace {
	public static void main(String[] args) {
		String str = "123 12 3 ";
		System.out.println(replaceSpace(str));
	}
	
	public static String replaceSpace(String str) {
		if(str == null || str.length() == 0)
			return null;
		char[] chars = str.toCharArray();
		int len = chars.length;
		for(char c : chars) {
			if(c == ' ')
				len += 2;
		}
		
		char[] res = new char[len];
		int j = chars.length - 1;
		int i = len - 1;
		while(j >= 0 && i >= 0) {
			if(chars[j] == ' ') {
				res[i--] = '0';
				res[i--] = '2';
				res[i--] = '%';
				j--;
			}else {
				res[i--] = chars[j--];
			}
		}
		return new String(res);
	}
	
}
