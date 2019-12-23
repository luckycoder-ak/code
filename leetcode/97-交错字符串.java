class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len3 != len1 + len2) return false;
        boolean [][] dp = new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i=0; i<=len1; ++i) {
            for(int j=0; j<=len2; ++j) {
                if(i==0 && j==0) {
                    continue;
                }
                char c = s3.charAt(i+j-1);
                if(i>=1 && s1.charAt(i-1) == c) {
                    dp[i][j] |= dp[i-1][j];
                }
                if(j>=1 && s2.charAt(j-1) == c) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
}