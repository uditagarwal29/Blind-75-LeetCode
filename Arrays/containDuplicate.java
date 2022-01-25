package Arrays;

import java.util.*;

public class containDuplicate {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        HashSet<Integer> count = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            if (count.contains(ele)) {
                flag = true;
                break;
            } else {
                count.add(nums[i]);
            }
        }
        System.out.println(flag);
    }
}
