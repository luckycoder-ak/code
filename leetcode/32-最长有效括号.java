class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(), ans=0;
        int[] dp = new int[len];
        for (int k=0; k<len; ++k) {
            if(s.charAt(k) == ')') {
                if (k==0) continue;
                if(s.charAt(k-1)=='(') dp[k] = ((k-2>=0)?dp[k-2]:0)+2;
                else { 
                    if (dp[k-1]!=0) {
                        int last_left = k-dp[k-1]-1;
                        if (last_left>=0 && s.charAt(last_left) == '(') {
                            dp[k] = dp[k-1] + 2 + (last_left>0?dp[last_left-1]:0);
                        }
                    }
                }
            }
            ans = Math.max(ans, dp[k]);
        }
        return ans;
    }
}