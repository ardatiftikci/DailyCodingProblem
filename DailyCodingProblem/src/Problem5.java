class Pair<T> {
	private T a;
	private T b;

	public Pair(T a, T b) {
		this.a=a;
		this.b=b;

	}

	public static <T> Pair<T> cons(T a, T b) {
		return new Pair<T>(a, b);
	}

	public static <T> T car(Pair<T> p) {
		return p.a;
	}

	public static <T> T cdr(Pair<T> p) {
		return p.b;
	}

}
public class Problem5 {

	public static void main(String[] args) {
		p5();
	}

	public static void p5() {
		Pair<Integer> p = Pair.cons(3,4);
		Integer a = Pair.car(p);
		System.out.println("p.car() = " + a);
		Integer b = Pair.cdr(p);
		System.out.println("p.cdr() = " + b);
	}



}
