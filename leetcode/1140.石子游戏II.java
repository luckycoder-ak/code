class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length; //长度
        int sum = 0;
        // dp[i][j]表示当前是第i波，m = j;
        // dp[i][j]表示当前是第i轮，且m等于j时后面能取得的最大值
        int[][] dp = new int[len+1][len+1];
        // =======================================
        for(int i = len - 1; i >= 0; i--){
            sum += piles[i];// 表示当前所剩下的所有棋子的和
            for(int M = 1; M <= len; M++){
                if(i + 2 * M >= len){ //能够全拿，就全拿走
                    dp[i][M] = sum;
                    continue;
                }
                for(int x = 1; i + x <= len && x <= 2 * M; x++){ //这次拿几个能达到最大值
                    dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(M, x)]);
                }
            }
        }
        return dp[0][1];
    }
}