class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return 1;
        int ans = 0, dp = 0, i;
        int[] last = new int[2];
        for(i=1; i<len; ++i) {
            if(nums[i]==nums[i-1]) continue;
            int inx = (nums[i] - nums[i-1])>0?0:1;
            dp = last[inx] + 1;
            last[inx^1] = Math.max(last[inx^1],dp);
            ans = Math.max(ans, dp);
        }
        return ans+1;
    }
}