class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) return 0;
        int n = obstacleGrid.length;//行数
        int m = obstacleGrid[0].length;//列数
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; ++i) {
            for(int j=1; j<=m; ++j) {
                if(obstacleGrid[i-1][j-1] == 1) continue;
                if(i==1 && j==1) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}