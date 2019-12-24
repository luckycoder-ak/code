class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len+1];
        dp[1] = A[0];
        dp[0] = 0;
        for (int i=1; i<=len; ++i) {
            int maxx = -10000;
            for(int j=1; j<=K&&i-j>=0; ++j) {
                maxx = Math.max(maxx, A[i-j]);
                dp[i] = Math.max(dp[i], dp[i-j]+maxx*j);
            }
//            System.out.println("dp["+i+"]="+dp[i]);
        }
        return dp[len];
    }
}