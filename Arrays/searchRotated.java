package Arrays;

public class searchRotated {
    public static int binarySearch(int[] arr, int target, int s, int e) {
        while (s <= e) {
            int mid = s + ((e - s) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 1 };
        int target = 0;
        int pvt = -1;

        // finding pivot point
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = s + ((e - s) / 2);

            if (mid < e && nums[mid] > nums[mid + 1]) {
                pvt = mid;
                break;
            }

            if (mid > s && nums[mid] < nums[mid - 1]) {
                pvt = mid - 1;

                break;
            }

            if (nums[mid] > nums[e]) {
                s = mid + 1;

            } else {
                e = mid - 1;

            }

        }

        // Searching
        if (pvt == -1) {
            System.out.println(binarySearch(nums, target, 0, nums.length - 1));
        } else if (nums[pvt] == target) {
            System.out.println(pvt);
        } else if (target < nums[pvt] && target >= nums[0]) {
            System.out.println(binarySearch(nums, target, 0, pvt - 1));
        } else {
            System.out.println(binarySearch(nums, target, pvt + 1, nums.length - 1));
        }
    }
}
