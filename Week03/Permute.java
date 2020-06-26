import java.util.*;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        create(0, nums, new LinkedList<>(), res);
        return res;
    }

    private void create(int i, int[] nums, LinkedList<Integer> list, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!list.contains(nums[j])) {
                list.add(nums[j]);
                create(i + 1, nums, list, res);
                list.removeLast();
            }
        }
    }
}
