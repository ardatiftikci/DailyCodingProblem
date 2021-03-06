import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
/*
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
*/
public class Problem1 {

	static List<Integer> list = Arrays.asList(10,15,3,7);

	public static void main(String[] args) {
		System.out.println(p1(17));
		System.out.println(p1Bonus(17));
	}

	public static boolean p1(int k) {
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i)+list.get(j)==k) return true;
			}
		}
		return false;
	}

	public static boolean p1Bonus(int k) {
		HashSet<Integer> seen = new HashSet<>();
		for(int i=0;i<list.size();i++) {
			if(seen.contains(k-list.get(i))) return true;
			seen.add(list.get(i));
		}
		return false;	
	}
}
