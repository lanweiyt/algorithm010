class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= index) {
                index = i;
            }
        }
        return index == 0;
    }
}