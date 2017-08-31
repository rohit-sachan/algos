import java.util.*;
import java.util.LinkedList;

/**
 * Created by dell on 02/08/17.
 */
public class Tree {

    static class Node{
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        Node n2 = new Node(6);
        Node n3 = new Node(8);
        root.left = n2; root.right=n3;

        Node n4 = new Node(2);
        Node n5 = new Node(11);
        n2.left = n4;n2.right=n5;

        Node n6 = new Node(13);
        n3.right = n6;

        Node n7 = new Node(9);
        Node n8 = new Node(5);
        n5.left = n7; n5.right=n8;

        Node n9 = new Node(7);
        n6.left=n9;

        Node lca = lca(root,n4,n8);
        System.out.println("lca = " + lca);

        levelOrderTraversal(root);

    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList();

        q.add(root);

        while (!q.isEmpty()){
            Node n = q.poll();
            if(n.left != null) q.add(n.left);
            if(n.right != null) q.add(n.right);
            System.out.println(n);
        }

    }

    private static Node lca(Node root, Node n, Node m) {
        if(root == null) return null;
        if(root.equals(n)) return n;
        if(root.equals(m)) return m;

        Node left = lca(root.left,n,m);
        Node right= lca(root.right,n,m);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }

}
