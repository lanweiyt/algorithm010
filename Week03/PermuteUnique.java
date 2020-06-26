import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        create(new boolean[nums.length],0, nums, new ArrayList<>(), res);
        return res;
    }

    private void create(boolean[] used, int i, int[] nums, ArrayList<Integer> list, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) {
                continue;
            }
            if (j > 0 && nums[j] == nums[j-1] && used[j-1]) break;
            list.add(nums[j]);
            used[j] = true;
            create(used,i + 1, nums, list, res);
            list.remove(list.size() - 1);
            used[j] = false;
        }
    }
}
