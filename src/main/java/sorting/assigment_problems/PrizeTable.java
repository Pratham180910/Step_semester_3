import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {45, 90, 60, 75},
            {80, 70, 60},
            {10, 50, 30, 20, 40}
        };
        for (int[] marks : tests) {
            int swaps = prizeTable(marks);
            System.out.println(Arrays.toString(marks) + "   swaps = " + swaps);
        }
    }
}
