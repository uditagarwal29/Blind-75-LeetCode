package Arrays;

import java.util.*;

public class maximumSubArray {
    public static void main(String[] args) {
        int arr[] = { 5, 4, -1, 7, 8 };
        int cSum = 0, maxSum = Integer.MIN_VALUE;
        int start_idx = 0; // permament storage for start index of Max sum subarray.
        int s = 0; // temporary storage for start index. This resets every time we encounter -ve
                   // current sum;
        int end_idx = 0; // permanent storage for end index of Max sum subarray.
        for (int i = 0; i < arr.length; i++) {
            if (cSum > 0) {
                cSum += arr[i]; // only add to cSum if there if it is greater than 0
            } else {
                cSum = arr[i]; // if cSum is -ve, we dont want to add more -ve elements to it as it will
                               // decrease maxSum, so
                               // we take only the current -ve element
            }
            if (cSum > maxSum) {
                maxSum = cSum;    //updating maxSum
                if (maxSum < 0) {
                    start_idx = i; // if all -ve elements in array, select the minimum -ve number and it's index
                } else {
                    start_idx = s;
                }
                end_idx = i; // keep on updating end index as long as we're getting +ve cSum
            }
            if (cSum < 0) { // This condition starts calculation of next possible max sum subarray from the
                            // next iteration.
                s = i + 1; // resetting start index to next of element which made our cSum -ve
            }
        }

        System.out.println("Maximum sum is " + maxSum + " of subarray of length " + (end_idx - start_idx + 1));

        for (int i = start_idx; i <= end_idx; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// public class maximumSubArray {
//     public static void main(String[] args) {
//         int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//         int max = nums[0], cur = 0;
//         for (int i : nums) {
//             cur = Math.max(i, cur + i);
//             max = Math.max(cur, max);
//         }
//         System.out.println(max);
//     }
// }

// KADANES ALGORITHM
// This solution dosent give answer if there are only negative values in array
// public class maximumSubArray {
//     public static void main(String[] args) {
//         int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//         int cSum = 0, maxSum = 0;
//         int start_idx = 0; // permament storage for start index of Max sum subarray.
//         int s = 0; // temporary storage for start index. This resets every time we encouter -ve
//                    // current sum;
//         int end_idx = 0; // permanent storage for end index of Max sum subarray.
//         for (int i = 0; i < arr.length; i++) {
//             cSum += arr[i];
//             if (cSum > maxSum) {
//                 maxSum = cSum;
//                 start_idx = s;
//                 end_idx = i; // keep on updating end index as long as we're getting +ve cSum
//             }
//             if (cSum < 0) { // This condition starts calculation of next possible max sum subarray from the
//                             // next iteration.
//                 cSum = 0;
//                 s = i + 1; // resetting start index to next of element which made our cSum -ve
//             }
//         }

//         System.out.println("Maximum sum is " + maxSum + " of subarray of length " + (end_idx - start_idx + 1));

//         for (int i = start_idx; i <= end_idx; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }
// }
