import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	Node left = null;
	Node right = null;
	int value = 0;
	public Node(int value) {
		this.value=value;
	}
}

public class Problem3 {

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(6);
		root.left.left = new Node(8);
		root.left.right = new Node(7);
		root.right = new Node(10);
		root.right.left = new Node(9);
		root.right.right = new Node(11);
		p3(root);
	}

	public static void p3(Node root) {
		String serialized = serialize(root);
		Node newRoot = deserialize(serialized);
		if(serialized.equals(serialize(newRoot))) {
			System.out.println("Problem 3 is completed.");
		}
	}

	static String serialize(Node root) {
		if(root==null)return "X-";
		String left = serialize(root.left);
		String right = serialize(root.right);
		return root.value+"-"+left+right;
	}

	static Node deserialize(String serialized) {
		Queue<String> nodesLeft = new LinkedList<>();
		nodesLeft.addAll(Arrays.asList(serialized.split("-")));
		return deserializeHelper(nodesLeft);
	}
	
	static Node deserializeHelper(Queue<String> nodesLeft) {
		String value = nodesLeft.poll();
		if(value.equals("X")) return null;
		Node newNode = new Node(Integer.parseInt(value));
		newNode.left = deserializeHelper(nodesLeft);
		newNode.right = deserializeHelper(nodesLeft);
		return newNode;
	}


}
