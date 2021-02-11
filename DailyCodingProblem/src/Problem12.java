import java.util.Arrays;
import java.util.List;
/* There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. 
 * Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 * For example, if N is 4, then there are 5 unique ways.
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class Problem12 {

	public static void main(String[] args) {
		p12();
		List<Integer> stepSize = Arrays.asList(1,2);
		System.out.println(countWays2(4,stepSize));
	}

	public static void p12() {
		int N=4;
		System.out.printf("Number of unique ways you can climb the staircase (size %d) with step sizes 1 and 2 is %d.%n",N,countWays1(N));
		N=5;
		List<Integer> stepSize = Arrays.asList(1,3,5);
		countWays2(N, stepSize);
	}

	private static int countWays1(int N) {
		if(N==0||N==1) return 1;
		else return countWays1(N-2)+countWays1(N-1);
	}

	private static int countWays2(int N, List<Integer> stepSize) {
		if(N<0) return 0;
		else if(N==0)return 1;

		else if(stepSize.contains(N)) {
			int sum = 1;
			for(int m: stepSize) {
				if(m<N) sum+=countWays2(N-m, stepSize);
			}
			return sum;
		}

		else {
			int sum = 0;
			for(int m: stepSize) {
				if(m<N) sum+=countWays2(N-m, stepSize);
			}
			return sum;
		}
	}
}
