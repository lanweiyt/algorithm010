class Solution {

    public boolean lemonadeChange(int[] bills) {
        int money[] = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0] += 1;
            }
            if (bills[i] == 10) {
                money[0] -= 1;
                if (money[0] < 0) {
                    return false;
                }
                money[1] += 1;
            }
            if (bills[i] == 20) {
                if (money[1] > 0) {
                    money[1] -= 1;
                    money[0] -= 1;
                    if (money[0] < 0) {
                        return false;
                    }
                } else {
                    money[0] -= 3;
                    if (money[0] < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}