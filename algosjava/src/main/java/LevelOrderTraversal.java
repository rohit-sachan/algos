import java.util.LinkedList;
import java.util.Queue;

/**
 * Connect nodes on same level in a binary tree.
 *
 */
public class LevelOrderTraversal {
    static class Node
    {
        int data;
        Node left;
        Node right;

        // constructor
        Node(int data){
            this.data = data;
            left = null;
            right =null;
        }

        @Override
        public String toString() {
            return  data +
                    ", ";
        }
    }

    public static void main(String[] args)
    {
        // Let us create binary tree shown in above diagram
       /*               1
                   /     \
                  2       3
                /   \       \
               4     5       6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        printLevelOrder(root);
    }

    private static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){

            int size = q.size();
            /* store the size here (inside for loop queue size will decrease and then increase) before polling the current level elements,
             because in next for loop we are going to put all the elements of next level one by one left to right for current level nodes, but we don't want to touch them yet (first finish the current level elements)
             How to finish current level elements just iterate till the current size of queue. How it works?
            */
            for(int i = 1; i<= size; i++) {
                Node node = q.poll();
                System.out.print(node);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.println("");
        }

    }

}


