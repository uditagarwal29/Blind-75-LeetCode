package Arrays;


//Inputs a sorted array, and uses two pointer approach to find out the pairs. Since array is sorted , we dont need nested loops
//as we can just move start and end pointers depending upon if the current sum is bigger than target or smaller than target
public class twoSum2 {
    public static void main(String[] args) {
        int nums[] = { 2,7,11,15};
        int t = 9;
        int s = 0;
        int e = nums.length - 1;
        int result[] = { -1, -1 };
        while (s <= e) {
            int sum = nums[s] + nums[e];
            if (sum > t) {
                e--;
            } else if (sum < t) {
                s++;
            } else {
                result[0] = nums[s];
                result[1] = nums[e];
            }
        }

        System.out.println(result[0] + " " + result[1]);

    }
}
