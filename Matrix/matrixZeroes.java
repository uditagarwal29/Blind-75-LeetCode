package Matrix;

import java.util.*;

//APPROACH 1 -> 0(1) SPACE
//java matrixZeroes.java
public class matrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        // we are taking the first row and first column in the array as extra space for
        // storing rows and columns that have to be made 0
        // so we start from index (1,1) and traverse the array leaving the first row and
        // index
        // but first we have to check if there are 0's in first row and first column,
        // for this we use boolean flag
        boolean fr = false, fc = false;
        // checking if first row has 0
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                fr = true;
                break;
            }
        }
        // checking if first column has 0
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                fc = true;
                break;
            }
        }
        // marking the first row and first column by checking array from index [1,1]
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; // marking in the first row
                    matrix[i][0] = 0; // marking in the first column
                }
            }
        }

        // traversing each element, if the element at the first row or the first col at
        // the elements index =0 , make that element 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // making first row or first column zero if boolean flags fc and fr = true
        if (fr) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// //O(M+N approach)
// public class matrixZeroes {
// public static void main(String[] args) {
// int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
// int m = matrix.length;
// int n = matrix[0].length;
// List<Integer> rows = new ArrayList<Integer>(); // to store all the rows where
// 0 is present -> we make all
// // elements of this row =0
// List<Integer> cols = new ArrayList<Integer>();// to store all the colmns
// where 0 is present -> we make all
// // elements of this col =0

// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (matrix[i][j] == 0) {
// if (!rows.contains(i)) { // finding 0 value rows
// rows.add(i);
// }
// if (!cols.contains(j)) {// finding 0 value cols
// cols.add(j);
// }
// }
// }
// }

// for (int i = 0; i < matrix.length; i++) {
// for (int j = 0; j < matrix[0].length; j++) {
// if (rows.contains(i)) { // if this row has 0
// matrix[i][j] = 0; // make all elements of this row =0
// } else if (cols.contains(j)) { // if this column has 0
// matrix[i][j] = 0; // make all the elements of this column = 0
// }
// }
// }
// for (int x = 0; x < matrix.length; x++) {
// for (int j = 0; j < matrix[0].length; j++) {
// System.out.print(matrix[x][j] + " ");
// }
// System.out.println();
// }
// }
// }