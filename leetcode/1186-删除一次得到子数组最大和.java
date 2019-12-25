class Solution {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len+1];
        int[] dp0 = new int[len+1];
        int res = arr[0];
        dp0[0] = -100000;
        for(int i=1; i<=len; ++i) {
            dp[i] = Math.max(dp0[i-1], dp[i-1]+arr[i-1]);
            dp0[i] = Math.max(dp0[i-1]+arr[i-1], arr[i-1]);
            dp[i] = Math.max(dp0[i], dp[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}