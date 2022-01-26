package Arrays;

//https://www.youtube.com/watch?v=hJ_Uy2DzE08

public class maxProductSubArray {
    public static void main(String[] args) {
        int nums[] = { 2, 10, 0, 9 };

        int currMax = nums[0], currMin = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //Edgecase -> if 0 is present, we divide the array around it into 2 parts, leaving 0 out of the product subarray
            //resetting currMax  and currMin to calculate max min of next subarray.
            if (nums[i] == 0) {
                currMax = 1;
                currMin = 1;
            }
            //: For each index i keep updating the max and min. We are also keeping min because on multiplying with any 
            //negative number your min will become max and max will become min. 
            int temp = currMax;
            currMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]), nums[i]);
            currMin = Math.min(Math.min(temp * nums[i], currMin * nums[i]), nums[i]);

            //max * nums[i] = if next element is +ve and the * with it will make our ans higher
            //min *nums[i] = if the currmin is -ve and we current element is -ve and we multiply them, we get a higher number
            //nums[i] = if both the max and min sum have been negative and we encounter an element which is greater than both of them
        

            if (currMax > ans) {
                ans = currMax;
            }
        }

        System.out.println("Max Product is : " + ans);

    }
}
