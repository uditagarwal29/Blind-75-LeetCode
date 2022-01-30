package Matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        // We take 4 pointers
        int r1 = 0; // --> topmost row
        int c1 = matrix[0].length - 1;// --> leftmost column
        int r2 = matrix.length - 1;// --> bottom row
        int c2 = 0;// --> first column
        List<Integer> ans = new ArrayList<Integer>();

        while (r1 <= r2 && c2 <= c1) {

            // topmost row
            for (int i = c2; i <= c1; i++) {
                // System.out.print(matrix[r1][i] + " ");
                ans.add(matrix[r1][i]);
            }
            r1++;

            // rightmost column
            for (int i = r1; i <= r2; i++) {
                // System.out.print(matrix[i][c1] + " ");
                ans.add(matrix[i][c1]);
            }
            c1--;

            if (r2 > r1) { // this condition is to dont the last row again(reversed) in case of even
                           // columns
                // bottom row
                for (int i = c1; i >= c2; i--) {
                    // System.out.print(matrix[r2][i] + " ");
                    ans.add(matrix[r2][i]);
                }
                r2--;
            }

            if (c1 > c2) {// this condition is to dont the last column again(reversed) in case of even
                          // rows
                // leftmost column
                for (int i = r2; i >= r1; i--) {
                    // System.err.print(matrix[i][c2] + " ");
                    ans.add(matrix[i][c2]);
                }
                c2++;
            }
        }
        System.out.println(ans);

    }
}
