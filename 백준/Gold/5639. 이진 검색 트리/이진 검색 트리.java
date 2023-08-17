
import java.io.*;
import java.util.*;

class Node {
	int num;
	Node left;
	Node right;

	Node(int num) {
		this.num = num;
	}

	Node(int num, Node left, Node right) {
		this.num = num;
		this.left = left;
		this.right = right;
	}

	public void insert(int num) {
		if (num < this.num) {
			if (this.left == null) left = new Node(num);
			else this.left.insert(num);
		} else {
			if (this.right == null) right = new Node(num);
			else this.right.insert(num);
		}
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node tree = new Node(Integer.parseInt(br.readLine()));

		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) break;
			int num = Integer.parseInt(str);
			tree.insert(num);
		}

		postOrder(tree);
	}

	private static void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}

}