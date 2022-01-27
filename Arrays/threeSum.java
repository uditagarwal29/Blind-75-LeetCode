package Arrays;

import java.util.*;

public class threeSum {
    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4 };
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            // To skip duplicates easily done as array is sorted
            //example if we have {-2 ,-2 ,1 ,1 0 ,2} , then at index 0 and 1 we have same values and will get same pairs from twoSum logic
            // so we skip that index
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int s = i + 1;
            int e = nums.length - 1;

            //twoSum 2 logic using a modified 2 pointer approach
            while (s < e) {
                int twoSum = nums[s] + nums[e];
                if (twoSum == (0 - nums[i])) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[s], nums[e])));
                    e--; //we decrease the end index because the  array is sorted so we have more chances of getting -(nums[i]) with values close
                    //nums[s] than nums[e]
                    while (s < e && nums[e] == nums[e + 1]) { //[0,0,0,0] --> in this case we might get duplicate twoSums [0,0], [0,0]
                                                                // so we reduce the end index till the value is not different from last end index val
                        e--;
                    }
                } else if (twoSum > (0 - nums[i])) {
                    e--;
                } else if (twoSum < (0 - nums[i])) {
                    s++;
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i) + " ");
        }

    }
}

// public class threeSum {

// public static int[] twoSum(int[] arr, int t) {

// HashMap<Integer, Integer> hm = new HashMap<>();

// int result[] = new int[2];
// result[0] = Integer.MIN_VALUE;
// result[1] = Integer.MIN_VALUE;

// for (int i = 0; i < arr.length; i++) {
// int remSum = t - arr[i];
// if (hm.containsKey(remSum)) {
// result[0] = arr[i];
// result[1] = arr[hm.get(remSum)];
// }
// hm.put(arr[i], i);
// }
// // System.out.println("--------------------------");
// // System.out.println("t= " + t);
// // for (int val : arr) {
// // System.out.print(val + " ");
// // }
// // System.out.println();
// // for (int val : result) {
// // System.out.print(val + " ");
// // }
// // System.out.println("\n"+"--------------------");
// return result;
// }

// public static void main(String[] args) {
// int nums[] = { -2,0,1,1,2};
// int twoSumAns[] = new int[2];
// List<List<Integer>> ans = new ArrayList<List<Integer>>();
// for (int i = 0; i < nums.length; i++) {
// int n1 = nums[i];
// int[] newArray = Arrays.copyOfRange(nums, i + 1, nums.length);
// twoSumAns = twoSum(newArray, -(n1));
// int n2 = twoSumAns[0];
// int n3 = twoSumAns[1];
// ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(n1, n2, n3));
// if (n2 != Integer.MIN_VALUE && n3 != Integer.MIN_VALUE ) {
// ans.add(temp);
// }

// }
// // list.contains(5)
// for (int i = 0; i < ans.size(); i++) {
// System.out.println(ans.get(i) + " ");
// }
// }
// }
