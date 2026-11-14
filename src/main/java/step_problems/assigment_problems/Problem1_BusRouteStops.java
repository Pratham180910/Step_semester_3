public class Problem1_BusRouteStops {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] stops) {
        Node head = null;
        Node tail = null;
        for (String stop : stops) {
            Node node = new Node(stop);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    static void printRoute(Node head) {
        StringBuilder route = new StringBuilder();
        int count = 0;
        Node last = null;
        for (Node cur = head; cur != null; cur = cur.next) {
            route.append(cur.data).append(" -> ");
            count++;
            last = cur;
        }
        route.append("null");
        System.out.println(route);
        if (head != null) {
            System.out.println("Stops: " + count + ", First: " + head.data + ", Last: " + last.data);
        }
    }

    public static void main(String[] args) {
        printRoute(build(new String[]{"Tambaram", "Guindy", "TNagar", "Central"}));
        System.out.println();
        printRoute(build(new String[]{"Potheri"}));
        System.out.println();
        printRoute(build(new String[]{"Chengalpattu", "Maraimalai Nagar", "Vandalur"}));
    }
}
