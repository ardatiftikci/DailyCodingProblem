import java.util.Arrays;

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
