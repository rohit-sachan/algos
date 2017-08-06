import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 02/08/17.
 */
public class LinkedList {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val+" -> "+next.val +", " ;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return val == node.val;

        }

        @Override
        public int hashCode() {
            return val;
        }
    }
    public static void main(String[] args) {
//        doReversal();
        findCycle();
    }

    private static void findCycle() {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n4;

        Node n = n1;
        List<Node> visited = new ArrayList<>();
        while(n.next!= null && !visited.contains(n)){
            System.out.print(n);
            visited.add(n);
            n=n.next;
        }

        Node junctionNode = findCycleNode(n1);

        System.out.println("Cycle at node: "+ junctionNode);

    }

    private static Node findCycleNode(Node n1) {
        return null;
    }

    private static void doReversal() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;

        Node n = n1;
        while(n.next!= null){
            System.out.print(n);
            n=n.next;
        }

        Node reverted = revers(n1);

        System.out.println("\nafter reversal ");
        n = reverted;
        while(n.next!= null){
            System.out.print(n);
            n=n.next;
        }
    }

    private static Node revers(Node start) {

        Node nfr = start.next;
        start.next=null;
        while (nfr != null){
            Node temp_orphan = nfr.next;
            Node start_temp = start;
            nfr.next = start_temp;
            start = nfr;
            nfr = temp_orphan;
        }
        return start;
    }
}
