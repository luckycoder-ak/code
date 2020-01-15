class Solution {
    public boolean canPartition(int[] nums) {
                int sum = 0;
        int len = nums.length;
        for(int i=0; i<len; ++i) sum+=nums[i];
        if((sum&1)!=0) return false;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=0; i<len; ++i) {
            for(int j=target; j>=nums[i]; --j) {
                dp[j]|=dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}