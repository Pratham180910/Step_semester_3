public class Problem3_BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] ids) {
        Node head = null;
        Node tail = null;
        for (String id : ids) {
            Node node = new Node(id);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    static String find(Node head, String id) {
        int position = 0;
        int copies = 0;
        int firstPosition = -1;
        for (Node cur = head; cur != null; cur = cur.next) {
            position++;
            if (cur.data.equals(id)) {
                copies++;
                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }
        }
        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Node trolley = build(new String[]{"B12", "B07", "B30", "B07", "B45", "B07"});
        System.out.println(find(trolley, "B07"));
        System.out.println(find(trolley, "B99"));
        System.out.println(find(trolley, "B12"));
    }
}
