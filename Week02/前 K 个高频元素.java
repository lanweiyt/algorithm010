//采用优先级队列
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
        map.put(n, map.getOrDefault(n,0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> queue =
        new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        queue.offer(entry);
    }

    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
        Map.Entry<Integer, Integer> entry = queue.poll();
        res[i] = entry.getKey();
    }
    return res;
}