package com.test;//采用hash去重，需要申请另外的空间
//循环数组，从第二个元素开始。只要这个数未出现过，就将该数放入对应的位置，且返回值+1

public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length < 1) {
        return 0;
    }

    int newIndex = 1;

    for (int i=1,length = nums.length; i<length; i++) {
        if (nums[i] != nums[i-1]) {
            nums[newIndex++] = nums[i];
        }
    }
    return newIndex;
}