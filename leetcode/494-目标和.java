class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = S;
        for(int x: nums) sum+=x;
        if((sum&1)!=0 || sum-S<S) return 0;
        int V = sum>>1;//背包容量大小
        int[] dp = new int[V+1];
        dp[0] = 1;
        int i, j;
        int sz = nums.length;
        for(i=0; i<sz; ++i) {
            for(j=V; j-nums[i]>=0; --j) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[V];
    }
}