package main.java.Linear_Data_Structures.assigment_problems;


public class BusiestRow {

    public static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int rowIndex = 0;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }

            if (total > maxTotal) {
                maxTotal = total;
                rowIndex = i;
            }
        }

        System.out.println("Row " + rowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid);
    }
}