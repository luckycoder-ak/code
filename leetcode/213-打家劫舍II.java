class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp1 = new int[len+1];
        int[] dp0 = new int[len+1];
        int ans = nums[0];
        // 1号房不取
        for(int i=2; i<=len; ++i) {
            // 取当前房子,则前一个房子不能取
            dp1[i] = dp0[i-1] + nums[i-1];
            // 不取当前房子，则前一个取不取都可以
            dp0[i] = Math.max(dp0[i-1], dp1[i-1]);
            ans = Math.max(ans, Math.max(dp0[i],dp1[i]));
        }
        for(int i=0;i<=len; ++i) dp0[i]=dp1[i]=0;
        // 最后一号房不取
        for(int i=1; i<len; ++i) {
            // 取当前房子,则前一个房子不能取
            dp1[i] = dp0[i-1] + nums[i-1];
            // 不取当前房子，则前一个取不取都可以
            dp0[i] = Math.max(dp0[i-1], dp1[i-1]);
            ans = Math.max(ans, Math.max(dp0[i],dp1[i]));
        }
        return ans;
    }
}