/* Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
*/
public class Problem7 {

	public static void main(String[] args) {
		System.out.println(p7());
	}

	public static int p7() {
		String str = "111";
		return p7Helper(str, str.length());
	}


	public static int p7Helper(String str, int n) {
		if (n == 0 || n == 1) return 1;
		if (str.charAt(0) == '0') return 0;

		int count = 0;
		
		if (str.charAt(n - 1) > '0') count = p7Helper(str, n - 1);
		if (isLegal(str, n))count += p7Helper(str, n - 2);

		return count;	
	}

	private static boolean isLegal(String str, int n) {
		return str.charAt(n-2) == '1'|| (str.charAt(n - 2) == '2' && str.charAt(n - 1) < '7');
	}
}
