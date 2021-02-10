import java.util.Random;
/* Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place.
 */
public class Problem4 {

	public static void main(String[] args) {
		int[] array = new Random().ints(5, -10, 10).toArray();
		printArray(array);
		System.out.println("The answer is "+p4(array));
	}

	public static int p4(int[] array) {
		int firstPositiveIndex = swapNonpositives(array);
		markSeenValues(array, firstPositiveIndex);
		return checkSeenValues(array);
	}

	private static int checkSeenValues(int[] array) {
		for(int i=0;i<array.length;i++) {
			if(array[i]!=Integer.MAX_VALUE) {
				return i+1;
			}
		}
		return array.length+1;
	}

	private static void markSeenValues(int[] array, int firstPositiveIndex) {
		for(int j=firstPositiveIndex;j<array.length;j++) {
			if(array[j]<=array.length-firstPositiveIndex) {
				array[array[j]-1]=Integer.MAX_VALUE;
			}
		}
	}

	private static int swapNonpositives(int[] array) {
		int firstPositiveIndex = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]<=0){
				int temp = array[i];
				array[i] = array[firstPositiveIndex];
				array[firstPositiveIndex] = temp;
				firstPositiveIndex++;
			}
		}
		return firstPositiveIndex;
	}
	
	private static void printArray(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			System.out.print(array[i]+", ");
		}
		System.out.println(array[array.length-1]);
	}

}
