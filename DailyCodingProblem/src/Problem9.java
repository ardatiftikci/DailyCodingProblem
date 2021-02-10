public class Problem9 {

	public static void main(String[] args) {
		System.out.println(p9());
	}

	public static int p9() {
		int[] array = {2,4,6,2,5};
		int first = 0;
		int second = 0;

		for(int i=array.length-1;i>=0;i--) {
			int new_sum = Math.max(array[i] + second, first);
			second = first;
			first = new_sum;
		}

		return first;
	}

}
