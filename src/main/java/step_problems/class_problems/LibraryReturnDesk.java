import java.util.Scanner;

public class LibraryReturnDesk {

    static class Pile {
        private String[] items = new String[3];
        private int top = -1;

        void push(String book) {
            if (top == items.length - 1) {
                System.out.println(book + " rejected: pile is full");
                return;
            }
            items[++top] = book;
            System.out.println(book + " placed on pile");
        }

        void pop() {
            if (top == -1) {
                System.out.println("pile is empty");
                return;
            }
            System.out.println("shelved " + items[top--]);
        }
    }

    static class Line {
        private String[] items = new String[3];
        private int front = 0;
        private int rear = -1;
        private int size = 0;

        void enqueue(String student) {
            if (size == items.length) {
                System.out.println(student + " rejected: line is full");
                return;
            }
            rear = (rear + 1) % items.length;
            items[rear] = student;
            size++;
            System.out.println(student + " joined the line");
        }

        void dequeue() {
            if (size == 0) {
                System.out.println("no one waiting");
                return;
            }
            String student = items[front];
            front = (front + 1) % items.length;
            size--;
            System.out.println("served " + student);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()) {
            input.append(sc.nextLine()).append(",");
        }

        Pile pile = new Pile();
        Line line = new Line();

        for (String command : input.toString().split(",")) {
            command = command.trim();
            if (command.isEmpty()) {
                continue;
            }
            String[] parts = command.split("\\s+", 2);
            String action = parts[0].toUpperCase();

            if (action.equals("RETURN") && parts.length == 2) {
                pile.push(parts[1]);
            } else if (action.equals("SHELVE")) {
                pile.pop();
            } else if (action.equals("WAIT") && parts.length == 2) {
                line.enqueue(parts[1]);
            } else if (action.equals("SERVE")) {
                line.dequeue();
            } else {
                System.out.println("invalid command: " + command);
            }
        }
    }
}
