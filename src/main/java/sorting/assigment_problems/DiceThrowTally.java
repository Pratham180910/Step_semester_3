import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }

        StringBuilder counts = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) {
            counts.append(" ").append(v).append(":").append(count[v]);
        }
        System.out.println(counts);

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int k = 0; k < count[v]; k++) {
                sorted[index++] = v;
            }
        }
        System.out.println("Sorted: " + Arrays.toString(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        diceSort(new int[]{4, 1, 6, 4, 2, 1, 4});
        System.out.println();
        diceSort(new int[]{6, 5, 3, 3, 5, 6, 6, 1});
    }
}
