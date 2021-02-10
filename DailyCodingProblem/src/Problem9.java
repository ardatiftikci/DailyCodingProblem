/*Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 * Follow-up: Can you do this in O(N) time and constant space?
 */
public class Problem9 {

	public static void main(String[] args) {
		int[] array1 = {2,4,6,2,5};
		int[] array2 = {5,1,1,5};
		System.out.println(p9(array1));
		System.out.println(p9(array2));
	}

	public static int p9(int[] array) {
		int sum1 = 0;
		int sum2 = 0;

		for(int i=array.length-1;i>=0;i--) {
			int newSum = Math.max(array[i] + sum2, sum1);
			sum2 = sum1;
			sum1 = newSum;
		}

		return sum1;
	}

}
