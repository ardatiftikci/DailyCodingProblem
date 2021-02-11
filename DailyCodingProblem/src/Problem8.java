/* A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 */
public class Problem8 {

	static int count = 0;

	public static void main(String[] args) {
		//This problem uses Node class of Problem 3.
		Node root = new Node(0);
		root.left= new Node(1);
		root.right = new Node(0);
		root.right.left = new Node(1);
		root.right.right = new Node(0);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(1);
		System.out.println(p8(root));
	}

	public static int p8(Node root) {
		p8Helper(root);
		return count;
	}

	public static void p8Helper(Node root) {
		if(isUnival(root)) {
			count+=1;
		}
		if(!(root.left==null && root.right == null)) {
			p8Helper(root.left);
			p8Helper(root.right);
		}
	}


	public static boolean isUnival(Node root) {
		if(root==null) return false;
		if(root.left==null && root.right == null) {
			return true;
		}
		if(root.value!=root.left.value || root.value!=root.right.value) {
			return false;
		}
		else {
			return isUnival(root.left)&&isUnival(root.right);
		}
	}
}
