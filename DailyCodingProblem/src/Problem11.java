import java.util.ArrayList;
import java.util.HashSet;

public class Problem11 {

	public static void main(String[] args) {
		p11();
	}

	public static void p11() {
		HashSet<String> allPossibleQueries = new HashSet<>();
		allPossibleQueries.add("deer");
		allPossibleQueries.add("deal");
		allPossibleQueries.add("dog");
		String prefix = "de";
		System.out.println(autocomplete(allPossibleQueries, prefix));
	}

	private static ArrayList<String> autocomplete(HashSet<String> allPossibleQueries, String prefix) {
		ArrayList<String> list = new ArrayList<>();
		for(String str : allPossibleQueries) {
			if(str.startsWith(prefix)){
				list.add(str);
			}
		}
		return list;
	}
}
