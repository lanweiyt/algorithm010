class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("nums length mast larger than 0");
        }
        Integer min = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] <= nums[mid]) {
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            }

        }

        return min;
    }
}