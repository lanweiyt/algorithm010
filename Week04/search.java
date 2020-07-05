class Solution {
    //先找中间位置索引mid，判断mid是不是target的索引，是的话就返回
    //否则，若left到mid位置是有序的（nums[left] <= nums[mid]):
    //  判断target是否在mid的左边（nums[left] <= target && nums[mid] > target):
    //      是：right = mid - 1;否：left = mid + 1;
    //若left到mid位置是无序的（则mid到right肯定有序，因为只nums是一个有序数组只旋转了一次得到的）
    //  判断target是否在mid的右边（nums[mid] < target && nums[right] >= target）
    //      是：left = mid + 1；否：right = mid - 1

    public static int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}