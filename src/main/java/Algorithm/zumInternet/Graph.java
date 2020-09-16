package Algorithm.zumInternet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    private Node[] nodes;
    private List list = new ArrayList();

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    int dfs() {
        return dfs(0);
    }

    int dfs(int index) {
        int max =0;
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            max++;
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            list.add(r.data);

        }
        return max;
    }

    public static int solution(int[] A) {

        Graph graph = new Graph(A.length);

        for(int i=0; i<A.length; i++) {
            graph.addEdge(i, A[i]);
        }
        return graph.dfs();
    }

    public static void main(String[] args) {

        int[] A = {5, 4, 0, 3, 1, 6, 2};

        System.out.println(solution(A));
    }
}
