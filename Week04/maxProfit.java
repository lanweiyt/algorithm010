class Solution {
//    public int maxProfit(int[] prices) {
//         if (prices.length < 2) {
//             return 0;
//         }
//         int res = 0;
//         int j = 0;
//         boolean paid = false;
//         for (int i = 0; i < prices.length - 1; i++) {
//             if (!paid) {
//                 if (prices[i + 1] > prices[i]) {
//                     j = i;
//                     paid = true;
//                 }
//             } else {
//                 if (prices[i + 1] < prices[i]) {
//                     paid = false;
//                     res += prices[i] - prices[j];
//                 }
//             }
//         }
//         if (paid) {
//             res += prices[prices.length - 1] - prices[j];
//         }
//         return res;
//     }


    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}