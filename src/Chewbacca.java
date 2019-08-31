import java.util.ArrayList;
import java.util.Random;

//import java.util.Arrays;
//import javax.swing.JOptionPane;

class Node {
	int parent;
	int node;

	Node(int node) {
		this.node = node;
	}

	Node(int node, int parent) {
		this.node = node;
		this.parent = parent;
	}
}

public class Chewbacca {

	public static void main(String[] args) {
		Random rand = new Random();
//		int n = rand.nextInt((int)1e15-1)+1, k = rand.nextInt((int)1e3-1)+1, q = rand.nextInt((int)1e5-1)+1;
		int n = rand.nextInt((int) 100 - 1) + 1, k = rand.nextInt((int) 20 - 1) + 1, q = rand.nextInt((int) 30 - 1) + 5;

		// Show Input
		System.out.println("Input:\nn k q");
		System.out.printf("%d %d %d\n", n, k, q);

		// Set Queries and Nodes
		ArrayList<Integer> query = new ArrayList<Integer>();
		setQueries(query, n, q);
		Node[] nodes = new Node[n];
		setNodes(nodes, n, k);

		// Show Nodes
		System.out.println();
		for (Node no : nodes) {
			System.out.println("Node " + no.node + " has parent " + no.parent);
		}

		// Show Queries
		System.out.println();
		for (int i = 0; i < query.size(); i += 2) {
			System.out.print(query.get(i) + " ");
			System.out.println(query.get(i + 1));
			System.out.println(getDist(nodes, query.get(i), query.get(i + 1)) + "\n");
		}
	}

	static void setQueries(ArrayList<Integer> path, int n, int q) {
		// [ x1, y1, x2, y2 ... ]
		Random rand = new Random();
		for (int i = 0; i < q; i++) {
			path.add(rand.nextInt(n - 1) + 1);
			path.add(rand.nextInt(n - 1) + 1);
		}
	}

	static void setNodes(Node[] nodes, int n, int k) {
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i + 1);
		}
		int curNode = 1;
		nodes[0].parent = 0;// set node 1 (located at nodes[0]) as having node 0 as parent (doesnt exist?)
		for (int i = 1; i <= (n - 1) / k + 1; i++) {
			for (int j = 0; j < k; j++, curNode++) {
				try {
					nodes[curNode].parent = i;
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
//					System.out.println("Node unmaxed.");
					break;
				}
			}
		}
	}

	static int getDist(Node[] nodes, int a, int b) {

		if (a == 0 || b == 0) {
			System.out.print("Error. No node 0.");
			return -1;
		}
		if (a == b) { // special case are same node
//			System.out.print("[Y] ");
			return 0;
		}
		Node n1=nodes[a-1], n2=nodes[b-1], temp;
		if (n1.node == n2.parent || n1.parent == n2.node) { // special case parent/child
//			System.out.print("[Y] ");
			return 1;
		}
		if (n1.parent == n2.parent) {// special case same parent
//			System.out.print("[Y] ");
			return 2;
		}
		// check for common grand...parent OR is grand...parent
		// would be useful to know what layer in or how many to 1
		int x=0;
		while (true) {
//			System.out.println(n1.node+" | "+n2.node);
			if (n1.node>n2.node) {
				x++;
				n1 = nodes[n1.parent-1];
			}
			if (n1.node<n2.node) {
				temp = n1;
				n1 = n2;
				n2 = temp;
			}
			if (n1.node==n2.node) {
				return x;
			}
		}
	}

}
