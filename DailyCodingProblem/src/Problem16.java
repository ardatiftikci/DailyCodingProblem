/* You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
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