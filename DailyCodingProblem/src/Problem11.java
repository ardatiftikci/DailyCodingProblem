import java.util.ArrayList;
import java.util.HashSet;
/* Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 */
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
