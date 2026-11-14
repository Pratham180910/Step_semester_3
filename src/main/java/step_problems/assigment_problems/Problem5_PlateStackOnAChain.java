public class Problem5_PlateStackOnAChain {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static class PlateStack {
        private Node head;
        private int size;

        void push(String plate) {
            Node node = new Node(plate);
            node.next = head;
            head = node;
            size++;
            System.out.println("push " + plate + " -> top " + head.data + ", size " + size);
        }

        void pop() {
            if (isEmpty()) {
                System.out.println("pop -> stack is empty");
                return;
            }
            String plate = head.data;
            head = head.next;
            size--;
            System.out.println("pop -> " + plate + ", size " + size);
        }

        void peek() {
            if (isEmpty()) {
                System.out.println("peek -> stack is empty");
                return;
            }
            System.out.println("peek -> " + head.data);
        }

        boolean isEmpty() {
            return head == null;
        }
    }

    public static void main(String[] args) {
        PlateStack stack = new PlateStack();
        stack.push("P1");
        stack.push("P2");
        stack.peek();
        stack.pop();
        stack.push("P3");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("isEmpty -> " + stack.isEmpty());
        System.out.println();

        PlateStack other = new PlateStack();
        other.peek();
        other.push("A");
        other.push("B");
        other.push("C");
        other.pop();
        other.peek();
        System.out.println("isEmpty -> " + other.isEmpty());
    }
}
