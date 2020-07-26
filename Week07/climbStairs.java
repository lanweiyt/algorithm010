public class climbStairs {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a0 = 1;
        int a1 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a1;
            a1 = a0 + a1;
            a0 = temp;
        }

        return a1;
    }
}
