public class Problem2_LateComersInTheLine {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] names) {
        Node head = null;
        Node tail = null;
        for (String name : names) {
            Node node = new Node(name);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    static Node addFirst(Node head, String name) {
        Node node = new Node(name);
        node.next = head;
        return node;
    }

    static Node addLast(Node head, String name) {
        Node node = new Node(name);
        if (head == null) {
            return node;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return head;
    }

    static void printLine(Node head) {
        StringBuilder line = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            line.append(cur.data).append(" -> ");
        }
        line.append("null");
        System.out.println(line);
    }

    public static void main(String[] args) {
        Node line1 = build(new String[]{"Asha", "Ravi"});
        line1 = addFirst(line1, "Neha");
        line1 = addLast(line1, "Kiran");
        line1 = addFirst(line1, "Mohan");
        printLine(line1);

        Node line2 = build(new String[]{});
        line2 = addLast(line2, "Pooja");
        line2 = addFirst(line2, "Arun");
        printLine(line2);

        Node line3 = build(new String[]{"Divya"});
        line3 = addLast(line3, "Suresh");
        line3 = addLast(line3, "Meena");
        line3 = addFirst(line3, "Vikram");
        printLine(line3);
    }
}
