class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        int n = obstacleGrid.length;//行数
        int m = obstacleGrid[0].length;//列数
        int[][] dp = new int[2][m+1];
        int k = 0;
        for(int i=1; i<=n; ++i) {
            for(int j=1; j<=m; ++j) {
                if(obstacleGrid[i-1][j-1] == 1) {
                    dp[k][j] = 0;
                    continue;
                }
                if(i==1 && j==1) dp[k][j] = 1;
                else dp[k][j] = dp[k^1][j]+dp[k][j-1];
            }
            k^=1;
        }
        return dp[(n%2)^1][m];
    }
}