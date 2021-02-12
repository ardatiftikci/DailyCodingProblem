import java.util.Random;

/* Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */

public class Problem14 {
	private static final int NUMBER_OF_POINTS = 10000000;
	private static final Random rand = new Random();
	public static void main(String[] args) {
		p14();
	}

	public static void p14() {
		int count = 0;
		for(int i=0; i<NUMBER_OF_POINTS;i++) {
			double randX= 2*rand.nextDouble()-1;
			double randY= 2*rand.nextDouble()-1;
			//a square with 2 side length.
			if(randX*randX+randY*randY<=1)count++;
			//increment count if the random point is in unit circle
		}
		double piEstimation = (4.0 * count)/NUMBER_OF_POINTS;
		//count/NUMBER_OF_POINTS gives the probability that randomly chosen point from sqaure (Area is 4) is in unit circle 
		//I multiplied the probability with 4 to find the area of unit circle which equals to pi.
		System.out.println(piEstimation);
	}
}
