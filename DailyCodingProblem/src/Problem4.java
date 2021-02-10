import java.util.Random;

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
