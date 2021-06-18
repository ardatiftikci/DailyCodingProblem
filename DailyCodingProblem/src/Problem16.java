/*We are interested in finding the longest (number of characters) absolute path to a file within our file system.
 */

class ECommerceDS{
	private static final int N = 5;
	int[] log = new int[N];
	int first = 0;
	public void record(int order_id) {
		log[first] = order_id;
		first = (first+1)%N;
	}

	public int get_last(int i) {
		return log[Math.floorMod(first-i,N)];
	}

	@Override
	public String toString() {
		String representation = "";
		for(int i=first; i<first+N;i++) {
			representation+=log[i%N]+", ";
		}
		return representation;
	}
}
public class Problem16 {
	public static void main(String[] args) {
		p16();
	}

	public static void p16() {
		ECommerceDS log = new ECommerceDS();
		log.record(3);
		System.out.println(log);
		System.out.println(log.get_last(1));
		log.record(5);
		log.record(7);
		log.record(10);
		System.out.println(log);
		log.record(12);
		System.out.println(log);
		log.record(14);
		System.out.println(log);
		System.out.println(log.get_last(1));
		System.out.println(log.get_last(5));

	}

}