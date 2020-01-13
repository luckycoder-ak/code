class Solution {
    public double soupServings(int N) {
        if(N>=4800) return 1;
        N = N/25+((N%25==0)?0:1);
        double[][] dp = new double[N+1][N+1];
        Arrays.fill(dp[0],1);
        dp[0][0] = 0.5;
        for(int i=1; i<=N; ++i) {
            for (int j=1; j<=N; ++j) {
                dp[i][j] = 0.25*(dp[(i-4>=0)?(i-4):0][j]+dp[(i-3>=0)?(i-3):0][(j-1>=0)?(j-1):0]+
                        dp[(i-2>=0)?(i-2):0][(j-2>=0)?(j-2):0]+dp[(i-1>=0)?(i-1):0][(j-3>=0)?(j-3):0]);
            }
        }
        return dp[N][N];
    }
}