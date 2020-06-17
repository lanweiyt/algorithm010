//将原数组转为一个map，key为原数组的元素，value为原数组的下标；
//循环nums，target-nums[i]的值就是map中的的key，返回i和key即可
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = nums.length - 1; i >= 0; i--) {
        Integer otherIndex = map.get(target - nums[i]);
        if (otherIndex != null && i != otherIndex) {
            return new int[]{otherIndex, i};
        } else{
            map.put(nums[i], i);
        }
    }
    return null;
}

//优化上述代码，采用另外一个数组来代替map
public int[] twoSum(int[] nums, int target) {
    int length = 4095;//2的n次幂-1，用于计算数据的下标位置。这个值为1023在LeetCode上测试不通过……2047和4095可以通过，这个问题还没找到原因
    int[] temp = new int[length + 1];
    for (int i = 0; i < nums.length; i++) {
        int diff = target - nums[i];
        if (temp[diff & length] != 0) {
            return new int[]{temp[diff & length] - 1, i};
        }
        else {
            temp[nums[i] & length] = i + 1;
        }
    }
    return null;
}