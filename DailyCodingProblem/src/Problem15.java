import java.util.Random;

/* Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */

public class Problem15 {
	private static final Random rand = new Random();
	public static void main(String[] args) {
		p15();
	}

	public static void p15() {
		int[] bigStream = {1,2,3,4,5,6,7,8};
		int count = 1;
		int randomSelectedNumber=bigStream[0];
		for(int i=1; i< bigStream.length; i++) {
			count++;
			randomSelectedNumber = randomSelect(bigStream[i], randomSelectedNumber, count);
		}

		System.out.println("Randomly selected number is "+randomSelectedNumber);
	}

	private static int randomSelect(int currentStreamElement, int currentSelectedNumber, int count) {
		if (rand.nextInt(count)==0) return currentStreamElement;
		else return currentSelectedNumber;
	}

}
