public class Problem4_CancelABooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] bookings) {
        Node head = null;
        Node tail = null;
        for (String booking : bookings) {
            Node node = new Node(booking);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }
        if (head.data.equals(booking)) {
            return head.next;
        }
        Node cur = head;
        while (cur.next != null && !cur.next.data.equals(booking)) {
            cur = cur.next;
        }
        if (cur.next == null) {
            System.out.println(booking + " not found");
            return head;
        }
        cur.next = cur.next.next;
        return head;
    }

    static void printChain(Node head) {
        StringBuilder chain = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            chain.append(cur.data).append(" -> ");
        }
        chain.append("null");
        System.out.println(chain);
    }

    public static void main(String[] args) {
        Node bookings1 = build(new String[]{"104", "101", "107", "101"});
        bookings1 = removeFirst(bookings1, "101");
        printChain(bookings1);

        Node bookings2 = build(new String[]{"104", "101", "107"});
        bookings2 = removeFirst(bookings2, "104");
        printChain(bookings2);

        Node bookings3 = build(new String[]{"104", "101"});
        bookings3 = removeFirst(bookings3, "200");
        printChain(bookings3);

        Node bookings4 = build(new String[]{"301"});
        bookings4 = removeFirst(bookings4, "301");
        printChain(bookings4);
    }
}
