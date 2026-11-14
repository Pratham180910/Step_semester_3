import java.util.Scanner;

public class WeeklyRainfallAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rainfall = new double[7];
        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();
        }

        double total = 0;
        int wettest = 0;
        int dryDays = 0;
        StringBuilder readings = new StringBuilder("Rainfall (mm):");

        for (int i = 0; i < 7; i++) {
            readings.append(" ").append(rainfall[i]);
            total += rainfall[i];
            if (rainfall[i] > rainfall[wettest]) {
                wettest = i;
            }
            if (rainfall[i] == 0) {
                dryDays++;
            }
        }

        System.out.println(readings);
        System.out.println("Total Rainfall: " + total + " mm");
        System.out.println("Average Rainfall: " + String.format("%.2f", total / 7) + " mm");
        System.out.println("Wettest Day: Day " + (wettest + 1) + " (" + rainfall[wettest] + " mm)");
        System.out.println("Total Dry Days: " + dryDays);
    }
}
