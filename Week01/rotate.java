//暴力法，循环k，每次移动一个位置，时间复杂度O（n*k）或者O（n^2)
public void rotate(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k < 0) {
        return;
    }

    for (int j=0; j<k; j++) {
        int temp = nums[nums.length - 1];
        for (int i=nums.length - 1; i>0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = temp;
    }
}

//使用队列。根据k和数组产地取模后的值，将数组分为两段，先把后面的一段数组放入队列，再将前面的一段数组放入队列。
// 依次取出，重新放入原数组即可
public void rotate(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k < 0) {
        return;
    }
    k = k % nums.length;
    Queue<Integer> queue = new ArrayDeque<>(nums.length);

    int length = nums.length;
    for (int i=length-k; i<length; i++) {
        queue.offer(nums[i]);
    }

    for (int i=0; i<length-k; i++) {
        queue.add(nums[i]);
    }
    int i = 0;
    while (queue.size() > 0) {
        nums[i++] = queue.poll();
    }
}

//第二种方法中，不使用队列。旋转k次后，实际是k%n个尾部元素会被移动到头部，剩下的元素会被向后移动。
//先反转数组，再反转前k个元素和后面剩下的元素

public void rotate(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k < 0) {
        return;
    }
    k = k%nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

public void reverse(int[] nums, int start, int end) {
    while (end > start) {
        int temp = nums[start];
        nums[start++] = nums[end];
        nums[end--] = temp;
    }
}