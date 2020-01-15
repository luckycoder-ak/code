class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp1 = new int[len+1];
        int[] dp0 = new int[len+1];
        int ans = nums[0];
        // 1�ŷ���ȡ
        for(int i=2; i<=len; ++i) {
            // ȡ��ǰ����,��ǰһ�����Ӳ���ȡ
            dp1[i] = dp0[i-1] + nums[i-1];
            // ��ȡ��ǰ���ӣ���ǰһ��ȡ��ȡ������
            dp0[i] = Math.max(dp0[i-1], dp1[i-1]);
            ans = Math.max(ans, Math.max(dp0[i],dp1[i]));
        }
        for(int i=0;i<=len; ++i) dp0[i]=dp1[i]=0;
        // ���һ�ŷ���ȡ
        for(int i=1; i<len; ++i) {
            // ȡ��ǰ����,��ǰһ�����Ӳ���ȡ
            dp1[i] = dp0[i-1] + nums[i-1];
            // ��ȡ��ǰ���ӣ���ǰһ��ȡ��ȡ������
            dp0[i] = Math.max(dp0[i-1], dp1[i-1]);
            ans = Math.max(ans, Math.max(dp0[i],dp1[i]));
        }
        return ans;
    }
}