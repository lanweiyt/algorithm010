import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        Combine c = new Combine();
        System.out.println(c.combine(4,2));
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        track(new ArrayList<>(), 1,k,n);
        return res;
    }
    public void track(List<Integer> list,int start,int k,int n) {
        if (k==0) {
            res.add(new ArrayList<>(list));
            return;

        }
        for (int i = start; i <=n-k+1; i++) {
            list.add(i);
            track(list, i+1, k-1, n);
            list.remove(list.size() - 1);
        }
    }

}
