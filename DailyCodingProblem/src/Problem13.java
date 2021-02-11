/* Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */

//Solution inspired by Umur Berkay Karakaþ (@ukarakas)
public class Problem13 {

	public static void main(String[] args) {
		p13();
	}

	public static void p13() {
		String s = "abcba";
		int k=3;
		String result = "";
		for(int i=0; i<s.length()-1;i++) {
			String temp = Character.toString(s.charAt(i));
			int count = 0;
			for(int j=i+1; j<s.length(); j++) {
				if(temp.indexOf(s.charAt(j))==-1) count++;
				
				if(count<k) temp+=s.charAt(j);
				else break;
			}
			if(temp.length()>result.length()) result = temp;
		}
		System.out.printf("Given s = %s and k = %d, the longest substring with %d distinct characters is %s and its length is %d.%n",s,k,k,result, result.length());
	}
}
