class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length < 1 || s.length < 1) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (j < g.length && s[i] >= g[j]) {
                j ++;
            }
        }

        return j;
    }
}