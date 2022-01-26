package Arrays;

//Binary Search modified
// We can get minimum element by check the pvt element which is the last element obtained after doing all the rotations which is in front of the
// original sorted array's first index element (minimum element)
//e.g {3,4,5,6,7,0,1,2} --> PVT is 7 obtained after doing 5 rotations on og. array {0,1,2,3,4,5,6,7,}

// The element right to pvt element is always smaller than it in such case our answer is on mid+1 index --> CONDITION 2 - 1ST IF LOOP
// if the mid element is our answer, then the element left to it must be greater than it , our ans is mid index -> CONDITION 2 - 2ND IF LOOP
public class minRotatedArray {
    public static void main(String[] args) {
        int nums[] = { 11, 12, 13, 14, 15 };
        int ans = 0;// by default we take index 0 as the minimum number index in the array so that
                    // if the binary search run and dosent find
                    // ans in the rest of the array excpet for index 0, then ans is the value at
                    // first index.
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + ((e - s) / 2);

            if (mid < e && nums[mid] > nums[mid + 1]) { // the first condition (mid<e) ensures that if mid reaches end
                                                        // like in the case of nums={11}
                                                        // then we can skip running this loop
                                                        //and the second condition 
                ans = mid + 1;

                break;
            }
            if (mid > s && nums[mid] < nums[mid - 1]) { // the first condition (mid<e) ensures that if mid reaches end
                                                        // like in the case of nums={11}
                                                        // then we can skip running this loop
                ans = mid;

                break;
            }
            if (nums[mid] > nums[e]) { // if mid element is greater than our mid element , then our answer lies b/w mid and end index   
                                        //{3,4,5,6,7,0,1,2} --> end is 2 , mid is 7 , ans is b/w 7 and 2 , i.e 0
                s = mid + 1;
            } else {  // if current end element is greater than mid element, then we are already in a sorted aray and have to 
                        //look in the elements before mid , e.g {5,0,1,2,3,4}, mid =1 > end = 4, we have to look before mid
                e = mid - 1;
            }
        }

        System.out.println(nums[ans]);
    }
}
