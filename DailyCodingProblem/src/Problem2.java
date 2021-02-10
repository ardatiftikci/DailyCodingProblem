import java.util.Arrays;
/* Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 */
public class Problem2 {

	static Integer input[] = {1,2,3,4,5};
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(p2()));
		System.out.println(Arrays.deepToString(p2WithNoDivision()));
	}

	public static Integer[] p2() {
		Integer[] result = new Integer[input.length];
		int product = 1;
		for(int i=0; i<input.length; i++) product *= input[i];
		for(int i=0; i<input.length; i++) result[i] = product/input[i];
		return result;
	}

	public static Integer[] p2WithNoDivision() {
		Integer[] result = new Integer[input.length];
		for(int i=0; i<input.length; i++) {
			result[i]=1;
			for(int j=0 ; j<input.length; j++) {
				if(j!=i) result[i]*=input[j];
			}
		}
		return result;
	}
}
