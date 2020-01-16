class Solution {
    public int findLength(int[] A, int[] B) {
        int alen = A.length;
        int blen = B.length;
        int[][] dp = new int[alen+1][blen+1];
        dp[0][0] = 0;
        int ans = 0;
        for(int i=1; i<=alen; ++i) {
            for(int j=1; j<=blen; ++j) {
                if(A[i-1] == B[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}